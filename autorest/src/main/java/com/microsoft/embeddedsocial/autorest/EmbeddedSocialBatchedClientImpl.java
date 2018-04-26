/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.embeddedsocial.autorest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Retrofit;

/**
 * This client implementation should be used for batching only. For regular non-batched requests
 * use EmbeddedSocialClientImpl.
 *
 * This batched client implementation offers an esClient. Calls to esClient are not sent
 * to the server. Instead, calls are intercepted and placed in an array of requests to be later batched.
 * When the array is full (the size of the array is dictated by batchSize), a call to issueBatch
 * should be made. This batch client parses the response to the batch and unblocks each individual
 * esClient call with the corresponding response.
 */

public final class EmbeddedSocialBatchedClientImpl {
    private final String ESUrl;
    private final EmbeddedSocialClientImpl esClient;

    // Arrays of requests and responses that forms the batch
    private final ArrayList<Request> batchReqs;
    private final ArrayList<Response> batchResps;
    private final int batchSize;
    private final CountDownLatch latch;
    private final Object syncObject = new Object();
    private Boolean issueBatchAlreadyCalled = false;
    private boolean batchSuccessful = false;

    private EmbeddedSocialBatchedClientImpl(String ESUrl, int batchSize) {
        this.ESUrl = ESUrl;
        this.batchSize = batchSize;
        this.batchReqs = new ArrayList<>(batchSize);
        this.batchResps = new ArrayList<>(batchSize);
        this.latch = new CountDownLatch(batchSize);

        // Create an okhttp3 client with our own batched interceptor. This interceptor
        // allows us to block the outgoing call and queue it for later batching.
        // We also increase the default maxRequestsPerHost to 32 (our limit to the size of a batch)
        BatchedInterceptor batchedInterceptor = new BatchedInterceptor(this);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(32);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .addInterceptor(batchedInterceptor);

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .client(okHttpClientBuilder.build());

        // The ES client with a doctored interceptor is ready now
        esClient = new EmbeddedSocialClientImpl(ESUrl, okHttpClientBuilder, retrofitBuilder);
    }

    // Adds an individual request to an array of requests to be batched
    private Response addRequestToBatch(Request request) throws IOException {
        int requestIndex;

        // Thread-safe way of inserting request in batch if room
        synchronized(this.batchReqs) {
            // caller should not insert another request into a batch already full
            if (this.batchReqs.size() == this.batchSize) {
                throw new IllegalStateException("Batch is already full");
            }

            // Insert request into batch array, and save its index
            requestIndex = this.batchReqs.size();
            this.batchReqs.add(request);
            this.latch.countDown();
        }

        // Now that the request is in the queue, this interceptor must wait
        // until issueBatch is called.
        synchronized (this.syncObject) {
            try {
                // Calling wait() will block this thread until issueBatch calls notify() on the object.
                this.syncObject.wait();
            } catch (InterruptedException e) {
                // Happens if someone interrupts your thread. Convert this to an IOException.
                throw new IOException(e.getMessage());
            }
        }

        // Throw exception the batch failed
        if (!this.batchSuccessful) {
            throw new IOException("Batch request failed");
        }

        // At this time, all insertions in batchResps are done. No need to lock anymore.
        return this.batchResps.get(requestIndex);
    }

    // Processes the response to the batch. This is called by issueBatch only
    private void processBatchResponse(Response batchResponse) throws IOException  {
        String batchResponseBody = batchResponse.body().string();
        String boundary = batchResponseBody.substring(0, batchResponseBody.indexOf("\n") - 1);

        int fragIndex = 0;
        for (String f : batchResponseBody.split(boundary)) {
            // ignore empty fragments
            if (f.compareTo("") == 0) {
                continue;
            }
            // ignore the delimiter lines
            if (f.contains("--")) {
                continue;
            }

            Response r = MultipartHelper.convertMultiFragmentToResp(f, this.batchReqs.get(fragIndex));
            this.batchResps.add(r);
            fragIndex += 1;
        }
    }

    // Caller must call issue batch to send the batch to ES. This code is not thread-safe,
    // and is assumed that is called exactly once. Returns the HTTP response of the batch call.
    public Response issueBatch() throws InterruptedException, IOException {

        // Check if the issueBatch called already
        synchronized (this.issueBatchAlreadyCalled) {
            if (this.issueBatchAlreadyCalled) {
                throw new IllegalStateException("Batch already issued");
            }
            this.issueBatchAlreadyCalled = true;
        }

        // Wait until all requests inserted in array
        this.latch.await();

        // Create a boundary string
        String boundary = "batch_" + java.util.UUID.randomUUID().toString();

        // The body of the batch will be about 100 bytes * number of requests
        StringBuilder batchBody = new StringBuilder(100 * this.batchSize);

        for (Request r : this.batchReqs) {
            String requestString = MultipartHelper.convertReqToMultiFragment(r);
            batchBody.append("--" + boundary + "\r\n" + requestString + "\r\n");
        }
        batchBody.append("--" + boundary + "--\r\n");

        RequestBody batchReqBody = RequestBody.create(okhttp3.MediaType.parse("text; charset=utf-8"), batchBody.toString());
        Request batchReq = new Request.Builder()
                .addHeader("Content-Type", "multipart/mixed; boundary=" + boundary)
                .url(this.ESUrl + "/batch")
                .post(batchReqBody)
                .build();

        OkHttpClient batchClient = (new OkHttpClient.Builder()).build();
        okhttp3.Call call = batchClient.newCall(batchReq);

        Response batchResponse = call.execute();

        if (batchResponse.isSuccessful()) {
            processBatchResponse(batchResponse);
            this.batchSuccessful = true;
        }

        // Notify the individual interceptors to resume
        synchronized (this.syncObject) {
            this.syncObject.notifyAll();
        }

        return batchResponse;
    }

    public EmbeddedSocialClientImpl getEsClient() {
        return esClient;
    }

    public static final class Builder {
        private String baseUrl;
        private int batchSize;

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder batchSize(int batchSize) {
            this.batchSize = batchSize;
            return this;
        }

        public EmbeddedSocialBatchedClientImpl build() throws IllegalStateException {
            if (baseUrl == null) throw new IllegalStateException("ESUrl == null");
            if (batchSize <= 0) throw new IllegalStateException("batchSize <= 0");
            if (batchSize > 32) throw new IllegalStateException("batchSize cannot be greater than 32.");
            return new EmbeddedSocialBatchedClientImpl(baseUrl, batchSize);
        }
    }

    /**
     * BatchedInterceptor intercepts outgoing requests and adds them to a queue to be batched later
     */
    private class BatchedInterceptor implements Interceptor {
        private EmbeddedSocialBatchedClientImpl esBatchedClient;

        private BatchedInterceptor(EmbeddedSocialBatchedClientImpl esBatchedClient) {
            this.esBatchedClient = esBatchedClient;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            // Intercept the request and call back into the batched client
            return this.esBatchedClient.addRequestToBatch(chain.request());
        }
    }

    /**
     * Converts ES requests to an outgoing multipart fragment, and
     * an incoming multipart fragment to an ES response.
     * (unfortunately, the support for multipart in okhttp is not amenable to ES batch formatting)
     */
    private static class MultipartHelper {
        // Converts request to a multipart fragment
        static String convertReqToMultiFragment(Request req) throws IOException {
            StringBuilder multiFrag = new StringBuilder(100);
            multiFrag
                    .append("Content-Type: application/http; msgtype=request" + "\r\n\r\n")
                    .append(req.method() + " " + req.url().encodedPath() 
                            + "?" + req.url().encodedQuery() 
                            + " HTTP/1.1\r\n")
                    .append("Host: " + req.url().host() + "\r\n")
                    .append("Authorization: " + req.headers().get("Authorization") + "\r\n")
                    .append("Content-Type: application/json\r\nAccept: application/json\r\n\r\n");
            if (req.body() != null) {
                multiFrag.append(bodyToString(req));
            }
            multiFrag.append("\r\n");
            return multiFrag.toString();
        }

        // Convert multipart fragment to response. Method's inputs are the fragment and its
        // corresponding request.
        static Response convertMultiFragmentToResp(String f, Request req) throws IOException {
            // Extract the HTTP error code, content type, and the body of the response
            String[] lines = f.split("\r\n");
            int code = -1;
            String contentType = "";
            String respBody = "";
            for (String l : lines) {
                if (!respBody.isEmpty()) {
                    // If respBody is not empty, this line is part of the body
                    respBody += l;

                    // If the line is close curly bracket, we're done parsing the response
                    if (l.startsWith("}")) {
                        break;
                    }
                } else if (l.startsWith("{")) {
                    respBody += l;
                } else if (l.startsWith("HTTP/1.1")) {
                    // Extract the code. Assume the line has format:
                    // "HTTP/1.1 code XXX
                    // The code sits in between the first space character and the second
                    int indexFirstSpaceChar = 8;
                    int indexSecondSpaceChar = l.indexOf(' ', indexFirstSpaceChar + 1);
                    String tmp = l.substring(indexFirstSpaceChar + 1, indexSecondSpaceChar);
                    code = Integer.parseInt(l.substring(indexFirstSpaceChar + 1, indexSecondSpaceChar));
                } else if (l.startsWith("Content-Type:")) {
                    contentType = l;
                }
            }

            // Build the corresponding response for this fragment
            ResponseBody responseBody = ResponseBody.create(MediaType.parse(contentType), respBody);
            Response.Builder responseBuilder = new Response.Builder();
            return responseBuilder
                    .request(req)
                    .code(code)
                    .protocol(Protocol.HTTP_1_1)
                    .body(responseBody)
                    .build();
        }
    }

    // Convert body of request to string
    private static String bodyToString(final Request request) throws IOException {
        final Request copy = request.newBuilder().build();
        final Buffer buffer = new Buffer();
        copy.body().writeTo(buffer);
        return buffer.readUtf8();
    }
}


package com.microsoft.embeddedsocial.autorest;

import java.io.IOException;


import okhttp3.OkHttpClient;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;


/**
 * Created by ssaroiu on 3/6/2018.
 *
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
    private final Request[] batchReqs;
    private final Response[] batchResps;
    private final int batchSize;
    private int pendingRequests = 0;
    private final Object syncObject = new Object();

    private EmbeddedSocialBatchedClientImpl(String ESUrl, int batchSize) {
        this.ESUrl = ESUrl;
        this.batchSize = batchSize;
        this.batchReqs = new Request[batchSize];
        this.batchResps = new Response[batchSize];

        // Create an okhttp3 client with our own batched interceptor. This interceptor
        // allows us to block the outgoing call and queue it for later batching.
        BatchedInterceptor batchedInterceptor = new BatchedInterceptor(this);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(batchedInterceptor);

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .client(okHttpClientBuilder.build());

        // The ES client with a doctored interceptor is ready now
        esClient = new EmbeddedSocialClientImpl(ESUrl, okHttpClientBuilder, retrofitBuilder);
    }

    // Adds an individual request to an array of requests to be batched
    private Response addRequestToBatch(Request request) throws IOException {
        int requestIndex;
        Response resp;

        synchronized (syncObject) {
            // caller should not insert another request into a batch already full
            if (pendingRequests == batchSize) {
               throw new IllegalStateException("batch is already full");
            }

            // Insert request into batch array
            requestIndex = pendingRequests;
            this.batchReqs[requestIndex] = request;
            pendingRequests += 1;

            // Now that the request is in the queue, this interceptor must wait
            // until issueBatch is called.
            try {
                // Calling wait() will block this thread until issueBatch calls notify() on the object.
                syncObject.wait();
            } catch (InterruptedException e) {
                // Happens if someone interrupts your thread. Convert this to an IOException.
                throw new IOException(e.getMessage());
            }

            resp = this.batchResps[requestIndex];
        }

        return resp;
    }

    // Converts request to a multipart fragment
    private String convertReqToMultiFragment(Request req) throws IOException {
        StringBuilder multiFrag = new StringBuilder(100);
        multiFrag
                .append("Content-Type: application/http; msgtype=request" + "\r\n\r\n")
                .append(req.method() + " " + req.url().encodedPath() + " HTTP/1.1\r\n")
                .append("Host: " + req.url().host() + "\r\n")
                .append("Authorization: " + req.headers().get("Authorization") + "\r\n")
                .append("Content-Type: application/json\r\nAccept: application/json\r\n\r\n");
        if (req.body() != null) {
            multiFrag.append(req.body());
        }
        multiFrag.append("\r\n");
        return multiFrag.toString();
    }

    // Convert multipart fragment to response. Method's inputs are the fragment and its
    // corresponding request.
    private Response convertMultiFragmentToResp(String f, Request req) throws IOException {
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

    // Processes the response to the batch
    private void processBatchResponse(Response batchResponse) throws IOException  {
        String batchResponseBody = batchResponse.body().string();
        String boundary = batchResponseBody.substring(0, batchResponseBody.indexOf("\n") - 1);

        String[] frags = batchResponseBody.split(boundary);
        int fragIndex = 0;
        for (String f : frags) {
            // ignore empty fragments
            if (f.compareTo("") == 0) {
                continue;
            }
            // ignore the delimiter lines
            if (f.contains("--")) {
                continue;
            }

            this.batchResps[fragIndex] = convertMultiFragmentToResp(f, this.batchReqs[fragIndex]);
            fragIndex += 1;
        }
    }

    public boolean isBatchReady() {
        return (pendingRequests == batchSize);
    }

    public void issueBatch() throws InterruptedException, IOException {
        String boundary = "batch_" + java.util.UUID.randomUUID().toString();

        synchronized (syncObject) {
            // The body of the batch will be about 100 bytes * number of requests
            StringBuilder batchBody = new StringBuilder(100 * batchSize);

            for (Request r : batchReqs) {
                String requestString = convertReqToMultiFragment(r);
                batchBody.append("--" + boundary + "\r\n" + requestString + "\r\n");
            }
            batchBody.append("--" + boundary + "--\r\n");

            RequestBody reqBody = RequestBody.create(okhttp3.MediaType.parse("text; charset=utf-8"), batchBody.toString());
            Request req = new Request.Builder()
                    .addHeader("Content-Type", "multipart/mixed; boundary=" + boundary)
                    .url(this.ESUrl + "/batch")
                    .post(reqBody)
                    .build();

            OkHttpClient batchClient = (new OkHttpClient.Builder()).build();
            okhttp3.Call call = batchClient.newCall(req);

            Response batchResponse = call.execute();
            processBatchResponse(batchResponse);

            // Notify the individual interceptors to resume
            syncObject.notifyAll();
        }
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

        public EmbeddedSocialBatchedClientImpl build() {
            if (baseUrl == null) new IllegalStateException("ESUrl == null");
            if (batchSize <= 0) new IllegalStateException("batchSize <= 0");
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
}


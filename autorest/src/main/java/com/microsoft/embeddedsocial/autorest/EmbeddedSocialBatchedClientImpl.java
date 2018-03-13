package com.microsoft.embeddedsocial.autorest;

import com.microsoft.rest.ServiceException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;


import okhttp3.OkHttpClient;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import okio.Buffer;


/**
 * Created by ssaroiu on 3/6/2018.
 *
 * This client implementation should be used for batching only. For regular non-batched requests
 * use EmbeddedSocialClientImpl.
 *
 * This batched client implementation offers an esClient. Calls to esClient are not sent
 * to the server. Instead, calls are intercepted and put on a queue of requests to be later batched.
 * When the queue is full (the size of the queue is dictated by batchSize), a call to issueBatch
 * should be made. This batch client parses the response to the batch and unblocks each individual
 * esClient call with the corresponding response.
 */

public final class EmbeddedSocialBatchedClientImpl {
    private final String ESUrl;
    private final EmbeddedSocialClientImpl esClient;

    // Queues of requests and responses
    private final ArrayBlockingQueue<Request> batchReqQueue;
    private final ArrayBlockingQueue<Response> batchRespQueue;
    private final Object syncObject = new Object();

    private EmbeddedSocialBatchedClientImpl(String ESUrl, int batchSize) {
        this.ESUrl = ESUrl;
        this.batchReqQueue = new ArrayBlockingQueue<Request>(batchSize);
        this.batchRespQueue = new ArrayBlockingQueue<Response>(batchSize);

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

    // Adds an individual request to a queue of requests to be batched
    private Response addRequestToBatchQueue(Request request) throws IOException {
        synchronized (syncObject) {
            // Try adding the request to the queue
            if (!this.batchReqQueue.offer(request)) {
               throw new IllegalStateException("queue is already full");
            }

            // Now that the request is in the queue, this interceptor must wait
            // until issueBatch is called.
            try {
                // Calling wait() will block this thread until issueBatch calls notify() on the object.
                syncObject.wait();
            } catch (InterruptedException e) {
                // Happens if someone interrupts your thread. Convert this to an IOException.
                throw new IOException(e.getMessage());
            }
        }

        // Process the response....

        String contentType = "application/json; charset=utf-8";
        String body = "{\n" +
                "  \"dateAndTime\": \"12/18/2017 4:05:04 PM\",\n" +
                "  \"commitHash\": \"972f802c1608a8ee725fd05ff345de155004e7cd\",\n" +
                "  \"hostname\": \"alecw@debris\",\n" +
                "  \"serviceApiVersion\": \"v0.7\",\n" +
                "  \"dirtyFiles\": []\n" +
                "}";

        ResponseBody responseBody = ResponseBody.create(MediaType.parse(contentType), body);
        Response.Builder responseBuilder = new Response.Builder();
        return responseBuilder
                .request(request)
                .code(200)
                .protocol(Protocol.HTTP_1_1)
                .body(responseBody)
                .build();
    }

    // Converts request to a multipart fragment
    private String convertReqToMultiFragment(Request req) throws IOException {
        StringBuilder multiFrag = new StringBuilder(100);
        multiFrag.append("Content-Type: application/http; msgtype=request" + "\r\n\r\n");
        multiFrag.append(req.method() + " " + req.url().encodedPath() + " HTTP/1.1\r\n");
        multiFrag.append("Host: " + req.url().host() + "\r\n");
        multiFrag.append("Authorization: " + req.headers().get("Authorization") + "\r\n");
        multiFrag.append("Content-Type: application/json\r\nAccept: application/json\r\n\r\n");
        if (req.body() != null) {
            multiFrag.append(req.body());
        }
        multiFrag.append("\r\n");
        return multiFrag.toString();
    }

    private boolean processResponses(okhttp3.Response response) throws ServiceException, IOException {
        String responseBody = response.body().string();
        int actionNum = 0;
        if (responseBody != null) {
            String delimiter = responseBody.substring(0,responseBody.indexOf("\n")-1);
            String[] responses = responseBody.split(delimiter);
            for (String responsePart : responses) {
                // ignore empty lines
                if (responsePart.compareTo("") == 0) {
                    continue;
                }
                // ignore the delimiter lines
                if (responsePart.contains("--")) {
                    continue;
                }
                // actually parse the individual response text (headers + body)
                String[] payloadParts = responsePart.split("\r\n");
                MediaType typ = null;
                Response.Builder builder = new Response.Builder();
                boolean bodyStart = false;
                String bodyStr = "";
                for (int j = 1; j < payloadParts.length; j++) {
                    String part = payloadParts[j];
                    if (part.compareTo("") == 0) {
                        continue;
                    }
                    else if (part.contains(":") && !bodyStart) {
                        if (part.contains("Content-Type")) {
                            MediaType.parse(payloadParts[j]);
                        }
                        String[] headerParts = payloadParts[j].split(":");
                        builder.addHeader(headerParts[0], headerParts[1]);
                    }
                    else if (part.contains("HTTP")) {
                        String[] protoParts = part.split(" ");
                        String code = protoParts[1];
                        String msg = protoParts[2];
                        builder.code(Integer.parseInt(code)).message(msg).protocol(Protocol.HTTP_1_1);
                    }
                    else {
                        bodyStart = true;
                        bodyStr += part;
                    }
                }
                ResponseBody body = ResponseBody.create(typ, bodyStr);
                System.out.println("RESPONSE: \n" + bodyStr);
                Response resp = builder
                        .body(body)
                        .request(response.request())
                        .build();
                //actions.get(actionNum++).processResponse(resp);
            }
        }
        return response.isSuccessful();
    }


    public boolean isBatchReady() {
        return (batchReqQueue.remainingCapacity() == 0);
    }

    public void issueBatch() throws InterruptedException, IOException {
        String boundary = "batch_" + java.util.UUID.randomUUID().toString();

        synchronized (syncObject) {
            // The body of the batch will be about 100 bytes * number of requests
            StringBuilder batchBody = new StringBuilder(100 * batchReqQueue.size());

            for (Request r : this.batchReqQueue) {
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

            OkHttpClient client = (new OkHttpClient.Builder()).build();
            okhttp3.Call call = client.newCall(req);

            try {
                processResponses(call.execute());
            }
            catch (ServiceException e) {
                // Do nothing -- this exception should be thrown by the response parser not by us.
            }

            syncObject.notify();
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
            return this.esBatchedClient.addRequestToBatchQueue(chain.request());
        }
    }
}


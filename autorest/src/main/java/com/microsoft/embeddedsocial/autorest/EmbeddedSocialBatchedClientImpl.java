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
 */

public final class EmbeddedSocialBatchedClientImpl {
    private final Object syncObject = new Object();
    private final ArrayBlockingQueue<Request> queue;
    private final OkHttpClient.Builder okHttpClientBuilder;
    private final Retrofit.Builder retrofitBuilder;
    private final EmbeddedSocialClientImpl esClient;
    private final String ESUrl;

    private EmbeddedSocialBatchedClientImpl(String ESUrl, int batchSize) {
        this.ESUrl = ESUrl;
        this.queue = new ArrayBlockingQueue<Request>(batchSize);

        // Create an okhttp3 client with our own batched interceptor
        BatchedInterceptor batchedInterceptor = new BatchedInterceptor(this);
        okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(batchedInterceptor);

        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .client(okHttpClientBuilder.build());
        esClient = new EmbeddedSocialClientImpl(ESUrl, okHttpClientBuilder, retrofitBuilder);
    }

    private Response addRequestToBatch(Request request) throws IOException {
        synchronized (syncObject) {
            // Try adding the request to the queue
            if (!this.queue.offer(request)) {
               throw new IllegalStateException("batch is already full");
            }

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

    private String prepareReqPart(Request req) throws IOException {
        String headers = "Content-Type: application/http; msgtype=request";
        String reqString = "";
        if (req != null) {
            String auth = req.headers().get("Authorization");
            String url = req.url().encodedPath();
            String host = req.url().host();
            String method = req.method();
            String protocol = req.isHttps() ? "HTTP/1.1" : "HTTP/1.1"; // TODO
            String query = req.url().encodedQuery();
            String body = "";
            if (req.body() != null) {
                final Buffer buffer = new Buffer();
                req.body().writeTo(buffer);
                body = buffer.readUtf8();
            }
            reqString = String.format("%s\r\n\r\n%s %s?%s %s\r\nHost: %s\r\nAuthorization: %s\r\nContent-Type: application/json\r\nAccept: application/json\r\n\r\n%s\r\n",
                    headers, method, url, query, protocol, host, auth, body);
        }
        return reqString;
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
        return (queue.remainingCapacity() == 0);
    }

    public void issueBatch() throws InterruptedException, IOException {
        String boundary = "batch_ebc";
        String boundarysep = "--batch_ebc";

        synchronized (syncObject) {
            // Construct batch request
            List<String> requests = new ArrayList<>(queue.size());

            // The body of the batch will be about 100 bytes * number of requests (aka batchSize)
            StringBuilder batchBody = new StringBuilder(100 * queue.size());

            for (Request r : this.queue) {
                String requestString = prepareReqPart(r);
                requests.add(requestString);
                batchBody.append(boundarysep + "\r\n" + requestString + "\r\n");
            }

            batchBody.append(boundarysep + "--\r\n");

            RequestBody reqBody = RequestBody.create(okhttp3.MediaType.parse("text; charset=utf-8"), batchBody.toString());
            Request req = new Request.Builder()
                    .addHeader("Content-Type", "multipart/mixed; boundary=" + boundary)
                    .url(this.ESUrl + "/batch")
                    .post(reqBody)
                    .build();

            final Buffer buffer = new Buffer();
            req.body().writeTo(buffer);
            OkHttpClient client = (new OkHttpClient.Builder()).build();
            okhttp3.Call call = client.newCall(req);

            System.out.println("REQUEST: \n" + req.url() + "\n" + req.headers()  + "\n"+ buffer.readUtf8());
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
     * BatchedInterceptor intercepts outgoing requests and batches them
     */
    private class BatchedInterceptor implements Interceptor {
        private EmbeddedSocialBatchedClientImpl esBatchedClient;

        private BatchedInterceptor(EmbeddedSocialBatchedClientImpl esBatchedClient) {
            this.esBatchedClient = esBatchedClient;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            return this.esBatchedClient.addRequestToBatch(chain.request());
        }
    }
}


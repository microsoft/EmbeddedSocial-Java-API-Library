package com.microsoft.embeddedsocial.autorest;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;


/**
 * Created by ssaroiu on 3/6/2018.
 */

public final class EmbeddedSocialBatchedClientImpl {
    private final OkHttpClient.Builder okHttpClientBuilder;
    private final Retrofit.Builder retrofitBuilder;
    private final EmbeddedSocialClientImpl esClient;

    private EmbeddedSocialBatchedClientImpl(String ESUrl) {
        // Create an okhttp3 client with our own batched interceptor
        BatchedInterceptor batchedInterceptor = new BatchedInterceptor();
        okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(batchedInterceptor);

        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .client(okHttpClientBuilder.build());
//                .addConverterFactory(GsonConverterFactory.create());

        esClient = new EmbeddedSocialClientImpl(ESUrl, okHttpClientBuilder, retrofitBuilder);
    }

    public EmbeddedSocialClientImpl getEsClient()
    {
        return esClient;
    }

    public static final class Builder
    {
        private String baseUrl;

        public Builder baseUrl(String baseUrl)
        {
            this.baseUrl = baseUrl;
            return this;
        }

        public EmbeddedSocialBatchedClientImpl build()
        {
            if (baseUrl == null) new IllegalStateException("ESUrl == null");
            return new EmbeddedSocialBatchedClientImpl(baseUrl);
        }
    }

    /**
     * BatchedInterceptor intercepts outgoing requests and batches them
     */
    private class BatchedInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            String contentType = "application/json; charset=utf-8";
            String body = "{\n" +
                    "  \"dateAndTime\": \"12/18/2017 4:05:04 PM\",\n" +
                    "  \"commitHash\": \"972f802c1608a8ee725fd05ff345de155004e7cd\",\n" +
                    "  \"hostname\": \"alecw@debris\",\n" +
                    "  \"serviceApiVersion\": \"v0.7\",\n" +
                    "  \"dirtyFiles\": []\n" +
                    "}";

            Request originalRequest = chain.request();
            ResponseBody responseBody = ResponseBody.create(MediaType.parse(contentType), body);
            Response.Builder responseBuilder = new Response.Builder();
            return responseBuilder
                    .request(originalRequest)
                    .code(200)
                    .protocol(Protocol.HTTP_1_1)
                    .body(responseBody)
                    .build();
        }
    }
}


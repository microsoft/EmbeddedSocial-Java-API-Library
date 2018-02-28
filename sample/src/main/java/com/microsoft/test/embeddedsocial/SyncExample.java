package com.microsoft.test.embeddedsocial;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ssaroiu on 2/28/2018.
 *
 * Simple example of making a single synchronous call to ES
 */

public class SyncExample {

    public final OkHttpClient.Builder httpClient;
    public final Retrofit retrofit;

    // Initializes an http client and retrofit
    public SyncExample(String ESUrl)
    {
        httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public  void run() {
        System.out.println("Stefan rules.");
    }
}

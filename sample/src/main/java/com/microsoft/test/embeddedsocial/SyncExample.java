package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperationsImpl;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;
import com.microsoft.rest.ServiceResponse;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ssaroiu on 2/28/2018.
 *
 * Simple example of making a single synchronous call to ES
 */

public class SyncExample {

    // State needed for the autorest library
    public final EmbeddedSocialClientImpl esClient;
    public final OkHttpClient.Builder httpClient;
    public final Retrofit retrofit;

    // State to make the synchronous getBuildsCurrent call
    public final BuildsOperationsImpl buildsOperations;

    // Initializes an http client, retrofit, and an ES client for autorest
    public SyncExample(String ESUrl)
    {
        httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        esClient = new EmbeddedSocialClientImpl(ESUrl);

        buildsOperations = new BuildsOperationsImpl(retrofit, esClient);
    }

    // Makes a single call to getBuildsCurrent
    public  void run()  {
        String apiVersion = "N/A";

        try {
            BuildsCurrentResponse buildsCurrent = buildsOperations.getBuildsCurrent().getBody();
            apiVersion = buildsCurrent.getServiceApiVersion();
        }
        catch(Exception e)
        {
            System.err.println("Call to Embedded Social failed with exception: " +  e.getMessage());
        }

        System.out.println("Stefan rules.");
    }
}

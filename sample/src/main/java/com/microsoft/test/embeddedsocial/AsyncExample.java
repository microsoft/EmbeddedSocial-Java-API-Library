package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperationsImpl;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ssaroiu on 2/28/2018.
 *
 * Simple example of making a single asynchronous call to ES
 */

// Our approach is to make this example implement the service callback.
// This is not the only approach -- you can have a separate class implementing the callback.
public class AsyncExample extends ServiceCallback<BuildsCurrentResponse> {

    // State to make the asynchronous getBuildsCurrent call
    private BuildsOperationsImpl buildsOperations;

    // Initializes an http client, retrofit, and an ES client for autorest
    public AsyncExample(String ESUrl)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ESUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        EmbeddedSocialClientImpl esClient = new EmbeddedSocialClientImpl(ESUrl);

        buildsOperations = new BuildsOperationsImpl(retrofit, esClient);
    }

    // Makes a single asynchronous call to getBuildsCurrent
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

        System.out.println("Synchronous call to ES completed. Returned API version: " + apiVersion);
    }

    // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success

    @Override
    public void failure(Throwable t)
    {
        System.err.println("Call to Embedded Social failed with exception: " +  t.getMessage());
    }

    @Override
    public void success(ServiceResponse<BuildsCurrentResponse> result)
    {
        String apiVersion = "N/A";

        try {
            BuildsCurrentResponse buildsCurrent = result.getBody();
            apiVersion = buildsCurrent.getServiceApiVersion();
        }
        catch(Exception e)
        {
            System.err.println("Call to Embedded Social failed with exception: " +  e.getMessage());
        }

        System.out.println("Synchronous call to ES completed. Returned API version: " + apiVersion);
    }
}

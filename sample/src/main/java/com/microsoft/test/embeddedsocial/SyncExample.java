package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;

/**
 * Created by ssaroiu on 2/28/2018.
 *
 * Simple example of making a single synchronous call to ES
 */

public class SyncExample {

    // State to make the asynchronous getBuildsCurrent call
    private BuildsOperations buildsOperations;

    // Initializes an http client, retrofit, and an ES client for autorest
    public SyncExample(String ESUrl)
    {
        EmbeddedSocialClientImpl esClient = new EmbeddedSocialClientImpl(ESUrl);
        buildsOperations = esClient.getBuildsOperations();
    }

    // Makes a single synchronous call to getBuildsCurrent
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
}

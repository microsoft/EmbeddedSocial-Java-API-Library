package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;

/**
 * Created by ssaroiu on 2/28/2018.
 *
 * Simple example of making a single asynchronous call to ES
 */
public class AsyncTest {

    // State to make the asynchronous getBuildsCurrent call
    private BuildsOperations buildsOperations;

    // Constructor creating a client using only the URL to the ES server
    public AsyncTest(String ESUrl)
    {
        this(new EmbeddedSocialClientImpl(ESUrl));
    }

    // Constructor receiving a pre-created client
    public AsyncTest(EmbeddedSocialClientImpl esClient)
    {
        buildsOperations = esClient.getBuildsOperations();
    }

    // Makes a single asynchronous call to getBuildsCurrent
    public void run()  {
        ServiceCallback<BuildsCurrentResponse> callback = new AsyncExampleServiceCallback();

        try {
            buildsOperations.getBuildsCurrentAsync(callback);
        }
        catch(Exception e)
        {
            System.err.println("Call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    private class AsyncExampleServiceCallback extends ServiceCallback<BuildsCurrentResponse> {

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

            System.out.println("Asynchronous call to ES completed. Returned API version: " + apiVersion);
        }
    }
}


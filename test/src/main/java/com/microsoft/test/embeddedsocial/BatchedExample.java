package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialBatchedClientImpl;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;

/**
 * Created by ssaroiu on 3/6/2018.
 */

public class BatchedExample {
    private EmbeddedSocialBatchedClientImpl esBatchClient;
    private final int k;

    // Initializes an ES client that supports batching
    public BatchedExample(String ESUrl, int k)
    {
        this.k = k;
        EmbeddedSocialBatchedClientImpl.Builder esBatchedClientBuilder = new EmbeddedSocialBatchedClientImpl.Builder().baseUrl(ESUrl).batchSize(k);
        this.esBatchClient = esBatchedClientBuilder.build();
    }

    public void run() {
        // Makes k requests using the batch client
        for (int i = 0; i < k; i += 1) {
            AsyncExample asyncExample = new AsyncExample(this.esBatchClient.getEsClient());
            asyncExample.run();
        }

        // Issue the batch
        try {
            System.out.println("Issuing batch request...");
            this.esBatchClient.issueBatch();
        }
        catch (Exception e) {
            System.err.println("Batched call failed with exception: " +  e.getMessage());
        }
    }
}

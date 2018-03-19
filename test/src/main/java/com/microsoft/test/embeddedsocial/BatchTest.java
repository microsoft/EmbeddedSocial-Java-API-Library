package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialBatchedClientImpl;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;

/**
 * Created by ssaroiu on 3/6/2018.
 */

public class BatchTest {
    private EmbeddedSocialBatchedClientImpl esBatchClient;
    private final int k;

    // Initializes an ES client that supports batching
    public BatchTest(String ESUrl, int k)
    {
        this.k = k;
        EmbeddedSocialBatchedClientImpl.Builder esBatchedClientBuilder = new EmbeddedSocialBatchedClientImpl.Builder().baseUrl(ESUrl).batchSize(k);
        this.esBatchClient = esBatchedClientBuilder.build();
    }

    public void run() {
        // Makes k requests using the batch client
        for (int i = 0; i < k; i += 1) {
            AsyncTest asyncTest = new AsyncTest(this.esBatchClient.getEsClient());
            asyncTest.run();
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

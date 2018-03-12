package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialBatchedClientImpl;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;

/**
 * Created by ssaroiu on 3/6/2018.
 */

public class BatchedExample {
    private EmbeddedSocialClientImpl esClient;

    // Initializes an ES client that supports batching
    public BatchedExample(String ESUrl)
    {
        EmbeddedSocialBatchedClientImpl.Builder esBatchedClientBuilder = new EmbeddedSocialBatchedClientImpl.Builder().baseUrl(ESUrl);
        this.esClient = esBatchedClientBuilder.build().getEsClient();
    }

    // Batches k requests into a single call to Embedded Social server
    public void run(int k) {
        for (int i = 0; i < k; i += 1) {
            AsyncExample asyncExample = new AsyncExample(this.esClient);
            asyncExample.run();
        }
    }

}

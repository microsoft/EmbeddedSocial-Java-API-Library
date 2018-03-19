package com.microsoft.test.embeddedsocial;

/**
 * Created by ssaroiu on 2/28/2018.
 */

public class Main {
    // Url to Embedded Social instance (use PPE for this example)
    private final static String ESUrl = "https://ppe.embeddedsocial.microsoft.com";

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest(ESUrl);
        AsyncTest asyncTest = new AsyncTest(ESUrl);
        BatchTest batchTest = new BatchTest(ESUrl, 1);

        // syncTest makes single synchronous call
//        syncTest.run();

        // asyncTest makes single asynchronous call
//        asyncTest.run();

        // batchTest makes single batched call
        batchTest.run();
    }
}

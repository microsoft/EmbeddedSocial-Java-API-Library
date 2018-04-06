/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.test.embeddedsocial;

public class Main {
    // Url to Embedded Social instance (use PPE for this example)
    private final static String ESUrl = "https://api.embeddedsocial.microsoft.com";

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest(ESUrl);
        AsyncTest asyncTest = new AsyncTest(ESUrl);
        BatchTest batchTest = new BatchTest(ESUrl, 1);

        // syncTest makes single synchronous call
        syncTest.run();

        // asyncTest makes single asynchronous call
        asyncTest.run();

        // batchTest makes single batched call
        batchTest.run();
    }
}

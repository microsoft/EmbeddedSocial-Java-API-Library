/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.test.embeddedsocial;

public class Main {
    // Url to Embedded Social instance (use PPE for this example)
    private final static String esUrl = "https://ppe.embeddedsocial.microsoft.com";
    private final static String auth = "_FILL_WITH_AUTH_";

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest(esUrl);
        AsyncTest asyncTest = new AsyncTest(esUrl);
        BatchTest batchTest = new BatchTest(esUrl, 1);
        PostUserAsyncTest postUserAsyncTest = new PostUserAsyncTest(esUrl, auth);

        // syncTest makes single synchronous call
        syncTest.run();

        // asyncTest makes single asynchronous call
        asyncTest.run();

        // batchTest makes single batched call
        batchTest.run();

        // All calls made from this point request a proper auth
        postUserAsyncTest.run();
    }
}

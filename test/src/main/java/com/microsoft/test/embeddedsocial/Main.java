/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.test.embeddedsocial;

public class Main {
    // Url to Embedded Social instance (use PPE for this example)
    private final static String esUrl = "https://ppe.embeddedsocial.microsoft.com";

    // ES accepts access tokens from Facebook, MSA, Google, and Twitter.
    // Here's a short set of instructions on how to obtain an access token from MSA:
    // 1) Put this URL in browser:
    // https://login.live.com/oauth20_authorize.srf?client_id=0000000040169587&scope=wl.signin%20wl.basic&response_type=token&redirect_uri=http://research.microsoft.com
    // Follow the login steps with MSA account (note that you can use your Hotmail/Outlook/Google e-mail address)
    // 2) Redirects to RMC - copy the redirected URL in MyURL constant below ...
    // Will look like this:
    // https://www.microsoft.com/en-us/research/#access_token=_long_access_token_&token_type=bearer&expires_in=3600&..._more_more_..."
    // Extract the access token by hand from the string above and create an auth string that looks like:
    // "Microsoft AK=_your_app_key|TK=_access_token_"
    private final static String auth = "Microsoft AK=_your_app_key|TK=_your_token_";

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest(esUrl);
        AsyncTest asyncTest = new AsyncTest(esUrl);
        BatchTest batchTest = new BatchTest(esUrl, 1);
        UserTopicCommentAsyncTest userTopicCommentAsyncTest = new UserTopicCommentAsyncTest(esUrl, auth);

        // syncTest makes single synchronous call
        syncTest.run();

        // asyncTest makes single asynchronous call
        asyncTest.run();

        // batchTest makes single batched call
        batchTest.run();

        // All calls made from this point request a proper auth
        userTopicCommentAsyncTest.postUser();

        // Wait 1 seconds for the call to complete
        SleepOneSecond();

        userTopicCommentAsyncTest.postTopic();
        SleepOneSecond();
        userTopicCommentAsyncTest.postComment();
        SleepOneSecond();
        userTopicCommentAsyncTest.deleteComment();
        SleepOneSecond();
        userTopicCommentAsyncTest.deleteTopic();
        SleepOneSecond();
        userTopicCommentAsyncTest.deleteUser();
    }

    public static void SleepOneSecond() {
        try {
            Thread.sleep(1 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

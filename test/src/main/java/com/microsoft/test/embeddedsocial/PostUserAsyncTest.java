/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.BuildsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.UsersOperations;
import com.microsoft.embeddedsocial.autorest.models.BuildsCurrentResponse;
import com.microsoft.embeddedsocial.autorest.models.PostUserRequest;
import com.microsoft.embeddedsocial.autorest.models.PostUserResponse;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;

/**
 * Example of creating a user with an asynchronous call to ES
 */
public class PostUserAsyncTest {

    // State to make the asynchronous postUser call
    private UsersOperations usersOperations;

    // authorization string
    private final String auth;

    // Constructor creating a client using only the URL to the ES server
    public PostUserAsyncTest(String esUrl, String auth) { this(new EmbeddedSocialClientImpl(esUrl), auth); }

    // Constructor receiving a pre-created client
    public PostUserAsyncTest(EmbeddedSocialClientImpl esClient, String auth)
    {
        usersOperations = esClient.getUsersOperations();
        this.auth = auth;
    }

    // Makes a single asynchronous call to postUser
    public void run()  {
        ServiceCallback<PostUserResponse> callback = new PostUserServiceCallback();
        PostUserRequest userRequest = new PostUserRequest();
        userRequest.setInstanceId("ES-Java-Api-Test");
        userRequest.setFirstName("Alan");
        userRequest.setLastName("Turing");

        try {
            usersOperations.postUserAsync(userRequest, auth, callback);
        }
        catch(Exception e)
        {
            System.err.println("Call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    private class PostUserServiceCallback extends ServiceCallback<PostUserResponse> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t)
        {
            System.err.println("Call to Embedded Social failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<PostUserResponse> result)
        {
            String userHandle = null;
            try {
                PostUserResponse userResponse = result.getBody();
                userHandle = userResponse.getUserHandle();
            }
            catch(Exception e)
            {
                System.err.println("User was not created. HTTP error code: " +  result.getResponse().code());
            }

            System.out.println("User created successfully with user handle: " + userHandle);
        }
    }
}
/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.UsersOperations;
import com.microsoft.embeddedsocial.autorest.models.PostUserRequest;
import com.microsoft.embeddedsocial.autorest.models.PostUserResponse;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;

/**
 * Example of creating/deleting a user with an asynchronous call to ES
 */
public class UserAsyncTest {

    // State to make the asynchronous postUser call
    private UsersOperations usersOperations;

    // authorization string
    private final String auth;

    // Constructor creating a client using only the URL to the ES server
    public UserAsyncTest(String esUrl, String auth) { this(new EmbeddedSocialClientImpl(esUrl), auth); }

    // Constructor receiving a pre-created client
    public UserAsyncTest(EmbeddedSocialClientImpl esClient, String auth)
    {
        usersOperations = esClient.getUsersOperations();
        this.auth = auth;
    }

    // Makes a single asynchronous call to postUser
    public void postUser()  {
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
            System.err.println("PostUser call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    // Makes a single asynchronous call to deleteUser
    public void deleteUser()  {
        ServiceCallback<Object> callback = new DeleteUserServiceCallback();

        try {
            usersOperations.deleteUserAsync(auth, callback);
        }
        catch(Exception e)
        {
            System.err.println("DeleteUser call to Embedded Social failed with exception: " +  e.getMessage());
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

    private class DeleteUserServiceCallback extends ServiceCallback<Object> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t)
        {
            System.err.println("Call to Embedded Social failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<Object> result)
        {
            String userHandle = null;

            if (result.getResponse().code() != 204)
            {
                System.err.println("User was not deleted. HTTP error code: " +  result.getResponse().code());
            }

            System.out.println("User deleted successfully.");
        }
    }
}
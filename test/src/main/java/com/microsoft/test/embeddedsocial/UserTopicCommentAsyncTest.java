/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.test.embeddedsocial;

import com.microsoft.embeddedsocial.autorest.CommentsOperations;
import com.microsoft.embeddedsocial.autorest.EmbeddedSocialClientImpl;
import com.microsoft.embeddedsocial.autorest.TopicCommentsOperations;
import com.microsoft.embeddedsocial.autorest.TopicsOperations;
import com.microsoft.embeddedsocial.autorest.UsersOperations;
import com.microsoft.embeddedsocial.autorest.models.PostCommentRequest;
import com.microsoft.embeddedsocial.autorest.models.PostCommentResponse;
import com.microsoft.embeddedsocial.autorest.models.PostTopicRequest;
import com.microsoft.embeddedsocial.autorest.models.PostTopicResponse;
import com.microsoft.embeddedsocial.autorest.models.PostUserRequest;
import com.microsoft.embeddedsocial.autorest.models.PostUserResponse;
import com.microsoft.embeddedsocial.autorest.models.PublisherType;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;

/**
 * Example of creating/deleting a user, a topic, and a comment with an asynchronous call to ES
 */
public class UserTopicCommentAsyncTest {

    // State to make the asynchronous user calls
    private final UsersOperations usersOperations;

    // State to make the asynchronous topic calls
    private final TopicsOperations topicsOperations;

    // State to make the asynchronous topicComment calls
    private final TopicCommentsOperations topicCommentsOperations;

    // State to make the asynchronous comment calls
    private final CommentsOperations commentsOperations;

    // authorization string
    private final String auth;

    // Internal state -- handles to user, topics, and comments
    private String userHandle;
    private String topicHandle;
    private String commentHandle;

    // Constructor creating a client using only the URL to the ES server
    public UserTopicCommentAsyncTest(String esUrl, String auth) { this(new EmbeddedSocialClientImpl(esUrl), auth); }

    // Constructor receiving a pre-created client
    public UserTopicCommentAsyncTest(EmbeddedSocialClientImpl esClient, String auth)
    {
        usersOperations = esClient.getUsersOperations();
        topicsOperations = esClient.getTopicsOperations();
        topicCommentsOperations = esClient.getTopicCommentsOperations();
        commentsOperations = esClient.getCommentsOperations();
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

    public void postTopic()
    {
        ServiceCallback<PostTopicResponse> callback = new PostTopicServiceCallback();
        PostTopicRequest topicRequest = new PostTopicRequest();
        topicRequest.setPublisherType(PublisherType.USER);
        topicRequest.setText("Lorem ipsum.");

        try {
            topicsOperations.postTopicAsync(topicRequest, auth, callback);
        }
        catch(Exception e)
        {
            System.err.println("PostTopic call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    // Makes a single asynchronous call to deleteTopic
    public void deleteTopic()  {
        ServiceCallback<Object> callback = new DeleteTopicServiceCallback();

        try {
            topicsOperations.deleteTopicAsync(this.topicHandle, auth, callback);
        }
        catch(Exception e)
        {
            System.err.println("DeleteTopic call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    public void postComment()
    {
        ServiceCallback<PostCommentResponse> callback = new PostCommentServiceCallback();
        PostCommentRequest commentRequest = new PostCommentRequest();
        commentRequest.setText("Lorem ipsum.");

        try {
            topicCommentsOperations.postCommentAsync(topicHandle, commentRequest, auth, callback);
        }
        catch(Exception e) {
            System.err.println("PostComment call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    // Makes a single asynchronous call to deleteComment
    public void deleteComment()  {
        ServiceCallback<Object> callback = new DeleteCommentServiceCallback();

        try {
            commentsOperations.deleteCommentAsync(this.commentHandle, auth, callback);
        }
        catch(Exception e)
        {
            System.err.println("DeleteComment call to Embedded Social failed with exception: " +  e.getMessage());
        }
    }

    private class PostUserServiceCallback extends ServiceCallback<PostUserResponse> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t) {
            System.err.println("PostUser call failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<PostUserResponse> result) {
            try {
                PostUserResponse userResponse = result.getBody();
                UserTopicCommentAsyncTest.this.userHandle = userResponse.getUserHandle();
            }
            catch(Exception e) {
                System.err.println("User was not created. HTTP error code: " +  result.getResponse().code());
                return;
            }

            System.out.println("User created successfully with user handle: " + UserTopicCommentAsyncTest.this.userHandle);
        }
    }

    private class DeleteUserServiceCallback extends ServiceCallback<Object> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t) {
            System.err.println("DeleteUser call failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<Object> result)
        {
            if (result.getResponse().code() != 204) {
                System.err.println("User was not deleted. HTTP error code: " +  result.getResponse().code());
            }
            else {
                System.out.println("User deleted successfully.");
            }
        }
    }

    private class PostTopicServiceCallback extends ServiceCallback<PostTopicResponse> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t) {
            System.err.println("PostTopic call failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<PostTopicResponse> result)
        {
            try {
                PostTopicResponse topicResponse = result.getBody();
                UserTopicCommentAsyncTest.this.topicHandle = topicResponse.getTopicHandle();
            }
            catch(Exception e) {
                System.err.println("Topic was not created. HTTP error code: " +  result.getResponse().code());
                return;
            }

            System.out.println("Topic created successfully with topic handle: " + UserTopicCommentAsyncTest.this.topicHandle);
        }
    }

    private class DeleteTopicServiceCallback extends ServiceCallback<Object> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t) {
            System.err.println("DeleteTopic call failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<Object> result)
        {
            if (result.getResponse().code() != 204) {
                System.err.println("Topic was not deleted. HTTP error code: " +  result.getResponse().code());
            }
            else {
                System.out.println("Topic deleted successfully.");
            }
        }
    }

    private class PostCommentServiceCallback extends ServiceCallback<PostCommentResponse> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t) {
            System.err.println("PostComment call failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<PostCommentResponse> result)
        {
            try {
                PostCommentResponse commentResponse = result.getBody();
                UserTopicCommentAsyncTest.this.commentHandle = commentResponse.getCommentHandle();
            }
            catch(Exception e) {
                System.err.println("Comment was not created. HTTP error code: " +  result.getResponse().code());
                return;
            }

            System.out.println("Comment created successfully with comment handle: " + UserTopicCommentAsyncTest.this.commentHandle);
        }
    }

    private class DeleteCommentServiceCallback extends ServiceCallback<Object> {

        // By extending the ServiceCallback abstract class, we must implement two new methods: failure and success
        @Override
        public void failure(Throwable t) {
            System.err.println("DeleteComment call failed with exception: " +  t.getMessage());
        }

        @Override
        public void success(ServiceResponse<Object> result)
        {
            if (result.getResponse().code() != 204) {
                System.err.println("Comment was not deleted. HTTP error code: " +  result.getResponse().code());
            }
            else {
                System.out.println("Comment deleted successfully.");
            }
        }
    }
}
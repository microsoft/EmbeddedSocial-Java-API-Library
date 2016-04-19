/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest;

import java.util.List;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import com.microsoft.rest.AutoRestBaseUrl;
import com.microsoft.rest.serializer.JacksonMapperAdapter;

/**
 * The interface for SocialPlusClient class.
 */
public interface SocialPlusClient {
    /**
     * Gets the URL used as the base for all cloud service requests.
     *
     * @return the BaseUrl object.
     */
    AutoRestBaseUrl getBaseUrl();

    /**
     * Gets the list of interceptors the OkHttp client will execute.
     *
     * @return the list of interceptors.
     */
    List<Interceptor> getClientInterceptors();

    /**
     * Sets the logging level for OkHttp client.
     *
     * @param logLevel the logging level enum.
     */
    void setLogLevel(Level logLevel);

    /**
     * Gets the adapter for {@link com.fasterxml.jackson.databind.ObjectMapper} for serialization
     * and deserialization operations..
     *
     * @return the adapter.
     */
    JacksonMapperAdapter getMapperAdapter();

    /**
     * Gets the BlobsOperations object to access its operations.
     * @return the BlobsOperations object.
     */
    BlobsOperations getBlobsOperations();

    /**
     * Gets the BuildsOperations object to access its operations.
     * @return the BuildsOperations object.
     */
    BuildsOperations getBuildsOperations();

    /**
     * Gets the CommentsOperations object to access its operations.
     * @return the CommentsOperations object.
     */
    CommentsOperations getCommentsOperations();

    /**
     * Gets the TopicCommentsOperations object to access its operations.
     * @return the TopicCommentsOperations object.
     */
    TopicCommentsOperations getTopicCommentsOperations();

    /**
     * Gets the HashtagsOperations object to access its operations.
     * @return the HashtagsOperations object.
     */
    HashtagsOperations getHashtagsOperations();

    /**
     * Gets the ImagesOperations object to access its operations.
     * @return the ImagesOperations object.
     */
    ImagesOperations getImagesOperations();

    /**
     * Gets the TopicLikesOperations object to access its operations.
     * @return the TopicLikesOperations object.
     */
    TopicLikesOperations getTopicLikesOperations();

    /**
     * Gets the ReplyLikesOperations object to access its operations.
     * @return the ReplyLikesOperations object.
     */
    ReplyLikesOperations getReplyLikesOperations();

    /**
     * Gets the CommentLikesOperations object to access its operations.
     * @return the CommentLikesOperations object.
     */
    CommentLikesOperations getCommentLikesOperations();

    /**
     * Gets the MyNotificationsOperations object to access its operations.
     * @return the MyNotificationsOperations object.
     */
    MyNotificationsOperations getMyNotificationsOperations();

    /**
     * Gets the MyPinsOperations object to access its operations.
     * @return the MyPinsOperations object.
     */
    MyPinsOperations getMyPinsOperations();

    /**
     * Gets the MyPushRegistrationsOperations object to access its operations.
     * @return the MyPushRegistrationsOperations object.
     */
    MyPushRegistrationsOperations getMyPushRegistrationsOperations();

    /**
     * Gets the RepliesOperations object to access its operations.
     * @return the RepliesOperations object.
     */
    RepliesOperations getRepliesOperations();

    /**
     * Gets the CommentRepliesOperations object to access its operations.
     * @return the CommentRepliesOperations object.
     */
    CommentRepliesOperations getCommentRepliesOperations();

    /**
     * Gets the UserReportsOperations object to access its operations.
     * @return the UserReportsOperations object.
     */
    UserReportsOperations getUserReportsOperations();

    /**
     * Gets the TopicReportsOperations object to access its operations.
     * @return the TopicReportsOperations object.
     */
    TopicReportsOperations getTopicReportsOperations();

    /**
     * Gets the ReplyReportsOperations object to access its operations.
     * @return the ReplyReportsOperations object.
     */
    ReplyReportsOperations getReplyReportsOperations();

    /**
     * Gets the CommentReportsOperations object to access its operations.
     * @return the CommentReportsOperations object.
     */
    CommentReportsOperations getCommentReportsOperations();

    /**
     * Gets the SearchOperations object to access its operations.
     * @return the SearchOperations object.
     */
    SearchOperations getSearchOperations();

    /**
     * Gets the SessionsOperations object to access its operations.
     * @return the SessionsOperations object.
     */
    SessionsOperations getSessionsOperations();

    /**
     * Gets the RequestTokensOperations object to access its operations.
     * @return the RequestTokensOperations object.
     */
    RequestTokensOperations getRequestTokensOperations();

    /**
     * Gets the UserFollowersOperations object to access its operations.
     * @return the UserFollowersOperations object.
     */
    UserFollowersOperations getUserFollowersOperations();

    /**
     * Gets the MyPendingUsersOperations object to access its operations.
     * @return the MyPendingUsersOperations object.
     */
    MyPendingUsersOperations getMyPendingUsersOperations();

    /**
     * Gets the MyFollowersOperations object to access its operations.
     * @return the MyFollowersOperations object.
     */
    MyFollowersOperations getMyFollowersOperations();

    /**
     * Gets the MyFollowingOperations object to access its operations.
     * @return the MyFollowingOperations object.
     */
    MyFollowingOperations getMyFollowingOperations();

    /**
     * Gets the MyBlockedUsersOperations object to access its operations.
     * @return the MyBlockedUsersOperations object.
     */
    MyBlockedUsersOperations getMyBlockedUsersOperations();

    /**
     * Gets the UserFollowingOperations object to access its operations.
     * @return the UserFollowingOperations object.
     */
    UserFollowingOperations getUserFollowingOperations();

    /**
     * Gets the TopicsOperations object to access its operations.
     * @return the TopicsOperations object.
     */
    TopicsOperations getTopicsOperations();

    /**
     * Gets the MyTopicsOperations object to access its operations.
     * @return the MyTopicsOperations object.
     */
    MyTopicsOperations getMyTopicsOperations();

    /**
     * Gets the MyAppFollowingOperations object to access its operations.
     * @return the MyAppFollowingOperations object.
     */
    MyAppFollowingOperations getMyAppFollowingOperations();

    /**
     * Gets the MyAppsOperations object to access its operations.
     * @return the MyAppsOperations object.
     */
    MyAppsOperations getMyAppsOperations();

    /**
     * Gets the MyLikesOperations object to access its operations.
     * @return the MyLikesOperations object.
     */
    MyLikesOperations getMyLikesOperations();

    /**
     * Gets the MyLinkedAccountsOperations object to access its operations.
     * @return the MyLinkedAccountsOperations object.
     */
    MyLinkedAccountsOperations getMyLinkedAccountsOperations();

    /**
     * Gets the UsersOperations object to access its operations.
     * @return the UsersOperations object.
     */
    UsersOperations getUsersOperations();

    /**
     * Gets the UserTopicsOperations object to access its operations.
     * @return the UserTopicsOperations object.
     */
    UserTopicsOperations getUserTopicsOperations();

}

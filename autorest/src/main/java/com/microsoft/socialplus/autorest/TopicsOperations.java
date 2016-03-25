/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.FeedResponseTopicView;
import com.microsoft.socialplus.autorest.models.PostTopicRequest;
import com.microsoft.socialplus.autorest.models.PostTopicResponse;
import com.microsoft.socialplus.autorest.models.PutTopicRequest;
import com.microsoft.socialplus.autorest.models.TimeRange;
import com.microsoft.socialplus.autorest.models.TopicView;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in TopicsOperations.
 */
public interface TopicsOperations {
    /**
     * Get recent topics.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getTopics() throws ServiceException, IOException;

    /**
     * Get recent topics.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getTopicsAsync(final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get recent topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getTopics(String cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException;

    /**
     * Get recent topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getTopicsAsync(String cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;

    /**
     * Create a new topic.
     *
     * @param request Post topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostTopicResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostTopicResponse> postTopic(PostTopicRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new topic.
     *
     * @param request Post topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postTopicAsync(PostTopicRequest request, String authorization, final ServiceCallback<PostTopicResponse> serviceCallback) throws IllegalArgumentException;

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the TopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<TopicView> getTopic(String topicHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getTopicAsync(String topicHandle, final ServiceCallback<TopicView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the TopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<TopicView> getTopic(String topicHandle, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getTopicAsync(String topicHandle, String appkey, String authorization, final ServiceCallback<TopicView> serviceCallback) throws IllegalArgumentException;

    /**
     * Update topic.
     *
     * @param topicHandle Topic handle
     * @param request Put topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> putTopic(String topicHandle, PutTopicRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Update topic.
     *
     * @param topicHandle Topic handle
     * @param request Put topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall putTopicAsync(String topicHandle, PutTopicRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Delete topic.
     *
     * @param topicHandle Topic handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteTopic(String topicHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete topic.
     *
     * @param topicHandle Topic handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteTopicAsync(String topicHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getPopularTopics(TimeRange timeRange) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPopularTopicsAsync(TimeRange timeRange, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getPopularTopics(TimeRange timeRange, Integer cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPopularTopicsAsync(TimeRange timeRange, Integer cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;

    /**
     * Get featured topics.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getFeaturedTopics() throws ServiceException, IOException;

    /**
     * Get featured topics.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getFeaturedTopicsAsync(final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get featured topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getFeaturedTopics(String cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException;

    /**
     * Get featured topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getFeaturedTopicsAsync(String cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;

}

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
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in UserTopicsOperations.
 */
public interface UserTopicsOperations {
    /**
     * Get user topics sorted by creation time.
     *
     * @param userHandle User handle
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getTopics(String userHandle, String cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get user topics sorted by creation time.
     *
     * @param userHandle User handle
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getTopicsAsync(String userHandle, String cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;

    /**
     * Get user topics sorted by popularity.
     *
     * @param userHandle User handle
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseTopicView> getPopularTopics(String userHandle, Integer cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get user topics sorted by popularity.
     *
     * @param userHandle User handle
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPopularTopicsAsync(String userHandle, Integer cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException;

}

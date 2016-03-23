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
import com.microsoft.socialplus.autorest.models.FeedResponseUserCompactView;
import com.microsoft.socialplus.autorest.models.PostFollowerRequest;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in MyFollowersOperations.
 */
public interface MyFollowersOperations {
    /**
     * Get my followers.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseUserCompactView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserCompactView> getFollowers(String authorization, String cursor, Integer limit) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my followers.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getFollowersAsync(String authorization, String cursor, Integer limit, final ServiceCallback<FeedResponseUserCompactView> serviceCallback) throws IllegalArgumentException;

    /**
     * Accept follower request.
     *
     * @param request Post follower request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> postFollower(PostFollowerRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Accept follower request.
     *
     * @param request Post follower request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postFollowerAsync(PostFollowerRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Remove follower.
     *
     * @param userHandle User handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteFollower(String userHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Remove follower.
     *
     * @param userHandle User handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteFollowerAsync(String userHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

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
import com.microsoft.socialplus.autorest.models.CountResponse;
import com.microsoft.socialplus.autorest.models.FeedResponseUserCompactView;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in MyPendingUsersOperations.
 */
public interface MyPendingUsersOperations {
    /**
     * Reject follower request.
     *
     * @param userHandle User handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deletePendingUser(String userHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Reject follower request.
     *
     * @param userHandle User handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deletePendingUserAsync(String userHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Get my pending users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseUserCompactView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserCompactView> getPendingUsers(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my pending users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPendingUsersAsync(String authorization, final ServiceCallback<FeedResponseUserCompactView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get my pending users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseUserCompactView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserCompactView> getPendingUsers(String authorization, String cursor, Integer limit) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my pending users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPendingUsersAsync(String authorization, String cursor, Integer limit, final ServiceCallback<FeedResponseUserCompactView> serviceCallback) throws IllegalArgumentException;

    /**
     * Get my pending users count.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CountResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<CountResponse> getPendingUsersCount(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my pending users count.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPendingUsersCountAsync(String authorization, final ServiceCallback<CountResponse> serviceCallback) throws IllegalArgumentException;

}

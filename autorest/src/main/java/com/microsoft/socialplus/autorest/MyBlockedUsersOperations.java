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
import com.microsoft.socialplus.autorest.models.PostBlockedUserRequest;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in MyBlockedUsersOperations.
 */
public interface MyBlockedUsersOperations {
    /**
     * Get my blocked users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseUserCompactView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserCompactView> getBlockedUsers(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my blocked users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getBlockedUsersAsync(String authorization, final ServiceCallback<FeedResponseUserCompactView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get my blocked users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseUserCompactView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserCompactView> getBlockedUsers(String authorization, String cursor, Integer limit) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my blocked users.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getBlockedUsersAsync(String authorization, String cursor, Integer limit, final ServiceCallback<FeedResponseUserCompactView> serviceCallback) throws IllegalArgumentException;

    /**
     * Block user.
     *
     * @param request Post blocked user request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> postBlockedUser(PostBlockedUserRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Block user.
     *
     * @param request Post blocked user request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postBlockedUserAsync(PostBlockedUserRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Unblock user.
     *
     * @param userHandle User handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteBlockedUser(String userHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Unblock user.
     *
     * @param userHandle User handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteBlockedUserAsync(String userHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

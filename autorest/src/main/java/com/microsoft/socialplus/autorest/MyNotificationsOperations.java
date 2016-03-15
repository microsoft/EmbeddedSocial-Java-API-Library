/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.CountResponse;
import com.microsoft.socialplus.autorest.models.FeedResponseActivityView;
import com.microsoft.socialplus.autorest.models.PutNotificationsStatusRequest;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in MyNotificationsOperations.
 */
public interface MyNotificationsOperations {
    /**
     * Update notifications status.
     *
     * @param request Put notifications status request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> putNotificationsStatus(PutNotificationsStatusRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Update notifications status.
     *
     * @param request Put notifications status request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall putNotificationsStatusAsync(PutNotificationsStatusRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Get notifications.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseActivityView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseActivityView> getNotifications(String authorization, String cursor, Integer limit) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get notifications.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getNotificationsAsync(String authorization, String cursor, Integer limit, final ServiceCallback<FeedResponseActivityView> serviceCallback) throws IllegalArgumentException;

    /**
     * Get unread notifications count.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CountResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<CountResponse> getNotificationsCount(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get unread notifications count.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getNotificationsCountAsync(String authorization, final ServiceCallback<CountResponse> serviceCallback) throws IllegalArgumentException;

}

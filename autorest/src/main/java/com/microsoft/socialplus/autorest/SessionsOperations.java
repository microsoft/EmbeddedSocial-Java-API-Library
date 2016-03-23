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
import com.microsoft.socialplus.autorest.models.PostSessionRequest;
import com.microsoft.socialplus.autorest.models.PostSessionResponse;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in SessionsOperations.
 */
public interface SessionsOperations {
    /**
     * Create a new session (sign in).
     *
     * @param request Post session request
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostSessionResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostSessionResponse> postSession(PostSessionRequest request, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new session (sign in).
     *
     * @param request Post session request
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postSessionAsync(PostSessionRequest request, String appkey, String authorization, final ServiceCallback<PostSessionResponse> serviceCallback) throws IllegalArgumentException;

    /**
     * Delete the current session (sign out).
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteSession(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete the current session (sign out).
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteSessionAsync(String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

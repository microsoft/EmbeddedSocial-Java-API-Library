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
import com.microsoft.socialplus.autorest.models.BuildsCurrentResponse;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in BuildsOperations.
 */
public interface BuildsOperations {
    /**
     * The build information for this service.
     * This API is meant to be called by humans for debugging.
     *
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the BuildsCurrentResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<BuildsCurrentResponse> getBuildsCurrent(String appkey, String authorization) throws ServiceException, IOException;

    /**
     * The build information for this service.
     * This API is meant to be called by humans for debugging.
     *
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getBuildsCurrentAsync(String appkey, String authorization, final ServiceCallback<BuildsCurrentResponse> serviceCallback) throws IllegalArgumentException;

}

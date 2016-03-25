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
import com.microsoft.socialplus.autorest.models.GetRequestTokenResponse;
import com.microsoft.socialplus.autorest.models.IdentityProvider;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in RequestTokensOperations.
 */
public interface RequestTokensOperations {
    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the GetRequestTokenResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<GetRequestTokenResponse> getRequestToken(IdentityProvider identityProvider) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getRequestTokenAsync(IdentityProvider identityProvider, final ServiceCallback<GetRequestTokenResponse> serviceCallback) throws IllegalArgumentException;
    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the GetRequestTokenResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<GetRequestTokenResponse> getRequestToken(IdentityProvider identityProvider, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getRequestTokenAsync(IdentityProvider identityProvider, String appkey, String authorization, final ServiceCallback<GetRequestTokenResponse> serviceCallback) throws IllegalArgumentException;

}

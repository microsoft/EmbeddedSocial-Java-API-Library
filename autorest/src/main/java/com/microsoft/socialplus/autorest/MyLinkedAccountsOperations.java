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
import com.microsoft.socialplus.autorest.models.IdentityProvider;
import com.microsoft.socialplus.autorest.models.LinkedAccountView;
import com.microsoft.socialplus.autorest.models.PostLinkedAccountRequest;
import java.io.IOException;
import java.util.List;

/**
 * An instance of this class provides access to all the operations defined
 * in MyLinkedAccountsOperations.
 */
public interface MyLinkedAccountsOperations {
    /**
     * Get linked accounts.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;LinkedAccountView&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<List<LinkedAccountView>> getLinkedAccounts(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get linked accounts.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getLinkedAccountsAsync(String authorization, final ServiceCallback<List<LinkedAccountView>> serviceCallback) throws IllegalArgumentException;

    /**
     * Create a new linked account.
     *
     * @param request Post linked account request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> postLinkedAccount(PostLinkedAccountRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new linked account.
     *
     * @param request Post linked account request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postLinkedAccountAsync(PostLinkedAccountRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Delete linked account.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteLinkedAccount(IdentityProvider identityProvider, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete linked account.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteLinkedAccountAsync(IdentityProvider identityProvider, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

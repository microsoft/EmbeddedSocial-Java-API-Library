/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.AppCompactView;
import java.io.IOException;
import java.util.List;

/**
 * An instance of this class provides access to all the operations defined
 * in MyAppsOperations.
 */
public interface MyAppsOperations {
    /**
     * Get my list of Social Plus apps.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;AppCompactView&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<List<AppCompactView>> getApps(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my list of Social Plus apps.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAppsAsync(String authorization, final ServiceCallback<List<AppCompactView>> serviceCallback) throws IllegalArgumentException;

}

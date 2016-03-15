/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.PostReportRequest;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in TopicReportsOperations.
 */
public interface TopicReportsOperations {
    /**
     * Report topic.
     *
     * @param topicHandle Topic handle
     * @param postReportRequest Post report request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> postReport(String topicHandle, PostReportRequest postReportRequest, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Report topic.
     *
     * @param topicHandle Topic handle
     * @param postReportRequest Post report request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postReportAsync(String topicHandle, PostReportRequest postReportRequest, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

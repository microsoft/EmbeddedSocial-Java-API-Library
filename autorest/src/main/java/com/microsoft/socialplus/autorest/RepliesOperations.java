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
import com.microsoft.socialplus.autorest.models.ReplyView;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in RepliesOperations.
 */
public interface RepliesOperations {
    /**
     * Get reply.
     *
     * @param replyHandle Reply handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the ReplyView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<ReplyView> getReply(String replyHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get reply.
     *
     * @param replyHandle Reply handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getReplyAsync(String replyHandle, String authorization, final ServiceCallback<ReplyView> serviceCallback) throws IllegalArgumentException;

    /**
     * Delete reply.
     *
     * @param replyHandle Reply handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteReply(String replyHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete reply.
     *
     * @param replyHandle Reply handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteReplyAsync(String replyHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

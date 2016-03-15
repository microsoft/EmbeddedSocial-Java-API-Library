/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.CommentView;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in CommentsOperations.
 */
public interface CommentsOperations {
    /**
     * Get comment.
     *
     * @param commentHandle Comment handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CommentView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<CommentView> getComment(String commentHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get comment.
     *
     * @param commentHandle Comment handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getCommentAsync(String commentHandle, String authorization, final ServiceCallback<CommentView> serviceCallback) throws IllegalArgumentException;

    /**
     * Delete comment.
     *
     * @param commentHandle Comment handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteComment(String commentHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete comment.
     *
     * @param commentHandle Comment handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteCommentAsync(String commentHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

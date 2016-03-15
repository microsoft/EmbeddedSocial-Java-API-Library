/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.FeedResponseReplyView;
import com.microsoft.socialplus.autorest.models.PostReplyRequest;
import com.microsoft.socialplus.autorest.models.PostReplyResponse;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in CommentRepliesOperations.
 */
public interface CommentRepliesOperations {
    /**
     * Get replies for a comment.
     *
     * @param commentHandle Comment handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseReplyView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseReplyView> getReplies(String commentHandle, String authorization, String cursor, Integer limit) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get replies for a comment.
     *
     * @param commentHandle Comment handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getRepliesAsync(String commentHandle, String authorization, String cursor, Integer limit, final ServiceCallback<FeedResponseReplyView> serviceCallback) throws IllegalArgumentException;

    /**
     * Create a new reply.
     *
     * @param commentHandle Comment handle
     * @param request Post reply request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostReplyResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostReplyResponse> postReply(String commentHandle, PostReplyRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new reply.
     *
     * @param commentHandle Comment handle
     * @param request Post reply request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postReplyAsync(String commentHandle, PostReplyRequest request, String authorization, final ServiceCallback<PostReplyResponse> serviceCallback) throws IllegalArgumentException;

}

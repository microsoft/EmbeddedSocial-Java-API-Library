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
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseReplyView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseReplyView> getReplies(String commentHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get replies for a comment.
     *
     * @param commentHandle Comment handle
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getRepliesAsync(String commentHandle, final ServiceCallback<FeedResponseReplyView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get replies for a comment.
     *
     * @param commentHandle Comment handle
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseReplyView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseReplyView> getReplies(String commentHandle, String cursor, Integer limit, String appkey, String authorization, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get replies for a comment.
     *
     * @param commentHandle Comment handle
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getRepliesAsync(String commentHandle, String cursor, Integer limit, String appkey, String authorization, String userHandle, final ServiceCallback<FeedResponseReplyView> serviceCallback) throws IllegalArgumentException;

    /**
     * Create a new reply.
     *
     * @param commentHandle Comment handle
     * @param request Post reply request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
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
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postReplyAsync(String commentHandle, PostReplyRequest request, String authorization, final ServiceCallback<PostReplyResponse> serviceCallback) throws IllegalArgumentException;
    /**
     * Create a new reply.
     *
     * @param commentHandle Comment handle
     * @param request Post reply request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostReplyResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostReplyResponse> postReply(String commentHandle, PostReplyRequest request, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new reply.
     *
     * @param commentHandle Comment handle
     * @param request Post reply request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postReplyAsync(String commentHandle, PostReplyRequest request, String authorization, String appkey, String userHandle, final ServiceCallback<PostReplyResponse> serviceCallback) throws IllegalArgumentException;

}

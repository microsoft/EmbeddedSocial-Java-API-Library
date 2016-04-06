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
import com.microsoft.socialplus.autorest.models.PostBlobResponse;
import java.io.InputStream;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in BlobsOperations.
 */
public interface BlobsOperations {
    /**
     * Upload a blob.
     * If your blob is an image, use image APIs. For all other blob types, use this API.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param blob MIME encoded contents of the blob
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostBlobResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostBlobResponse> postBlob(String authorization, byte[] blob) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload a blob.
     * If your blob is an image, use image APIs. For all other blob types, use this API.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param blob MIME encoded contents of the blob
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postBlobAsync(String authorization, byte[] blob, final ServiceCallback<PostBlobResponse> serviceCallback) throws IllegalArgumentException;
    /**
     * Upload a blob.
     * If your blob is an image, use image APIs. For all other blob types, use this API.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param blob MIME encoded contents of the blob
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostBlobResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostBlobResponse> postBlob(String authorization, byte[] blob, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload a blob.
     * If your blob is an image, use image APIs. For all other blob types, use this API.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param blob MIME encoded contents of the blob
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postBlobAsync(String authorization, byte[] blob, String appkey, String userHandle, final ServiceCallback<PostBlobResponse> serviceCallback) throws IllegalArgumentException;

    /**
     * Get blob.
     *
     * @param blobHandle Blob handle
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> getBlob(String blobHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get blob.
     *
     * @param blobHandle Blob handle
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getBlobAsync(String blobHandle, String authorization, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;
    /**
     * Get blob.
     *
     * @param blobHandle Blob handle
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> getBlob(String blobHandle, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get blob.
     *
     * @param blobHandle Blob handle
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getBlobAsync(String blobHandle, String authorization, String appkey, String userHandle, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;

}

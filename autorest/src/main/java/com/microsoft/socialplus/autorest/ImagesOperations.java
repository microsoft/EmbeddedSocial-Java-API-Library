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
import com.microsoft.socialplus.autorest.models.ImageType;
import com.microsoft.socialplus.autorest.models.PostImageResponse;
import java.io.InputStream;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in ImagesOperations.
 */
public interface ImagesOperations {
    /**
     * Upload a new image.
     * Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.
     *             
     *              - d is 25 pixels wide
     *              - h is 50 pixels wide
     *              - l is 100 pixels wide
     *              - p is 250 pixels wide
     *              - t is 500 pixels wide
     *              - x is 1000 pixels wide
     *             
     *              - ImageType.UserPhoto supports d,h,l,p,t,x
     *              - ImageType.ContentBlob supports d,h,l,p,t,x
     *              - ImageType.AppIcon supports l
     *             
     *              All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param image MIME encoded contents of the image
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostImageResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostImageResponse> postImage(ImageType imageType, String authorization, byte[] image) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload a new image.
     * Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.
     *             
     *              - d is 25 pixels wide
     *              - h is 50 pixels wide
     *              - l is 100 pixels wide
     *              - p is 250 pixels wide
     *              - t is 500 pixels wide
     *              - x is 1000 pixels wide
     *             
     *              - ImageType.UserPhoto supports d,h,l,p,t,x
     *              - ImageType.ContentBlob supports d,h,l,p,t,x
     *              - ImageType.AppIcon supports l
     *             
     *              All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param image MIME encoded contents of the image
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postImageAsync(ImageType imageType, String authorization, byte[] image, final ServiceCallback<PostImageResponse> serviceCallback) throws IllegalArgumentException;
    /**
     * Upload a new image.
     * Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.
     *             
     *              - d is 25 pixels wide
     *              - h is 50 pixels wide
     *              - l is 100 pixels wide
     *              - p is 250 pixels wide
     *              - t is 500 pixels wide
     *              - x is 1000 pixels wide
     *             
     *              - ImageType.UserPhoto supports d,h,l,p,t,x
     *              - ImageType.ContentBlob supports d,h,l,p,t,x
     *              - ImageType.AppIcon supports l
     *             
     *              All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param image MIME encoded contents of the image
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostImageResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostImageResponse> postImage(ImageType imageType, String authorization, byte[] image, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload a new image.
     * Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.
     *             
     *              - d is 25 pixels wide
     *              - h is 50 pixels wide
     *              - l is 100 pixels wide
     *              - p is 250 pixels wide
     *              - t is 500 pixels wide
     *              - x is 1000 pixels wide
     *             
     *              - ImageType.UserPhoto supports d,h,l,p,t,x
     *              - ImageType.ContentBlob supports d,h,l,p,t,x
     *              - ImageType.AppIcon supports l
     *             
     *              All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param image MIME encoded contents of the image
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postImageAsync(ImageType imageType, String authorization, byte[] image, String appkey, String userHandle, final ServiceCallback<PostImageResponse> serviceCallback) throws IllegalArgumentException;

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> getImage(String blobHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getImageAsync(String blobHandle, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;
    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> getImage(String blobHandle, String appkey, String authorization, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getImageAsync(String blobHandle, String appkey, String authorization, String userHandle, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;

}

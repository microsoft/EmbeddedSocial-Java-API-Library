/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
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
     * &lt;para&gt;Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.&lt;/para&gt;
     * &lt;para&gt;d = 25 pixels wide&lt;/para&gt;
     * &lt;para&gt;h = 50 pixels wide&lt;/para&gt;
     * &lt;para&gt;l = 100 pixels wide&lt;/para&gt;
     * &lt;para&gt;p = 250 pixels wide&lt;/para&gt;
     * &lt;para&gt;t = 500 pixels wide&lt;/para&gt;
     * &lt;para&gt;x = 1000 pixels wide&lt;/para&gt;
     * &lt;para&gt;ImageType.UserPhoto supports d,h,l,p,t,x&lt;/para&gt;
     * &lt;para&gt;ImageType.ContentBlob supports d,h,l,p,t,x&lt;/para&gt;
     * &lt;para&gt;ImageType.AppIcon supports l&lt;/para&gt;
     * &lt;para&gt;All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.&lt;/para&gt;.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param image MIME encoded contents of the image
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostImageResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostImageResponse> postImage(ImageType imageType, String authorization, InputStream image) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Upload a new image.
     * &lt;para&gt;Images will be resized. To access a resized image, append the 1 character size identifier to the blobHandle that is returned.&lt;/para&gt;
     * &lt;para&gt;d = 25 pixels wide&lt;/para&gt;
     * &lt;para&gt;h = 50 pixels wide&lt;/para&gt;
     * &lt;para&gt;l = 100 pixels wide&lt;/para&gt;
     * &lt;para&gt;p = 250 pixels wide&lt;/para&gt;
     * &lt;para&gt;t = 500 pixels wide&lt;/para&gt;
     * &lt;para&gt;x = 1000 pixels wide&lt;/para&gt;
     * &lt;para&gt;ImageType.UserPhoto supports d,h,l,p,t,x&lt;/para&gt;
     * &lt;para&gt;ImageType.ContentBlob supports d,h,l,p,t,x&lt;/para&gt;
     * &lt;para&gt;ImageType.AppIcon supports l&lt;/para&gt;
     * &lt;para&gt;All resized images will maintain their aspect ratio. Any orientation specified in the EXIF headers will be honored.&lt;/para&gt;.
     *
     * @param imageType Image type. Possible values include: 'UserPhoto', 'ContentBlob', 'AppIcon'
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param image MIME encoded contents of the image
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postImageAsync(ImageType imageType, String authorization, InputStream image, final ServiceCallback<PostImageResponse> serviceCallback) throws IllegalArgumentException;

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> getImage(String blobHandle, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getImageAsync(String blobHandle, String appkey, String authorization, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;

}

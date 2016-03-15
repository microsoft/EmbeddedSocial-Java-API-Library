/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest;

import com.google.common.reflect.TypeToken;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.socialplus.autorest.models.ImageType;
import com.microsoft.socialplus.autorest.models.PostImageResponse;
import java.io.InputStream;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in ImagesOperations.
 */
public final class ImagesOperationsImpl implements ImagesOperations {
    /** The Retrofit service to perform REST calls. */
    private ImagesService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of ImagesOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ImagesOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(ImagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ImagesOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ImagesService {
        @Headers("Content-Type: image")
        @POST("v0.2/images/{imageType}")
        Call<ResponseBody> postImage(@Path("imageType") String imageType, @Header("Authorization") String authorization, @Body InputStream image);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/images/{blobHandle}")
        Call<ResponseBody> getImage(@Path("blobHandle") String blobHandle, @Header("appkey") String appkey, @Header("Authorization") String authorization);

    }

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
    public ServiceResponse<PostImageResponse> postImage(ImageType imageType, String authorization, InputStream image) throws ServiceException, IOException, IllegalArgumentException {
        if (imageType == null) {
            throw new IllegalArgumentException("Parameter imageType is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        if (image == null) {
            throw new IllegalArgumentException("Parameter image is required and cannot be null.");
        }
        Call<ResponseBody> call = service.postImage(this.client.getMapperAdapter().serializeRaw(imageType), authorization, image);
        return postImageDelegate(call.execute());
    }

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
     * @return the {@link Call} object
     */
    public ServiceCall postImageAsync(ImageType imageType, String authorization, InputStream image, final ServiceCallback<PostImageResponse> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (imageType == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter imageType is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        if (image == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter image is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.postImage(this.client.getMapperAdapter().serializeRaw(imageType), authorization, image);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<PostImageResponse>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postImageDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PostImageResponse> postImageDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<PostImageResponse, ServiceException>(this.client.getMapperAdapter())
                .register(201, new TypeToken<PostImageResponse>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

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
    public ServiceResponse<InputStream> getImage(String blobHandle, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (blobHandle == null) {
            throw new IllegalArgumentException("Parameter blobHandle is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getImage(blobHandle, appkey, authorization);
        return getImageDelegate(call.execute());
    }

    /**
     * Get image.
     *
     * @param blobHandle Blob handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getImageAsync(String blobHandle, String appkey, String authorization, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (blobHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter blobHandle is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getImage(blobHandle, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<InputStream>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getImageDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<InputStream> getImageDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<InputStream, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<InputStream>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

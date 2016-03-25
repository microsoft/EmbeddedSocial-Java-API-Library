/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest;

import com.google.common.reflect.TypeToken;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.ServiceResponseCallback;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in HashtagsOperations.
 */
public final class HashtagsOperationsImpl implements HashtagsOperations {
    /** The Retrofit service to perform REST calls. */
    private HashtagsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of HashtagsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public HashtagsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(HashtagsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for HashtagsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface HashtagsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/hashtags/trending")
        Call<ResponseBody> getTrendingHashtags(@Header("appkey") String appkey, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/hashtags/autocomplete")
        Call<ResponseBody> getAutocompletedHashtags(@Query("query") String query, @Header("appkey") String appkey, @Header("Authorization") String authorization);

    }

    /**
     * Get trending hashtags.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the List&lt;String&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<String>> getTrendingHashtags() throws ServiceException, IOException {
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getTrendingHashtags(appkey, authorization);
        return getTrendingHashtagsDelegate(call.execute());
    }

    /**
     * Get trending hashtags.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTrendingHashtagsAsync(final ServiceCallback<List<String>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getTrendingHashtags(appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<String>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getTrendingHashtagsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get trending hashtags.
     *
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the List&lt;String&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<String>> getTrendingHashtags(String appkey, String authorization) throws ServiceException, IOException {
        Call<ResponseBody> call = service.getTrendingHashtags(appkey, authorization);
        return getTrendingHashtagsDelegate(call.execute());
    }

    /**
     * Get trending hashtags.
     *
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTrendingHashtagsAsync(String appkey, String authorization, final ServiceCallback<List<String>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        Call<ResponseBody> call = service.getTrendingHashtags(appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<String>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getTrendingHashtagsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<String>> getTrendingHashtagsDelegate(Response<ResponseBody> response) throws ServiceException, IOException {
        return new ServiceResponseBuilder<List<String>, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<List<String>>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Get autocompleted hashtags.
     *
     * @param query Search query
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;String&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<String>> getAutocompletedHashtags(String query) throws ServiceException, IOException, IllegalArgumentException {
        if (query == null) {
            throw new IllegalArgumentException("Parameter query is required and cannot be null.");
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getAutocompletedHashtags(query, appkey, authorization);
        return getAutocompletedHashtagsDelegate(call.execute());
    }

    /**
     * Get autocompleted hashtags.
     *
     * @param query Search query
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAutocompletedHashtagsAsync(String query, final ServiceCallback<List<String>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (query == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter query is required and cannot be null."));
            return null;
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getAutocompletedHashtags(query, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<String>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getAutocompletedHashtagsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get autocompleted hashtags.
     *
     * @param query Search query
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;String&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<String>> getAutocompletedHashtags(String query, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (query == null) {
            throw new IllegalArgumentException("Parameter query is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getAutocompletedHashtags(query, appkey, authorization);
        return getAutocompletedHashtagsDelegate(call.execute());
    }

    /**
     * Get autocompleted hashtags.
     *
     * @param query Search query
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAutocompletedHashtagsAsync(String query, String appkey, String authorization, final ServiceCallback<List<String>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (query == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter query is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getAutocompletedHashtags(query, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<String>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getAutocompletedHashtagsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<String>> getAutocompletedHashtagsDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<List<String>, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<List<String>>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

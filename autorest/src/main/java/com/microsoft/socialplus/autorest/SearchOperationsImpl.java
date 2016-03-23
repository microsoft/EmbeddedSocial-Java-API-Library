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
import com.microsoft.socialplus.autorest.models.FeedResponseTopicView;
import com.microsoft.socialplus.autorest.models.FeedResponseUserCompactView;
import java.io.IOException;
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
 * in SearchOperations.
 */
public final class SearchOperationsImpl implements SearchOperations {
    /** The Retrofit service to perform REST calls. */
    private SearchService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of SearchOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public SearchOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(SearchService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for SearchOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface SearchService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/search/topics")
        Call<ResponseBody> getTopics(@Query("query") String query, @Query("cursor") Integer cursor, @Query("limit") Integer limit, @Header("appkey") String appkey, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/search/users")
        Call<ResponseBody> getUsers(@Query("query") String query, @Query("cursor") Integer cursor, @Query("limit") Integer limit, @Header("appkey") String appkey, @Header("Authorization") String authorization);

    }

    /**
     * Search topics with a query.
     *
     * @param query Search query
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getTopics(String query, Integer cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (query == null) {
            throw new IllegalArgumentException("Parameter query is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getTopics(query, cursor, limit, appkey, authorization);
        return getTopicsDelegate(call.execute());
    }

    /**
     * Search topics with a query.
     *
     * @param query Search query
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTopicsAsync(String query, Integer cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (query == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter query is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getTopics(query, cursor, limit, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<FeedResponseTopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getTopicsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<FeedResponseTopicView> getTopicsDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<FeedResponseTopicView, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<FeedResponseTopicView>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Search users with a query.
     *
     * @param query Search query
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseUserCompactView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseUserCompactView> getUsers(String query, Integer cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (query == null) {
            throw new IllegalArgumentException("Parameter query is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getUsers(query, cursor, limit, appkey, authorization);
        return getUsersDelegate(call.execute());
    }

    /**
     * Search users with a query.
     *
     * @param query Search query
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getUsersAsync(String query, Integer cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseUserCompactView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (query == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter query is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getUsers(query, cursor, limit, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<FeedResponseUserCompactView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getUsersDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<FeedResponseUserCompactView> getUsersDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<FeedResponseUserCompactView, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<FeedResponseUserCompactView>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

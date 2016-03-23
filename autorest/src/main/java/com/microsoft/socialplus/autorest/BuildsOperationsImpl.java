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
import com.microsoft.socialplus.autorest.models.BuildsCurrentResponse;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in BuildsOperations.
 */
public final class BuildsOperationsImpl implements BuildsOperations {
    /** The Retrofit service to perform REST calls. */
    private BuildsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of BuildsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public BuildsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(BuildsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for BuildsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface BuildsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/builds/current")
        Call<ResponseBody> getBuildsCurrent(@Header("appkey") String appkey, @Header("Authorization") String authorization);

    }

    /**
     * The build information for this service.
     * This API is meant to be called by humans for debugging.
     *
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the BuildsCurrentResponse object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<BuildsCurrentResponse> getBuildsCurrent(String appkey, String authorization) throws ServiceException, IOException {
        Call<ResponseBody> call = service.getBuildsCurrent(appkey, authorization);
        return getBuildsCurrentDelegate(call.execute());
    }

    /**
     * The build information for this service.
     * This API is meant to be called by humans for debugging.
     *
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getBuildsCurrentAsync(String appkey, String authorization, final ServiceCallback<BuildsCurrentResponse> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        Call<ResponseBody> call = service.getBuildsCurrent(appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<BuildsCurrentResponse>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getBuildsCurrentDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<BuildsCurrentResponse> getBuildsCurrentDelegate(Response<ResponseBody> response) throws ServiceException, IOException {
        return new ServiceResponseBuilder<BuildsCurrentResponse, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<BuildsCurrentResponse>() { }.getType())
                .build(response);
    }

}

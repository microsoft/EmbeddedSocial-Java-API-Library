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
import com.microsoft.socialplus.autorest.models.GetRequestTokenResponse;
import com.microsoft.socialplus.autorest.models.IdentityProvider;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in RequestTokensOperations.
 */
public final class RequestTokensOperationsImpl implements RequestTokensOperations {
    /** The Retrofit service to perform REST calls. */
    private RequestTokensService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of RequestTokensOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public RequestTokensOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(RequestTokensService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for RequestTokensOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface RequestTokensService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/request_tokens/{identityProvider}")
        Call<ResponseBody> getRequestToken(@Path("identityProvider") String identityProvider, @Header("appkey") String appkey, @Header("Authorization") String authorization);

    }

    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the GetRequestTokenResponse object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<GetRequestTokenResponse> getRequestToken(IdentityProvider identityProvider) throws ServiceException, IOException, IllegalArgumentException {
        if (identityProvider == null) {
            throw new IllegalArgumentException("Parameter identityProvider is required and cannot be null.");
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getRequestToken(this.client.getMapperAdapter().serializeRaw(identityProvider), appkey, authorization);
        return getRequestTokenDelegate(call.execute());
    }

    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRequestTokenAsync(IdentityProvider identityProvider, final ServiceCallback<GetRequestTokenResponse> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (identityProvider == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter identityProvider is required and cannot be null."));
            return null;
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getRequestToken(this.client.getMapperAdapter().serializeRaw(identityProvider), appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<GetRequestTokenResponse>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRequestTokenDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the GetRequestTokenResponse object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<GetRequestTokenResponse> getRequestToken(IdentityProvider identityProvider, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (identityProvider == null) {
            throw new IllegalArgumentException("Parameter identityProvider is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getRequestToken(this.client.getMapperAdapter().serializeRaw(identityProvider), appkey, authorization);
        return getRequestTokenDelegate(call.execute());
    }

    /**
     * Get request token.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getRequestTokenAsync(IdentityProvider identityProvider, String appkey, String authorization, final ServiceCallback<GetRequestTokenResponse> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (identityProvider == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter identityProvider is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getRequestToken(this.client.getMapperAdapter().serializeRaw(identityProvider), appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<GetRequestTokenResponse>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getRequestTokenDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<GetRequestTokenResponse> getRequestTokenDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<GetRequestTokenResponse, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<GetRequestTokenResponse>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

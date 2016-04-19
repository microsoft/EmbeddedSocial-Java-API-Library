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
import com.microsoft.rest.Validator;
import com.microsoft.socialplus.autorest.models.PostReportRequest;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in ReplyReportsOperations.
 */
public final class ReplyReportsOperationsImpl implements ReplyReportsOperations {
    /** The Retrofit service to perform REST calls. */
    private ReplyReportsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of ReplyReportsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ReplyReportsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(ReplyReportsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ReplyReportsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ReplyReportsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("v0.3/replies/{replyHandle}/reports")
        Call<ResponseBody> postReport(@Path("replyHandle") String replyHandle, @Body PostReportRequest postReportRequest, @Header("appkey") String appkey, @Header("Authorization") String authorization, @Header("UserHandle") String userHandle);

    }

    /**
     * Report reply.
     *
     * @param replyHandle Reply handle for the reply being reported on
     * @param postReportRequest Post report request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> postReport(String replyHandle, PostReportRequest postReportRequest, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (replyHandle == null) {
            throw new IllegalArgumentException("Parameter replyHandle is required and cannot be null.");
        }
        if (postReportRequest == null) {
            throw new IllegalArgumentException("Parameter postReportRequest is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(postReportRequest);
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.postReport(replyHandle, postReportRequest, appkey, authorization, userHandle);
        return postReportDelegate(call.execute());
    }

    /**
     * Report reply.
     *
     * @param replyHandle Reply handle for the reply being reported on
     * @param postReportRequest Post report request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postReportAsync(String replyHandle, PostReportRequest postReportRequest, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (replyHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter replyHandle is required and cannot be null."));
            return null;
        }
        if (postReportRequest == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter postReportRequest is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Validator.validate(postReportRequest, serviceCallback);
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.postReport(replyHandle, postReportRequest, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postReportDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Report reply.
     *
     * @param replyHandle Reply handle for the reply being reported on
     * @param postReportRequest Post report request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> postReport(String replyHandle, PostReportRequest postReportRequest, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (replyHandle == null) {
            throw new IllegalArgumentException("Parameter replyHandle is required and cannot be null.");
        }
        if (postReportRequest == null) {
            throw new IllegalArgumentException("Parameter postReportRequest is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(postReportRequest);
        Call<ResponseBody> call = service.postReport(replyHandle, postReportRequest, appkey, authorization, userHandle);
        return postReportDelegate(call.execute());
    }

    /**
     * Report reply.
     *
     * @param replyHandle Reply handle for the reply being reported on
     * @param postReportRequest Post report request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postReportAsync(String replyHandle, PostReportRequest postReportRequest, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (replyHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter replyHandle is required and cannot be null."));
            return null;
        }
        if (postReportRequest == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter postReportRequest is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Validator.validate(postReportRequest, serviceCallback);
        Call<ResponseBody> call = service.postReport(replyHandle, postReportRequest, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postReportDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> postReportDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(409, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

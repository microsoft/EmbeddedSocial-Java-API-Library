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
 * in CommentReportsOperations.
 */
public final class CommentReportsOperationsImpl implements CommentReportsOperations {
    /** The Retrofit service to perform REST calls. */
    private CommentReportsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of CommentReportsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public CommentReportsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(CommentReportsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for CommentReportsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface CommentReportsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("v0.2/comments/{commentHandle}/reports")
        Call<ResponseBody> postReport(@Path("commentHandle") String commentHandle, @Body PostReportRequest postReportRequest, @Header("Authorization") String authorization);

    }

    /**
     * Report comment.
     *
     * @param commentHandle Comment handle
     * @param postReportRequest Post report request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> postReport(String commentHandle, PostReportRequest postReportRequest, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (commentHandle == null) {
            throw new IllegalArgumentException("Parameter commentHandle is required and cannot be null.");
        }
        if (postReportRequest == null) {
            throw new IllegalArgumentException("Parameter postReportRequest is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(postReportRequest);
        Call<ResponseBody> call = service.postReport(commentHandle, postReportRequest, authorization);
        return postReportDelegate(call.execute());
    }

    /**
     * Report comment.
     *
     * @param commentHandle Comment handle
     * @param postReportRequest Post report request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postReportAsync(String commentHandle, PostReportRequest postReportRequest, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (commentHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter commentHandle is required and cannot be null."));
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
        Call<ResponseBody> call = service.postReport(commentHandle, postReportRequest, authorization);
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
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

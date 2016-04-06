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
import com.microsoft.socialplus.autorest.models.Platform;
import com.microsoft.socialplus.autorest.models.PutPushRegistrationRequest;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in MyPushRegistrationsOperations.
 */
public final class MyPushRegistrationsOperationsImpl implements MyPushRegistrationsOperations {
    /** The Retrofit service to perform REST calls. */
    private MyPushRegistrationsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of MyPushRegistrationsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public MyPushRegistrationsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(MyPushRegistrationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for MyPushRegistrationsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface MyPushRegistrationsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("v0.3/users/me/push_registrations/{platform}/{registrationId}")
        Call<ResponseBody> putPushRegistration(@Path("platform") Platform platform, @Path("registrationId") String registrationId, @Body PutPushRegistrationRequest request, @Header("appkey") String appkey, @Header("Authorization") String authorization, @Header("UserHandle") String userHandle);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "v0.3/users/me/push_registrations/{platform}/{registrationId}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deletePushRegistration(@Path("platform") Platform platform, @Path("registrationId") String registrationId, @Header("appkey") String appkey, @Header("Authorization") String authorization, @Header("UserHandle") String userHandle);

    }

    /**
     * Register for push notifications or update existing registration.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param request Put push registration request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> putPushRegistration(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (platform == null) {
            throw new IllegalArgumentException("Parameter platform is required and cannot be null.");
        }
        if (registrationId == null) {
            throw new IllegalArgumentException("Parameter registrationId is required and cannot be null.");
        }
        if (request == null) {
            throw new IllegalArgumentException("Parameter request is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(request);
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.putPushRegistration(platform, registrationId, request, appkey, authorization, userHandle);
        return putPushRegistrationDelegate(call.execute());
    }

    /**
     * Register for push notifications or update existing registration.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param request Put push registration request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall putPushRegistrationAsync(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (platform == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter platform is required and cannot be null."));
            return null;
        }
        if (registrationId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter registrationId is required and cannot be null."));
            return null;
        }
        if (request == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter request is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Validator.validate(request, serviceCallback);
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.putPushRegistration(platform, registrationId, request, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(putPushRegistrationDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Register for push notifications or update existing registration.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param request Put push registration request
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
    public ServiceResponse<Object> putPushRegistration(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (platform == null) {
            throw new IllegalArgumentException("Parameter platform is required and cannot be null.");
        }
        if (registrationId == null) {
            throw new IllegalArgumentException("Parameter registrationId is required and cannot be null.");
        }
        if (request == null) {
            throw new IllegalArgumentException("Parameter request is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(request);
        Call<ResponseBody> call = service.putPushRegistration(platform, registrationId, request, appkey, authorization, userHandle);
        return putPushRegistrationDelegate(call.execute());
    }

    /**
     * Register for push notifications or update existing registration.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param request Put push registration request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall putPushRegistrationAsync(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (platform == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter platform is required and cannot be null."));
            return null;
        }
        if (registrationId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter registrationId is required and cannot be null."));
            return null;
        }
        if (request == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter request is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Validator.validate(request, serviceCallback);
        Call<ResponseBody> call = service.putPushRegistration(platform, registrationId, request, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(putPushRegistrationDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> putPushRegistrationDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(409, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Unregister from push notifications.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> deletePushRegistration(Platform platform, String registrationId, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (platform == null) {
            throw new IllegalArgumentException("Parameter platform is required and cannot be null.");
        }
        if (registrationId == null) {
            throw new IllegalArgumentException("Parameter registrationId is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.deletePushRegistration(platform, registrationId, appkey, authorization, userHandle);
        return deletePushRegistrationDelegate(call.execute());
    }

    /**
     * Unregister from push notifications.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deletePushRegistrationAsync(Platform platform, String registrationId, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (platform == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter platform is required and cannot be null."));
            return null;
        }
        if (registrationId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter registrationId is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.deletePushRegistration(platform, registrationId, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deletePushRegistrationDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Unregister from push notifications.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
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
    public ServiceResponse<Object> deletePushRegistration(Platform platform, String registrationId, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (platform == null) {
            throw new IllegalArgumentException("Parameter platform is required and cannot be null.");
        }
        if (registrationId == null) {
            throw new IllegalArgumentException("Parameter registrationId is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Call<ResponseBody> call = service.deletePushRegistration(platform, registrationId, appkey, authorization, userHandle);
        return deletePushRegistrationDelegate(call.execute());
    }

    /**
     * Unregister from push notifications.
     *
     * @param platform Platform type. Possible values include: 'Windows', 'Android', 'IOS'
     * @param registrationId Unique registration ID provided by the mobile OS.
                 You must URL encode the registration ID.
                 For Android, this is the GCM registration ID.
                 For Windows, this is the PushNotificationChannel URI.
                 For iOS, this is the device token.
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deletePushRegistrationAsync(Platform platform, String registrationId, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (platform == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter platform is required and cannot be null."));
            return null;
        }
        if (registrationId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter registrationId is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.deletePushRegistration(platform, registrationId, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deletePushRegistrationDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> deletePushRegistrationDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

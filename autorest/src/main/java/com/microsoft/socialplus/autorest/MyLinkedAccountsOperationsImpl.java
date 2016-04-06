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
import com.microsoft.socialplus.autorest.models.IdentityProvider;
import com.microsoft.socialplus.autorest.models.LinkedAccountView;
import com.microsoft.socialplus.autorest.models.PostLinkedAccountRequest;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in MyLinkedAccountsOperations.
 */
public final class MyLinkedAccountsOperationsImpl implements MyLinkedAccountsOperations {
    /** The Retrofit service to perform REST calls. */
    private MyLinkedAccountsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of MyLinkedAccountsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public MyLinkedAccountsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(MyLinkedAccountsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for MyLinkedAccountsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface MyLinkedAccountsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.3/users/me/linked_accounts")
        Call<ResponseBody> getLinkedAccounts(@Header("appkey") String appkey, @Header("Authorization") String authorization, @Header("UserHandle") String userHandle);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("v0.3/users/me/linked_accounts")
        Call<ResponseBody> postLinkedAccount(@Body PostLinkedAccountRequest request, @Header("appkey") String appkey, @Header("Authorization") String authorization, @Header("UserHandle") String userHandle);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "v0.3/users/me/linked_accounts/{identityProvider}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deleteLinkedAccount(@Path("identityProvider") IdentityProvider identityProvider, @Header("appkey") String appkey, @Header("Authorization") String authorization, @Header("UserHandle") String userHandle);

    }

    /**
     * Get linked accounts.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;LinkedAccountView&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<LinkedAccountView>> getLinkedAccounts(String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.getLinkedAccounts(appkey, authorization, userHandle);
        return getLinkedAccountsDelegate(call.execute());
    }

    /**
     * Get linked accounts.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getLinkedAccountsAsync(String authorization, final ServiceCallback<List<LinkedAccountView>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.getLinkedAccounts(appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<LinkedAccountView>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getLinkedAccountsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get linked accounts.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;LinkedAccountView&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<List<LinkedAccountView>> getLinkedAccounts(String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getLinkedAccounts(appkey, authorization, userHandle);
        return getLinkedAccountsDelegate(call.execute());
    }

    /**
     * Get linked accounts.
     *
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getLinkedAccountsAsync(String authorization, String appkey, String userHandle, final ServiceCallback<List<LinkedAccountView>> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getLinkedAccounts(appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<LinkedAccountView>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getLinkedAccountsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<List<LinkedAccountView>> getLinkedAccountsDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<List<LinkedAccountView>, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<List<LinkedAccountView>>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Create a new linked account.
     *
     * @param request Post linked account request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> postLinkedAccount(PostLinkedAccountRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (request == null) {
            throw new IllegalArgumentException("Parameter request is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(request);
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.postLinkedAccount(request, appkey, authorization, userHandle);
        return postLinkedAccountDelegate(call.execute());
    }

    /**
     * Create a new linked account.
     *
     * @param request Post linked account request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postLinkedAccountAsync(PostLinkedAccountRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
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
        Call<ResponseBody> call = service.postLinkedAccount(request, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postLinkedAccountDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Create a new linked account.
     *
     * @param request Post linked account request
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
    public ServiceResponse<Object> postLinkedAccount(PostLinkedAccountRequest request, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (request == null) {
            throw new IllegalArgumentException("Parameter request is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(request);
        Call<ResponseBody> call = service.postLinkedAccount(request, appkey, authorization, userHandle);
        return postLinkedAccountDelegate(call.execute());
    }

    /**
     * Create a new linked account.
     *
     * @param request Post linked account request
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postLinkedAccountAsync(PostLinkedAccountRequest request, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
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
        Call<ResponseBody> call = service.postLinkedAccount(request, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postLinkedAccountDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> postLinkedAccountDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(409, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Delete linked account.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> deleteLinkedAccount(IdentityProvider identityProvider, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (identityProvider == null) {
            throw new IllegalArgumentException("Parameter identityProvider is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.deleteLinkedAccount(identityProvider, appkey, authorization, userHandle);
        return deleteLinkedAccountDelegate(call.execute());
    }

    /**
     * Delete linked account.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deleteLinkedAccountAsync(IdentityProvider identityProvider, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (identityProvider == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter identityProvider is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        final String appkey = null;
        final String userHandle = null;
        Call<ResponseBody> call = service.deleteLinkedAccount(identityProvider, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deleteLinkedAccountDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Delete linked account.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
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
    public ServiceResponse<Object> deleteLinkedAccount(IdentityProvider identityProvider, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (identityProvider == null) {
            throw new IllegalArgumentException("Parameter identityProvider is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Call<ResponseBody> call = service.deleteLinkedAccount(identityProvider, appkey, authorization, userHandle);
        return deleteLinkedAccountDelegate(call.execute());
    }

    /**
     * Delete linked account.
     *
     * @param identityProvider Identity provider type. Possible values include: 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'
     * @param authorization Authentication (must begin with string "Bearer "). Possible values are:
     -sessionToken for client auth
     -AAD token for service auth
     * @param appkey App key must be filled in when using AAD tokens for Authentication.
     * @param userHandle User handle must be filled when using AAD tokens for Authentication.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deleteLinkedAccountAsync(IdentityProvider identityProvider, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (identityProvider == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter identityProvider is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.deleteLinkedAccount(identityProvider, appkey, authorization, userHandle);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deleteLinkedAccountDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> deleteLinkedAccountDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(403, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

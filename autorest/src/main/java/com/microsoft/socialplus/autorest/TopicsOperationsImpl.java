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
import com.microsoft.socialplus.autorest.models.FeedResponseTopicView;
import com.microsoft.socialplus.autorest.models.PostTopicRequest;
import com.microsoft.socialplus.autorest.models.PostTopicResponse;
import com.microsoft.socialplus.autorest.models.PutTopicRequest;
import com.microsoft.socialplus.autorest.models.TimeRange;
import com.microsoft.socialplus.autorest.models.TopicView;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in TopicsOperations.
 */
public final class TopicsOperationsImpl implements TopicsOperations {
    /** The Retrofit service to perform REST calls. */
    private TopicsService service;
    /** The service client containing this operation class. */
    private SocialPlusClient client;

    /**
     * Initializes an instance of TopicsOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public TopicsOperationsImpl(Retrofit retrofit, SocialPlusClient client) {
        this.service = retrofit.create(TopicsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for TopicsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface TopicsService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/topics")
        Call<ResponseBody> getTopics(@Query("cursor") String cursor, @Query("limit") Integer limit, @Header("appkey") String appkey, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("v0.2/topics")
        Call<ResponseBody> postTopic(@Body PostTopicRequest request, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/topics/{topicHandle}")
        Call<ResponseBody> getTopic(@Path("topicHandle") String topicHandle, @Header("appkey") String appkey, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @PUT("v0.2/topics/{topicHandle}")
        Call<ResponseBody> putTopic(@Path("topicHandle") String topicHandle, @Body PutTopicRequest request, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @HTTP(path = "v0.2/topics/{topicHandle}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deleteTopic(@Path("topicHandle") String topicHandle, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/topics/popular/{timeRange}")
        Call<ResponseBody> getPopularTopics(@Path("timeRange") String timeRange, @Query("cursor") Integer cursor, @Query("limit") Integer limit, @Header("appkey") String appkey, @Header("Authorization") String authorization);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("v0.2/topics/featured")
        Call<ResponseBody> getFeaturedTopics(@Query("cursor") String cursor, @Query("limit") Integer limit, @Header("appkey") String appkey, @Header("Authorization") String authorization);

    }

    /**
     * Get recent topics.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getTopics() throws ServiceException, IOException {
        final String cursor = null;
        final Integer limit = null;
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getTopics(cursor, limit, appkey, authorization);
        return getTopicsDelegate(call.execute());
    }

    /**
     * Get recent topics.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTopicsAsync(final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        final String cursor = null;
        final Integer limit = null;
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getTopics(cursor, limit, appkey, authorization);
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

    /**
     * Get recent topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getTopics(String cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException {
        Call<ResponseBody> call = service.getTopics(cursor, limit, appkey, authorization);
        return getTopicsDelegate(call.execute());
    }

    /**
     * Get recent topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTopicsAsync(String cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        Call<ResponseBody> call = service.getTopics(cursor, limit, appkey, authorization);
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

    private ServiceResponse<FeedResponseTopicView> getTopicsDelegate(Response<ResponseBody> response) throws ServiceException, IOException {
        return new ServiceResponseBuilder<FeedResponseTopicView, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<FeedResponseTopicView>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Create a new topic.
     *
     * @param request Post topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostTopicResponse object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<PostTopicResponse> postTopic(PostTopicRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (request == null) {
            throw new IllegalArgumentException("Parameter request is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(request);
        Call<ResponseBody> call = service.postTopic(request, authorization);
        return postTopicDelegate(call.execute());
    }

    /**
     * Create a new topic.
     *
     * @param request Post topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall postTopicAsync(PostTopicRequest request, String authorization, final ServiceCallback<PostTopicResponse> serviceCallback) throws IllegalArgumentException {
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
        Call<ResponseBody> call = service.postTopic(request, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<PostTopicResponse>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(postTopicDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<PostTopicResponse> postTopicDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<PostTopicResponse, ServiceException>(this.client.getMapperAdapter())
                .register(201, new TypeToken<PostTopicResponse>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .register(501, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the TopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<TopicView> getTopic(String topicHandle) throws ServiceException, IOException, IllegalArgumentException {
        if (topicHandle == null) {
            throw new IllegalArgumentException("Parameter topicHandle is required and cannot be null.");
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getTopic(topicHandle, appkey, authorization);
        return getTopicDelegate(call.execute());
    }

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTopicAsync(String topicHandle, final ServiceCallback<TopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (topicHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter topicHandle is required and cannot be null."));
            return null;
        }
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getTopic(topicHandle, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<TopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getTopicDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the TopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<TopicView> getTopic(String topicHandle, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (topicHandle == null) {
            throw new IllegalArgumentException("Parameter topicHandle is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getTopic(topicHandle, appkey, authorization);
        return getTopicDelegate(call.execute());
    }

    /**
     * Get topic.
     *
     * @param topicHandle Topic handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getTopicAsync(String topicHandle, String appkey, String authorization, final ServiceCallback<TopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (topicHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter topicHandle is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getTopic(topicHandle, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<TopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getTopicDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<TopicView> getTopicDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<TopicView, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<TopicView>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Update topic.
     *
     * @param topicHandle Topic handle
     * @param request Put topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> putTopic(String topicHandle, PutTopicRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (topicHandle == null) {
            throw new IllegalArgumentException("Parameter topicHandle is required and cannot be null.");
        }
        if (request == null) {
            throw new IllegalArgumentException("Parameter request is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Validator.validate(request);
        Call<ResponseBody> call = service.putTopic(topicHandle, request, authorization);
        return putTopicDelegate(call.execute());
    }

    /**
     * Update topic.
     *
     * @param topicHandle Topic handle
     * @param request Put topic request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall putTopicAsync(String topicHandle, PutTopicRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (topicHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter topicHandle is required and cannot be null."));
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
        Call<ResponseBody> call = service.putTopic(topicHandle, request, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(putTopicDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> putTopicDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(409, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Delete topic.
     *
     * @param topicHandle Topic handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> deleteTopic(String topicHandle, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (topicHandle == null) {
            throw new IllegalArgumentException("Parameter topicHandle is required and cannot be null.");
        }
        if (authorization == null) {
            throw new IllegalArgumentException("Parameter authorization is required and cannot be null.");
        }
        Call<ResponseBody> call = service.deleteTopic(topicHandle, authorization);
        return deleteTopicDelegate(call.execute());
    }

    /**
     * Delete topic.
     *
     * @param topicHandle Topic handle
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deleteTopicAsync(String topicHandle, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (topicHandle == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter topicHandle is required and cannot be null."));
            return null;
        }
        if (authorization == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter authorization is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.deleteTopic(topicHandle, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deleteTopicDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> deleteTopicDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<Object, ServiceException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Object>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getPopularTopics(TimeRange timeRange) throws ServiceException, IOException, IllegalArgumentException {
        if (timeRange == null) {
            throw new IllegalArgumentException("Parameter timeRange is required and cannot be null.");
        }
        final Integer cursor = null;
        final Integer limit = null;
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getPopularTopics(this.client.getMapperAdapter().serializeRaw(timeRange), cursor, limit, appkey, authorization);
        return getPopularTopicsDelegate(call.execute());
    }

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getPopularTopicsAsync(TimeRange timeRange, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (timeRange == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter timeRange is required and cannot be null."));
            return null;
        }
        final Integer cursor = null;
        final Integer limit = null;
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getPopularTopics(this.client.getMapperAdapter().serializeRaw(timeRange), cursor, limit, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<FeedResponseTopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getPopularTopicsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getPopularTopics(TimeRange timeRange, Integer cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException {
        if (timeRange == null) {
            throw new IllegalArgumentException("Parameter timeRange is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getPopularTopics(this.client.getMapperAdapter().serializeRaw(timeRange), cursor, limit, appkey, authorization);
        return getPopularTopicsDelegate(call.execute());
    }

    /**
     * Get popular topics today.
     *
     * @param timeRange Time range. Possible values include: 'Today', 'ThisWeek', 'ThisMonth', 'AllTime'
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getPopularTopicsAsync(TimeRange timeRange, Integer cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (timeRange == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter timeRange is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getPopularTopics(this.client.getMapperAdapter().serializeRaw(timeRange), cursor, limit, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<FeedResponseTopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getPopularTopicsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<FeedResponseTopicView> getPopularTopicsDelegate(Response<ResponseBody> response) throws ServiceException, IOException, IllegalArgumentException {
        return new ServiceResponseBuilder<FeedResponseTopicView, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<FeedResponseTopicView>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

    /**
     * Get featured topics.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getFeaturedTopics() throws ServiceException, IOException {
        final String cursor = null;
        final Integer limit = null;
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getFeaturedTopics(cursor, limit, appkey, authorization);
        return getFeaturedTopicsDelegate(call.execute());
    }

    /**
     * Get featured topics.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getFeaturedTopicsAsync(final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        final String cursor = null;
        final Integer limit = null;
        final String appkey = null;
        final String authorization = null;
        Call<ResponseBody> call = service.getFeaturedTopics(cursor, limit, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<FeedResponseTopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getFeaturedTopicsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Get featured topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseTopicView object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<FeedResponseTopicView> getFeaturedTopics(String cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException {
        Call<ResponseBody> call = service.getFeaturedTopics(cursor, limit, appkey, authorization);
        return getFeaturedTopicsDelegate(call.execute());
    }

    /**
     * Get featured topics.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getFeaturedTopicsAsync(String cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseTopicView> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        Call<ResponseBody> call = service.getFeaturedTopics(cursor, limit, appkey, authorization);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<FeedResponseTopicView>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getFeaturedTopicsDelegate(response));
                } catch (ServiceException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<FeedResponseTopicView> getFeaturedTopicsDelegate(Response<ResponseBody> response) throws ServiceException, IOException {
        return new ServiceResponseBuilder<FeedResponseTopicView, ServiceException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<FeedResponseTopicView>() { }.getType())
                .register(400, new TypeToken<Void>() { }.getType())
                .register(401, new TypeToken<Void>() { }.getType())
                .register(500, new TypeToken<Void>() { }.getType())
                .build(response);
    }

}

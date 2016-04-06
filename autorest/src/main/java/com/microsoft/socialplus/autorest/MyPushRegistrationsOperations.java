/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest;

import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.socialplus.autorest.models.Platform;
import com.microsoft.socialplus.autorest.models.PutPushRegistrationRequest;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in MyPushRegistrationsOperations.
 */
public interface MyPushRegistrationsOperations {
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
    ServiceResponse<Object> putPushRegistration(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

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
     * @return the {@link ServiceCall} object
     */
    ServiceCall putPushRegistrationAsync(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;
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
    ServiceResponse<Object> putPushRegistration(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

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
     * @return the {@link ServiceCall} object
     */
    ServiceCall putPushRegistrationAsync(Platform platform, String registrationId, PutPushRegistrationRequest request, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

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
    ServiceResponse<Object> deletePushRegistration(Platform platform, String registrationId, String authorization) throws ServiceException, IOException, IllegalArgumentException;

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
     * @return the {@link ServiceCall} object
     */
    ServiceCall deletePushRegistrationAsync(Platform platform, String registrationId, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;
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
    ServiceResponse<Object> deletePushRegistration(Platform platform, String registrationId, String authorization, String appkey, String userHandle) throws ServiceException, IOException, IllegalArgumentException;

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
     * @return the {@link ServiceCall} object
     */
    ServiceCall deletePushRegistrationAsync(Platform platform, String registrationId, String authorization, String appkey, String userHandle, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

}

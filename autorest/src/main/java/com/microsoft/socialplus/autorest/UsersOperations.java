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
import com.microsoft.socialplus.autorest.models.FeedResponseUserProfileView;
import com.microsoft.socialplus.autorest.models.PostUserRequest;
import com.microsoft.socialplus.autorest.models.PostUserResponse;
import com.microsoft.socialplus.autorest.models.PutUserInfoRequest;
import com.microsoft.socialplus.autorest.models.PutUserPhotoRequest;
import com.microsoft.socialplus.autorest.models.PutUserVisibilityRequest;
import com.microsoft.socialplus.autorest.models.UserProfileView;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in UsersOperations.
 */
public interface UsersOperations {
    /**
     * Create a new user using the following flow:
     *                 1. Validate and parse the identity provider access token to construct an identity provider user
     *                 2. If identity provider user present in linked account table, read user profile for this specific application from user profile table
     *                 3.    If user profile exists, return user conflict
     *                 4.    Otherwise, it means that the user does not have a profile for this particular application. Create one.
     *                 5. Otherwise, the identity provider user is not present. Create the user, and its user profile.
     *                 6. Generate session token, and return
     *             The purpose of steps 2-4 is to ensure that if the user has already registered with us using the same identity provider
     *             but for a different SocialPlus application, we reuse his user-handle and just resume to create a new profile for this specific
     *             SocialPlus application. The end result is that we know it is the same user in both apps.
     *
     * @param request Post user request
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostUserResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostUserResponse> postUser(PostUserRequest request) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new user using the following flow:
     *                 1. Validate and parse the identity provider access token to construct an identity provider user
     *                 2. If identity provider user present in linked account table, read user profile for this specific application from user profile table
     *                 3.    If user profile exists, return user conflict
     *                 4.    Otherwise, it means that the user does not have a profile for this particular application. Create one.
     *                 5. Otherwise, the identity provider user is not present. Create the user, and its user profile.
     *                 6. Generate session token, and return
     *             The purpose of steps 2-4 is to ensure that if the user has already registered with us using the same identity provider
     *             but for a different SocialPlus application, we reuse his user-handle and just resume to create a new profile for this specific
     *             SocialPlus application. The end result is that we know it is the same user in both apps.
     *
     * @param request Post user request
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postUserAsync(PostUserRequest request, final ServiceCallback<PostUserResponse> serviceCallback) throws IllegalArgumentException;
    /**
     * Create a new user using the following flow:
     *                 1. Validate and parse the identity provider access token to construct an identity provider user
     *                 2. If identity provider user present in linked account table, read user profile for this specific application from user profile table
     *                 3.    If user profile exists, return user conflict
     *                 4.    Otherwise, it means that the user does not have a profile for this particular application. Create one.
     *                 5. Otherwise, the identity provider user is not present. Create the user, and its user profile.
     *                 6. Generate session token, and return
     *             The purpose of steps 2-4 is to ensure that if the user has already registered with us using the same identity provider
     *             but for a different SocialPlus application, we reuse his user-handle and just resume to create a new profile for this specific
     *             SocialPlus application. The end result is that we know it is the same user in both apps.
     *
     * @param request Post user request
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PostUserResponse object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<PostUserResponse> postUser(PostUserRequest request, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Create a new user using the following flow:
     *                 1. Validate and parse the identity provider access token to construct an identity provider user
     *                 2. If identity provider user present in linked account table, read user profile for this specific application from user profile table
     *                 3.    If user profile exists, return user conflict
     *                 4.    Otherwise, it means that the user does not have a profile for this particular application. Create one.
     *                 5. Otherwise, the identity provider user is not present. Create the user, and its user profile.
     *                 6. Generate session token, and return
     *             The purpose of steps 2-4 is to ensure that if the user has already registered with us using the same identity provider
     *             but for a different SocialPlus application, we reuse his user-handle and just resume to create a new profile for this specific
     *             SocialPlus application. The end result is that we know it is the same user in both apps.
     *
     * @param request Post user request
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall postUserAsync(PostUserRequest request, String appkey, String authorization, final ServiceCallback<PostUserResponse> serviceCallback) throws IllegalArgumentException;

    /**
     * Get my profile.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserProfileView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<UserProfileView> getMyProfile(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get my profile.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getMyProfileAsync(String authorization, final ServiceCallback<UserProfileView> serviceCallback) throws IllegalArgumentException;

    /**
     * Delete user.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> deleteUser(String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Delete user.
     *
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteUserAsync(String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Update user info.
     *
     * @param request Put user info request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> putUserInfo(PutUserInfoRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Update user info.
     *
     * @param request Put user info request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall putUserInfoAsync(PutUserInfoRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Update user photo.
     *
     * @param request Put user photo request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> putUserPhoto(PutUserPhotoRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Update user photo.
     *
     * @param request Put user photo request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall putUserPhotoAsync(PutUserPhotoRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Update user visibility.
     *
     * @param request Put user visibility request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<Object> putUserVisibility(PutUserVisibilityRequest request, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Update user visibility.
     *
     * @param request Put user visibility request
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall putUserVisibilityAsync(PutUserVisibilityRequest request, String authorization, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException;

    /**
     * Get user profile.
     *
     * @param userHandle User handle
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserProfileView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<UserProfileView> getUser(String userHandle) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get user profile.
     *
     * @param userHandle User handle
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getUserAsync(String userHandle, final ServiceCallback<UserProfileView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get user profile.
     *
     * @param userHandle User handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the UserProfileView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<UserProfileView> getUser(String userHandle, String appkey, String authorization) throws ServiceException, IOException, IllegalArgumentException;

    /**
     * Get user profile.
     *
     * @param userHandle User handle
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getUserAsync(String userHandle, String appkey, String authorization, final ServiceCallback<UserProfileView> serviceCallback) throws IllegalArgumentException;

    /**
     * Get popular users.
     *
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseUserProfileView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserProfileView> getPopularUsers() throws ServiceException, IOException;

    /**
     * Get popular users.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPopularUsersAsync(final ServiceCallback<FeedResponseUserProfileView> serviceCallback) throws IllegalArgumentException;
    /**
     * Get popular users.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @throws ServiceException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the FeedResponseUserProfileView object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FeedResponseUserProfileView> getPopularUsers(Integer cursor, Integer limit, String appkey, String authorization) throws ServiceException, IOException;

    /**
     * Get popular users.
     *
     * @param cursor Current read cursor
     * @param limit Number of items to return
     * @param appkey App Key Authentication
     * @param authorization Authenication (must begin with string "Bearer ")
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getPopularUsersAsync(Integer cursor, Integer limit, String appkey, String authorization, final ServiceCallback<FeedResponseUserProfileView> serviceCallback) throws IllegalArgumentException;

}

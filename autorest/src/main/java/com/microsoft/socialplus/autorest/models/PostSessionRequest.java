/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to post (create) session.
 */
public class PostSessionRequest {
    /**
     * Gets or sets identity provider type. Possible values include:
     * 'Facebook', 'Microsoft', 'Google', 'Twitter'.
     */
    @JsonProperty(required = true)
    private IdentityProvider identityProvider;

    /**
     * Gets or sets access or authentication token, user code, or verifier
     * obtained from third-party provider.
     * The server contacts the third-party provider to use the
     * token (or user code, or verifier) for discover the user's identity.
     */
    private String accessToken;

    /**
     * Gets or sets request token obtained from third-party provider.
     * Some providers do not issue authentication or access
     * tokens, but they issue request tokens
     * and verifiers.
     */
    private String requestToken;

    /**
     * Gets or sets instance id -- Unique installation id of the app.
     */
    @JsonProperty(required = true)
    private String instanceId;

    /**
     * Gets or sets a value indicating whether we should create a new user if
     * the user doesn't exist.
     */
    private Boolean createUser;

    /**
     * Get the identityProvider value.
     *
     * @return the identityProvider value
     */
    public IdentityProvider getIdentityProvider() {
        return this.identityProvider;
    }

    /**
     * Set the identityProvider value.
     *
     * @param identityProvider the identityProvider value to set
     */
    public void setIdentityProvider(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }

    /**
     * Get the accessToken value.
     *
     * @return the accessToken value
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Set the accessToken value.
     *
     * @param accessToken the accessToken value to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Get the requestToken value.
     *
     * @return the requestToken value
     */
    public String getRequestToken() {
        return this.requestToken;
    }

    /**
     * Set the requestToken value.
     *
     * @param requestToken the requestToken value to set
     */
    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    /**
     * Get the instanceId value.
     *
     * @return the instanceId value
     */
    public String getInstanceId() {
        return this.instanceId;
    }

    /**
     * Set the instanceId value.
     *
     * @param instanceId the instanceId value to set
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * Get the createUser value.
     *
     * @return the createUser value
     */
    public Boolean getCreateUser() {
        return this.createUser;
    }

    /**
     * Set the createUser value.
     *
     * @param createUser the createUser value to set
     */
    public void setCreateUser(Boolean createUser) {
        this.createUser = createUser;
    }

}

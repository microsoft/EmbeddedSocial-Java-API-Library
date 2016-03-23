/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from get request token response.
 */
public class GetRequestTokenResponse {
    /**
     * Gets or sets request token from identity provider.
     */
    @JsonProperty(required = true)
    private String requestToken;

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

}

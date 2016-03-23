/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Linked account view.
 */
public class LinkedAccountView {
    /**
     * Gets or sets identity provider type. Possible values include:
     * 'Facebook', 'Microsoft', 'Google', 'Twitter', 'Beihai'.
     */
    @JsonProperty(required = true)
    private IdentityProvider identityProvider;

    /**
     * Gets or sets third party account id -- Unique user id provided by the
     * third-party identity provider.
     */
    @JsonProperty(required = true)
    private String accountId;

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
     * Get the accountId value.
     *
     * @return the accountId value
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Set the accountId value.
     *
     * @param accountId the accountId value to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}

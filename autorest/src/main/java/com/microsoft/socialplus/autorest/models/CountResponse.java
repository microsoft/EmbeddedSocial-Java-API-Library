/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Count response.
 */
public class CountResponse {
    /**
     * Gets or sets count.
     */
    @JsonProperty(required = true)
    private long count;

    /**
     * Get the count value.
     *
     * @return the count value
     */
    public long getCount() {
        return this.count;
    }

    /**
     * Set the count value.
     *
     * @param count the count value to set
     */
    public void setCount(long count) {
        this.count = count;
    }

}

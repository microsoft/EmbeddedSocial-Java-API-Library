/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Feed response.
 */
public class FeedResponseUserCompactView {
    /**
     * Gets or sets feed data.
     */
    @JsonProperty(required = true)
    private List<UserCompactView> data;

    /**
     * Gets or sets feed cursor.
     */
    @JsonProperty(required = true)
    private String cursor;

    /**
     * Get the data value.
     *
     * @return the data value
     */
    public List<UserCompactView> getData() {
        return this.data;
    }

    /**
     * Set the data value.
     *
     * @param data the data value to set
     */
    public void setData(List<UserCompactView> data) {
        this.data = data;
    }

    /**
     * Get the cursor value.
     *
     * @return the cursor value
     */
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Set the cursor value.
     *
     * @param cursor the cursor value to set
     */
    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

}

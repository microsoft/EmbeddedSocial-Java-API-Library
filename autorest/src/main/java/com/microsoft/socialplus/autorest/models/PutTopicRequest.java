/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to put (update) topic.
 */
public class PutTopicRequest {
    /**
     * Gets or sets topic title.
     */
    private String title;

    /**
     * Gets or sets topic text.
     */
    @JsonProperty(required = true)
    private String text;

    /**
     * Gets or sets topic categories.
     */
    private String categories;

    /**
     * Get the title value.
     *
     * @return the title value
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title value.
     *
     * @param title the title value to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the text value.
     *
     * @return the text value
     */
    public String getText() {
        return this.text;
    }

    /**
     * Set the text value.
     *
     * @param text the text value to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get the categories value.
     *
     * @return the categories value
     */
    public String getCategories() {
        return this.categories;
    }

    /**
     * Set the categories value.
     *
     * @param categories the categories value to set
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }

}

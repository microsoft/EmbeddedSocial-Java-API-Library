/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to post (create) reply.
 */
public class PostReplyRequest {
    /**
     * Gets or sets reply text.
     */
    @JsonProperty(required = true)
    private String text;

    /**
     * Gets or sets reply language.
     */
    private String language;

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
     * Get the language value.
     *
     * @return the language value
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Set the language value.
     *
     * @param language the language value to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

}

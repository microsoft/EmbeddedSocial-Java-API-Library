/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from post (create) topic.
 */
public class PostTopicResponse {
    /**
     * Gets or sets topic handle of the topic.
     */
    @JsonProperty(required = true)
    private String topicHandle;

    /**
     * Get the topicHandle value.
     *
     * @return the topicHandle value
     */
    public String getTopicHandle() {
        return this.topicHandle;
    }

    /**
     * Set the topicHandle value.
     *
     * @param topicHandle the topicHandle value to set
     */
    public void setTopicHandle(String topicHandle) {
        this.topicHandle = topicHandle;
    }

}

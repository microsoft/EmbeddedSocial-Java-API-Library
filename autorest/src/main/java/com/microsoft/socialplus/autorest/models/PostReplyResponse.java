/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from post (create) reply.
 */
public class PostReplyResponse {
    /**
     * Gets or sets reply handle of the reply.
     */
    @JsonProperty(required = true)
    private String replyHandle;

    /**
     * Get the replyHandle value.
     *
     * @return the replyHandle value
     */
    public String getReplyHandle() {
        return this.replyHandle;
    }

    /**
     * Set the replyHandle value.
     *
     * @param replyHandle the replyHandle value to set
     */
    public void setReplyHandle(String replyHandle) {
        this.replyHandle = replyHandle;
    }

}

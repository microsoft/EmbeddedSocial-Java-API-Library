/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to post (create) a report for user or content.
 */
public class PostReportRequest {
    /**
     * Gets or sets report reason. Possible values include: 'Spam',
     * 'Cyberbullying', 'ChildEndangerment', 'Offensive',
     * 'ContentInfringement', 'Other'.
     */
    @JsonProperty(required = true)
    private Reason reason;

    /**
     * Get the reason value.
     *
     * @return the reason value
     */
    public Reason getReason() {
        return this.reason;
    }

    /**
     * Set the reason value.
     *
     * @param reason the reason value to set
     */
    public void setReason(Reason reason) {
        this.reason = reason;
    }

}

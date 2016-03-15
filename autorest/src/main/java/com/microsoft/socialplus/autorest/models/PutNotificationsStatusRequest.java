/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;


/**
 * Request to put (update) notifications status.
 */
public class PutNotificationsStatusRequest {
    /**
     * Gets or sets last read activity handle.
     */
    private String readActivityHandle;

    /**
     * Get the readActivityHandle value.
     *
     * @return the readActivityHandle value
     */
    public String getReadActivityHandle() {
        return this.readActivityHandle;
    }

    /**
     * Set the readActivityHandle value.
     *
     * @param readActivityHandle the readActivityHandle value to set
     */
    public void setReadActivityHandle(String readActivityHandle) {
        this.readActivityHandle = readActivityHandle;
    }

}

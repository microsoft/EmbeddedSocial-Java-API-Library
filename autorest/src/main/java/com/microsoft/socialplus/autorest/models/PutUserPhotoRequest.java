/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;


/**
 * Request to put (update) user photo.
 */
public class PutUserPhotoRequest {
    /**
     * Gets or sets photo handle of the user.
     */
    private String photoHandle;

    /**
     * Get the photoHandle value.
     *
     * @return the photoHandle value
     */
    public String getPhotoHandle() {
        return this.photoHandle;
    }

    /**
     * Set the photoHandle value.
     *
     * @param photoHandle the photoHandle value to set
     */
    public void setPhotoHandle(String photoHandle) {
        this.photoHandle = photoHandle;
    }

}

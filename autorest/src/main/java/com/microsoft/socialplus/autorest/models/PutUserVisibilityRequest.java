/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to put (update) user visibility.
 */
public class PutUserVisibilityRequest {
    /**
     * Gets or sets visibility of the user. Possible values include: 'Public',
     * 'Private'.
     */
    @JsonProperty(required = true)
    private Visibility visibility;

    /**
     * Get the visibility value.
     *
     * @return the visibility value
     */
    public Visibility getVisibility() {
        return this.visibility;
    }

    /**
     * Set the visibility value.
     *
     * @param visibility the visibility value to set
     */
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

}

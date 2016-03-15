/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User compact view.
 */
public class UserCompactView {
    /**
     * Gets or sets user handle.
     */
    @JsonProperty(required = true)
    private String userHandle;

    /**
     * Gets or sets first name of the user.
     */
    @JsonProperty(required = true)
    private String firstName;

    /**
     * Gets or sets last name of the user.
     */
    @JsonProperty(required = true)
    private String lastName;

    /**
     * Gets or sets photo handle of the user.
     */
    private String photoHandle;

    /**
     * Gets or sets photo url of the user.
     */
    private String photoUrl;

    /**
     * Gets or sets visibility of the user. Possible values include: 'Public',
     * 'Private'.
     */
    @JsonProperty(required = true)
    private Visibility visibility;

    /**
     * Gets or sets follower relationship status of the querying user.
     * Possible values include: 'None', 'Follow', 'Pending', 'Blocked'.
     */
    @JsonProperty(required = true)
    private FollowerStatus followerStatus;

    /**
     * Get the userHandle value.
     *
     * @return the userHandle value
     */
    public String getUserHandle() {
        return this.userHandle;
    }

    /**
     * Set the userHandle value.
     *
     * @param userHandle the userHandle value to set
     */
    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    /**
     * Get the firstName value.
     *
     * @return the firstName value
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set the firstName value.
     *
     * @param firstName the firstName value to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the lastName value.
     *
     * @return the lastName value
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set the lastName value.
     *
     * @param lastName the lastName value to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    /**
     * Get the photoUrl value.
     *
     * @return the photoUrl value
     */
    public String getPhotoUrl() {
        return this.photoUrl;
    }

    /**
     * Set the photoUrl value.
     *
     * @param photoUrl the photoUrl value to set
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

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

    /**
     * Get the followerStatus value.
     *
     * @return the followerStatus value
     */
    public FollowerStatus getFollowerStatus() {
        return this.followerStatus;
    }

    /**
     * Set the followerStatus value.
     *
     * @param followerStatus the followerStatus value to set
     */
    public void setFollowerStatus(FollowerStatus followerStatus) {
        this.followerStatus = followerStatus;
    }

}

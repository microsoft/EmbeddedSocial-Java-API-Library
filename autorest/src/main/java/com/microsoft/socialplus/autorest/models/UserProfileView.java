/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User profile view.
 */
public class UserProfileView {
    /**
     * Gets or sets user handle.
     */
    @JsonProperty(required = true)
    private String userHandle;

    /**
     * Gets or sets app handle.
     */
    @JsonProperty(required = true)
    private String appHandle;

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
     * Gets or sets short bio of the user.
     */
    @JsonProperty(required = true)
    private String bio;

    /**
     * Gets or sets photo handle of the user.
     */
    @JsonProperty(required = true)
    private String photoHandle;

    /**
     * Gets or sets photo url of the user.
     */
    @JsonProperty(required = true)
    private String photoUrl;

    /**
     * Gets or sets visibility of the user. Possible values include: 'Public',
     * 'Private'.
     */
    @JsonProperty(required = true)
    private Visibility visibility;

    /**
     * Gets or sets total topics posted by user.
     */
    @JsonProperty(required = true)
    private long totalTopics;

    /**
     * Gets or sets total followers for the user.
     */
    @JsonProperty(required = true)
    private long totalFollowers;

    /**
     * Gets or sets total following users.
     */
    @JsonProperty(required = true)
    private long totalFollowing;

    /**
     * Gets or sets follower relationship status of the querying user.
     * Possible values include: 'None', 'Follow', 'Pending', 'Blocked'.
     */
    @JsonProperty(required = true)
    private FollowerStatus followerStatus;

    /**
     * Gets or sets following relationship status of the querying user.
     * Possible values include: 'None', 'Follow', 'Pending', 'Blocked'.
     */
    @JsonProperty(required = true)
    private FollowingStatus followingStatus;

    /**
     * Gets or sets user profile status. Possible values include: 'Active',
     * 'Banned'.
     */
    @JsonProperty(required = true)
    private ProfileStatus profileStatus;

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
     * Get the appHandle value.
     *
     * @return the appHandle value
     */
    public String getAppHandle() {
        return this.appHandle;
    }

    /**
     * Set the appHandle value.
     *
     * @param appHandle the appHandle value to set
     */
    public void setAppHandle(String appHandle) {
        this.appHandle = appHandle;
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
     * Get the bio value.
     *
     * @return the bio value
     */
    public String getBio() {
        return this.bio;
    }

    /**
     * Set the bio value.
     *
     * @param bio the bio value to set
     */
    public void setBio(String bio) {
        this.bio = bio;
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
     * Get the totalTopics value.
     *
     * @return the totalTopics value
     */
    public long getTotalTopics() {
        return this.totalTopics;
    }

    /**
     * Set the totalTopics value.
     *
     * @param totalTopics the totalTopics value to set
     */
    public void setTotalTopics(long totalTopics) {
        this.totalTopics = totalTopics;
    }

    /**
     * Get the totalFollowers value.
     *
     * @return the totalFollowers value
     */
    public long getTotalFollowers() {
        return this.totalFollowers;
    }

    /**
     * Set the totalFollowers value.
     *
     * @param totalFollowers the totalFollowers value to set
     */
    public void setTotalFollowers(long totalFollowers) {
        this.totalFollowers = totalFollowers;
    }

    /**
     * Get the totalFollowing value.
     *
     * @return the totalFollowing value
     */
    public long getTotalFollowing() {
        return this.totalFollowing;
    }

    /**
     * Set the totalFollowing value.
     *
     * @param totalFollowing the totalFollowing value to set
     */
    public void setTotalFollowing(long totalFollowing) {
        this.totalFollowing = totalFollowing;
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

    /**
     * Get the followingStatus value.
     *
     * @return the followingStatus value
     */
    public FollowingStatus getFollowingStatus() {
        return this.followingStatus;
    }

    /**
     * Set the followingStatus value.
     *
     * @param followingStatus the followingStatus value to set
     */
    public void setFollowingStatus(FollowingStatus followingStatus) {
        this.followingStatus = followingStatus;
    }

    /**
     * Get the profileStatus value.
     *
     * @return the profileStatus value
     */
    public ProfileStatus getProfileStatus() {
        return this.profileStatus;
    }

    /**
     * Set the profileStatus value.
     *
     * @param profileStatus the profileStatus value to set
     */
    public void setProfileStatus(ProfileStatus profileStatus) {
        this.profileStatus = profileStatus;
    }

}

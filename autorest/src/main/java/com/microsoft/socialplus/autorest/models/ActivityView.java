/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import java.util.List;

/**
 * Activity view.
 */
public class ActivityView {
    /**
     * Gets or sets activity handle.
     */
    @JsonProperty(required = true)
    private String activityHandle;

    /**
     * Gets or sets created time.
     */
    @JsonProperty(required = true)
    private DateTime createdTime;

    /**
     * Gets or sets activity type. Possible values include: 'Like', 'Comment',
     * 'Reply', 'CommentPeer', 'ReplyPeer', 'Following', 'FollowRequest',
     * 'FollowAccept'.
     */
    @JsonProperty(required = true)
    private ActivityType activityType;

    /**
     * Gets or sets actor users.
     */
    @JsonProperty(required = true)
    private List<UserCompactView> actorUsers;

    /**
     * Gets or sets acted on user.
     */
    private UserCompactView actedOnUser;

    /**
     * Gets or sets acted on content.
     */
    private ContentCompactView actedOnContent;

    /**
     * Gets or sets total actions.
     */
    @JsonProperty(required = true)
    private int totalActions;

    /**
     * Gets or sets a value indicating whether the activity was read.
     */
    @JsonProperty(required = true)
    private boolean unread;

    /**
     * Gets or sets the containing app.
     */
    private AppCompactView app;

    /**
     * Get the activityHandle value.
     *
     * @return the activityHandle value
     */
    public String getActivityHandle() {
        return this.activityHandle;
    }

    /**
     * Set the activityHandle value.
     *
     * @param activityHandle the activityHandle value to set
     */
    public void setActivityHandle(String activityHandle) {
        this.activityHandle = activityHandle;
    }

    /**
     * Get the createdTime value.
     *
     * @return the createdTime value
     */
    public DateTime getCreatedTime() {
        return this.createdTime;
    }

    /**
     * Set the createdTime value.
     *
     * @param createdTime the createdTime value to set
     */
    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Get the activityType value.
     *
     * @return the activityType value
     */
    public ActivityType getActivityType() {
        return this.activityType;
    }

    /**
     * Set the activityType value.
     *
     * @param activityType the activityType value to set
     */
    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    /**
     * Get the actorUsers value.
     *
     * @return the actorUsers value
     */
    public List<UserCompactView> getActorUsers() {
        return this.actorUsers;
    }

    /**
     * Set the actorUsers value.
     *
     * @param actorUsers the actorUsers value to set
     */
    public void setActorUsers(List<UserCompactView> actorUsers) {
        this.actorUsers = actorUsers;
    }

    /**
     * Get the actedOnUser value.
     *
     * @return the actedOnUser value
     */
    public UserCompactView getActedOnUser() {
        return this.actedOnUser;
    }

    /**
     * Set the actedOnUser value.
     *
     * @param actedOnUser the actedOnUser value to set
     */
    public void setActedOnUser(UserCompactView actedOnUser) {
        this.actedOnUser = actedOnUser;
    }

    /**
     * Get the actedOnContent value.
     *
     * @return the actedOnContent value
     */
    public ContentCompactView getActedOnContent() {
        return this.actedOnContent;
    }

    /**
     * Set the actedOnContent value.
     *
     * @param actedOnContent the actedOnContent value to set
     */
    public void setActedOnContent(ContentCompactView actedOnContent) {
        this.actedOnContent = actedOnContent;
    }

    /**
     * Get the totalActions value.
     *
     * @return the totalActions value
     */
    public int getTotalActions() {
        return this.totalActions;
    }

    /**
     * Set the totalActions value.
     *
     * @param totalActions the totalActions value to set
     */
    public void setTotalActions(int totalActions) {
        this.totalActions = totalActions;
    }

    /**
     * Get the unread value.
     *
     * @return the unread value
     */
    public boolean getUnread() {
        return this.unread;
    }

    /**
     * Set the unread value.
     *
     * @param unread the unread value to set
     */
    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    /**
     * Get the app value.
     *
     * @return the app value
     */
    public AppCompactView getApp() {
        return this.app;
    }

    /**
     * Set the app value.
     *
     * @param app the app value to set
     */
    public void setApp(AppCompactView app) {
        this.app = app;
    }

}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

/**
 * Topic view.
 */
public class TopicView {
    /**
     * Gets or sets topic handle.
     */
    @JsonProperty(required = true)
    private String topicHandle;

    /**
     * Gets or sets created time.
     */
    @JsonProperty(required = true)
    private DateTime createdTime;

    /**
     * Gets or sets last updated time.
     */
    @JsonProperty(required = true)
    private DateTime lastUpdatedTime;

    /**
     * Gets or sets publisher type. Possible values include: 'User', 'App'.
     */
    @JsonProperty(required = true)
    private PublisherType publisherType;

    /**
     * Gets or sets owner of the topic.
     */
    @JsonProperty(required = true)
    private UserCompactView user;

    /**
     * Gets or sets topic title.
     */
    private String title;

    /**
     * Gets or sets topic text.
     */
    @JsonProperty(required = true)
    private String text;

    /**
     * Gets or sets topic blob type. Possible values include: 'Unknown',
     * 'Image', 'Video', 'Custom'.
     */
    private BlobType blobType;

    /**
     * Gets or sets topic blob handle.
     */
    private String blobHandle;

    /**
     * Gets or sets topic blob url.
     */
    private String blobUrl;

    /**
     * Gets or sets topic categories.
     */
    private String categories;

    /**
     * Gets or sets topic language.
     */
    private String language;

    /**
     * Gets or sets topic group.
     */
    private String group;

    /**
     * Gets or sets topic deep link.
     */
    private String deepLink;

    /**
     * Gets or sets topic friendly name.
     */
    private String friendlyName;

    /**
     * Gets or sets total likes for the topic.
     */
    @JsonProperty(required = true)
    private long totalLikes;

    /**
     * Gets or sets total comments for the topic.
     */
    @JsonProperty(required = true)
    private long totalComments;

    /**
     * Gets or sets a value indicating whether the querying user has liked the
     * topic.
     */
    @JsonProperty(required = true)
    private boolean liked;

    /**
     * Gets or sets a value indicating whether the querying user has pinned
     * the topic.
     */
    private Boolean pinned;

    /**
     * Gets or sets content status. Possible values include: 'Active',
     * 'Banned'.
     */
    private ContentStatus contentStatus;

    /**
     * Gets or sets the containing app.
     */
    private AppCompactView app;

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
     * Get the lastUpdatedTime value.
     *
     * @return the lastUpdatedTime value
     */
    public DateTime getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * Set the lastUpdatedTime value.
     *
     * @param lastUpdatedTime the lastUpdatedTime value to set
     */
    public void setLastUpdatedTime(DateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     * Get the publisherType value.
     *
     * @return the publisherType value
     */
    public PublisherType getPublisherType() {
        return this.publisherType;
    }

    /**
     * Set the publisherType value.
     *
     * @param publisherType the publisherType value to set
     */
    public void setPublisherType(PublisherType publisherType) {
        this.publisherType = publisherType;
    }

    /**
     * Get the user value.
     *
     * @return the user value
     */
    public UserCompactView getUser() {
        return this.user;
    }

    /**
     * Set the user value.
     *
     * @param user the user value to set
     */
    public void setUser(UserCompactView user) {
        this.user = user;
    }

    /**
     * Get the title value.
     *
     * @return the title value
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title value.
     *
     * @param title the title value to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

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
     * Get the blobType value.
     *
     * @return the blobType value
     */
    public BlobType getBlobType() {
        return this.blobType;
    }

    /**
     * Set the blobType value.
     *
     * @param blobType the blobType value to set
     */
    public void setBlobType(BlobType blobType) {
        this.blobType = blobType;
    }

    /**
     * Get the blobHandle value.
     *
     * @return the blobHandle value
     */
    public String getBlobHandle() {
        return this.blobHandle;
    }

    /**
     * Set the blobHandle value.
     *
     * @param blobHandle the blobHandle value to set
     */
    public void setBlobHandle(String blobHandle) {
        this.blobHandle = blobHandle;
    }

    /**
     * Get the blobUrl value.
     *
     * @return the blobUrl value
     */
    public String getBlobUrl() {
        return this.blobUrl;
    }

    /**
     * Set the blobUrl value.
     *
     * @param blobUrl the blobUrl value to set
     */
    public void setBlobUrl(String blobUrl) {
        this.blobUrl = blobUrl;
    }

    /**
     * Get the categories value.
     *
     * @return the categories value
     */
    public String getCategories() {
        return this.categories;
    }

    /**
     * Set the categories value.
     *
     * @param categories the categories value to set
     */
    public void setCategories(String categories) {
        this.categories = categories;
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

    /**
     * Get the group value.
     *
     * @return the group value
     */
    public String getGroup() {
        return this.group;
    }

    /**
     * Set the group value.
     *
     * @param group the group value to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Get the deepLink value.
     *
     * @return the deepLink value
     */
    public String getDeepLink() {
        return this.deepLink;
    }

    /**
     * Set the deepLink value.
     *
     * @param deepLink the deepLink value to set
     */
    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    /**
     * Get the friendlyName value.
     *
     * @return the friendlyName value
     */
    public String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Set the friendlyName value.
     *
     * @param friendlyName the friendlyName value to set
     */
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * Get the totalLikes value.
     *
     * @return the totalLikes value
     */
    public long getTotalLikes() {
        return this.totalLikes;
    }

    /**
     * Set the totalLikes value.
     *
     * @param totalLikes the totalLikes value to set
     */
    public void setTotalLikes(long totalLikes) {
        this.totalLikes = totalLikes;
    }

    /**
     * Get the totalComments value.
     *
     * @return the totalComments value
     */
    public long getTotalComments() {
        return this.totalComments;
    }

    /**
     * Set the totalComments value.
     *
     * @param totalComments the totalComments value to set
     */
    public void setTotalComments(long totalComments) {
        this.totalComments = totalComments;
    }

    /**
     * Get the liked value.
     *
     * @return the liked value
     */
    public boolean getLiked() {
        return this.liked;
    }

    /**
     * Set the liked value.
     *
     * @param liked the liked value to set
     */
    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    /**
     * Get the pinned value.
     *
     * @return the pinned value
     */
    public Boolean getPinned() {
        return this.pinned;
    }

    /**
     * Set the pinned value.
     *
     * @param pinned the pinned value to set
     */
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    /**
     * Get the contentStatus value.
     *
     * @return the contentStatus value
     */
    public ContentStatus getContentStatus() {
        return this.contentStatus;
    }

    /**
     * Set the contentStatus value.
     *
     * @param contentStatus the contentStatus value to set
     */
    public void setContentStatus(ContentStatus contentStatus) {
        this.contentStatus = contentStatus;
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

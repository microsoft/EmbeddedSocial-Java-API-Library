/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * <autogenerated> This file was generated using AutoRest. </autogenerated>
 */

package com.microsoft.socialplus.autorest.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comment view.
 */
public class CommentView {
    /**
     * Gets or sets comment handle.
     */
    @JsonProperty(required = true)
    private String commentHandle;

    /**
     * Gets or sets parent topic handle.
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
     * Gets or sets owner of the comment.
     */
    @JsonProperty(required = true)
    private UserCompactView user;

    /**
     * Gets or sets comment text.
     */
    @JsonProperty(required = true)
    private String text;

    /**
     * Gets or sets comment blob type. Possible values include: 'Unknown',
     * 'Image', 'Video', 'Custom'.
     */
    private BlobType blobType;

    /**
     * Gets or sets comment blob handle.
     */
    private String blobHandle;

    /**
     * Gets or sets comment blob url.
     */
    private String blobUrl;

    /**
     * Gets or sets comment language.
     */
    private String language;

    /**
     * Gets or sets total likes for the comment.
     */
    @JsonProperty(required = true)
    private long totalLikes;

    /**
     * Gets or sets total replies for the comment.
     */
    @JsonProperty(required = true)
    private long totalReplies;

    /**
     * Gets or sets a value indicating whether the querying user has liked the
     * comment.
     */
    @JsonProperty(required = true)
    private boolean liked;

    /**
     * Gets or sets content status. Possible values include: 'Active',
     * 'Banned', 'Mature', 'Clean'.
     */
    private ContentStatus contentStatus;

    /**
     * Get the commentHandle value.
     *
     * @return the commentHandle value
     */
    public String getCommentHandle() {
        return this.commentHandle;
    }

    /**
     * Set the commentHandle value.
     *
     * @param commentHandle the commentHandle value to set
     */
    public void setCommentHandle(String commentHandle) {
        this.commentHandle = commentHandle;
    }

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
     * Get the totalReplies value.
     *
     * @return the totalReplies value
     */
    public long getTotalReplies() {
        return this.totalReplies;
    }

    /**
     * Set the totalReplies value.
     *
     * @param totalReplies the totalReplies value to set
     */
    public void setTotalReplies(long totalReplies) {
        this.totalReplies = totalReplies;
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

}
/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

/**
 * Reply view.
 */
public class ReplyView {
    /**
     * Gets or sets reply handle.
     */
    @JsonProperty(required = true)
    private String replyHandle;

    /**
     * Gets or sets parent comment handle.
     */
    @JsonProperty(required = true)
    private String commentHandle;

    /**
     * Gets or sets root topic handle.
     */
    @JsonProperty(required = true)
    private String topicHandle;

    /**
     * Gets or sets created time.
     */
    @JsonProperty(required = true)
    private DateTime createdTime;

    /**
     * Gets or sets owner of the reply.
     */
    @JsonProperty(required = true)
    private UserCompactView user;

    /**
     * Gets or sets reply text.
     */
    @JsonProperty(required = true)
    private String text;

    /**
     * Gets or sets reply language.
     */
    private String language;

    /**
     * Gets or sets total likes for the reply.
     */
    @JsonProperty(required = true)
    private long totalLikes;

    /**
     * Gets or sets a value indicating whether the querying user has liked the
     * reply.
     */
    @JsonProperty(required = true)
    private boolean liked;

    /**
     * Gets or sets content status. Possible values include: 'Active',
     * 'Banned'.
     */
    private ContentStatus contentStatus;

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

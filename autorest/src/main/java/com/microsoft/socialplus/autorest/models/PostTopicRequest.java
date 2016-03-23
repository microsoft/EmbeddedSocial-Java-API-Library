/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request to post (create) topic.
 */
public class PostTopicRequest {
    /**
     * Gets or sets publisher type. Possible values include: 'User', 'App'.
     */
    @JsonProperty(required = true)
    private PublisherType publisherType;

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
     * Gets or sets topic categories.
     */
    private String categories;

    /**
     * Gets or sets topic language.
     */
    private String language;

    /**
     * Gets or sets topic deep link.
     */
    private String deepLink;

    /**
     * Gets or sets topic friendly name.
     */
    private String friendlyName;

    /**
     * Gets or sets topic group.
     */
    private String group;

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

}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Content compact view.
 */
public class ContentCompactView {
    /**
     * Gets or sets content type. Possible values include: 'Unknown', 'Topic',
     * 'Comment', 'Reply'.
     */
    @JsonProperty(required = true)
    private ContentType contentType;

    /**
     * Gets or sets content handle.
     */
    @JsonProperty(required = true)
    private String contentHandle;

    /**
     * Gets or sets parent handle.
     */
    private String parentHandle;

    /**
     * Gets or sets root handle.
     */
    private String rootHandle;

    /**
     * Gets or sets content text.
     */
    @JsonProperty(required = true)
    private String text;

    /**
     * Gets or sets content blob type. Possible values include: 'Unknown',
     * 'Image', 'Video', 'Custom'.
     */
    private BlobType blobType;

    /**
     * Gets or sets content blob handle.
     */
    private String blobHandle;

    /**
     * Gets or sets content blob url.
     */
    private String blobUrl;

    /**
     * Get the contentType value.
     *
     * @return the contentType value
     */
    public ContentType getContentType() {
        return this.contentType;
    }

    /**
     * Set the contentType value.
     *
     * @param contentType the contentType value to set
     */
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    /**
     * Get the contentHandle value.
     *
     * @return the contentHandle value
     */
    public String getContentHandle() {
        return this.contentHandle;
    }

    /**
     * Set the contentHandle value.
     *
     * @param contentHandle the contentHandle value to set
     */
    public void setContentHandle(String contentHandle) {
        this.contentHandle = contentHandle;
    }

    /**
     * Get the parentHandle value.
     *
     * @return the parentHandle value
     */
    public String getParentHandle() {
        return this.parentHandle;
    }

    /**
     * Set the parentHandle value.
     *
     * @param parentHandle the parentHandle value to set
     */
    public void setParentHandle(String parentHandle) {
        this.parentHandle = parentHandle;
    }

    /**
     * Get the rootHandle value.
     *
     * @return the rootHandle value
     */
    public String getRootHandle() {
        return this.rootHandle;
    }

    /**
     * Set the rootHandle value.
     *
     * @param rootHandle the rootHandle value to set
     */
    public void setRootHandle(String rootHandle) {
        this.rootHandle = rootHandle;
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

}

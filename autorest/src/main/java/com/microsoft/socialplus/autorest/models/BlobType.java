/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for BlobType.
 */
public enum BlobType {
    /** Enum value Unknown. */
    UNKNOWN("Unknown"),

    /** Enum value Image. */
    IMAGE("Image"),

    /** Enum value Video. */
    VIDEO("Video"),

    /** Enum value Custom. */
    CUSTOM("Custom");

    /** The actual serialized value for a BlobType instance. */
    private String value;

    BlobType(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a BlobType instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a BlobType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed BlobType object, or null if unable to parse.
     */
    @JsonCreator
    public static BlobType fromValue(String value) {
        BlobType[] items = BlobType.values();
        for (BlobType item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return toValue();
    }
}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ImageType.
 */
public enum ImageType {
    /** Enum value UserPhoto. */
    USERPHOTO("UserPhoto"),

    /** Enum value ContentBlob. */
    CONTENTBLOB("ContentBlob"),

    /** Enum value AppIcon. */
    APPICON("AppIcon");

    /** The actual serialized value for a ImageType instance. */
    private String value;

    ImageType(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a ImageType instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a ImageType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ImageType object, or null if unable to parse.
     */
    @JsonCreator
    public static ImageType fromValue(String value) {
        ImageType[] items = ImageType.values();
        for (ImageType item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}

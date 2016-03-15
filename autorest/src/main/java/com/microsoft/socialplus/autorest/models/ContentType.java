/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ContentType.
 */
public enum ContentType {
    /** Enum value Unknown. */
    UNKNOWN("Unknown"),

    /** Enum value Topic. */
    TOPIC("Topic"),

    /** Enum value Comment. */
    COMMENT("Comment"),

    /** Enum value Reply. */
    REPLY("Reply");

    /** The actual serialized value for a ContentType instance. */
    private String value;

    ContentType(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a ContentType instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a ContentType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ContentType object, or null if unable to parse.
     */
    @JsonCreator
    public static ContentType fromValue(String value) {
        ContentType[] items = ContentType.values();
        for (ContentType item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}

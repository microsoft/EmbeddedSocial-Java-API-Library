/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for FollowerStatus.
 */
public enum FollowerStatus {
    /** Enum value None. */
    NONE("None"),

    /** Enum value Follow. */
    FOLLOW("Follow"),

    /** Enum value Pending. */
    PENDING("Pending"),

    /** Enum value Blocked. */
    BLOCKED("Blocked");

    /** The actual serialized value for a FollowerStatus instance. */
    private String value;

    FollowerStatus(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a FollowerStatus instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a FollowerStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed FollowerStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static FollowerStatus fromValue(String value) {
        FollowerStatus[] items = FollowerStatus.values();
        for (FollowerStatus item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}

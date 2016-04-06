/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for FollowingStatus.
 */
public enum FollowingStatus {
    /** Enum value None. */
    NONE("None"),

    /** Enum value Follow. */
    FOLLOW("Follow"),

    /** Enum value Pending. */
    PENDING("Pending"),

    /** Enum value Blocked. */
    BLOCKED("Blocked");

    /** The actual serialized value for a FollowingStatus instance. */
    private String value;

    FollowingStatus(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a FollowingStatus instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a FollowingStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed FollowingStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static FollowingStatus fromValue(String value) {
        FollowingStatus[] items = FollowingStatus.values();
        for (FollowingStatus item : items) {
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

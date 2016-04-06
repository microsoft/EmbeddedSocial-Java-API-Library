/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ContentStatus.
 */
public enum ContentStatus {
    /** Enum value Active. */
    ACTIVE("Active"),

    /** Enum value Banned. */
    BANNED("Banned");

    /** The actual serialized value for a ContentStatus instance. */
    private String value;

    ContentStatus(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a ContentStatus instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a ContentStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed ContentStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static ContentStatus fromValue(String value) {
        ContentStatus[] items = ContentStatus.values();
        for (ContentStatus item : items) {
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

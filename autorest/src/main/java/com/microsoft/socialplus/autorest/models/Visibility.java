/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for Visibility.
 */
public enum Visibility {
    /** Enum value Public. */
    PUBLIC("Public"),

    /** Enum value Private. */
    PRIVATE("Private");

    /** The actual serialized value for a Visibility instance. */
    private String value;

    Visibility(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a Visibility instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a Visibility instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed Visibility object, or null if unable to parse.
     */
    @JsonCreator
    public static Visibility fromValue(String value) {
        Visibility[] items = Visibility.values();
        for (Visibility item : items) {
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

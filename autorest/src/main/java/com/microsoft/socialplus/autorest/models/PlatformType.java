/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for PlatformType.
 */
public enum PlatformType {
    /** Enum value Windows. */
    WINDOWS("Windows"),

    /** Enum value Android. */
    ANDROID("Android"),

    /** Enum value IOS. */
    IOS("IOS");

    /** The actual serialized value for a PlatformType instance. */
    private String value;

    PlatformType(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a PlatformType instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a PlatformType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed PlatformType object, or null if unable to parse.
     */
    @JsonCreator
    public static PlatformType fromValue(String value) {
        PlatformType[] items = PlatformType.values();
        for (PlatformType item : items) {
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

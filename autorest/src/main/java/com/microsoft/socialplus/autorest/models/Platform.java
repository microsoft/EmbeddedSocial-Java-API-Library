/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for Platform.
 */
public enum Platform {
    /** Enum value Windows. */
    WINDOWS("Windows"),

    /** Enum value Android. */
    ANDROID("Android"),

    /** Enum value IOS. */
    IOS("IOS");

    /** The actual serialized value for a Platform instance. */
    private String value;

    Platform(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a Platform instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a Platform instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed Platform object, or null if unable to parse.
     */
    @JsonCreator
    public static Platform fromValue(String value) {
        Platform[] items = Platform.values();
        for (Platform item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}

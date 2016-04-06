/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for Reason.
 */
public enum Reason {
    /** Enum value Spam. */
    SPAM("Spam"),

    /** Enum value Cyberbullying. */
    CYBERBULLYING("Cyberbullying"),

    /** Enum value ChildEndangerment. */
    CHILDENDANGERMENT("ChildEndangerment"),

    /** Enum value Offensive. */
    OFFENSIVE("Offensive"),

    /** Enum value ContentInfringement. */
    CONTENTINFRINGEMENT("ContentInfringement"),

    /** Enum value Other. */
    OTHER("Other");

    /** The actual serialized value for a Reason instance. */
    private String value;

    Reason(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a Reason instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a Reason instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed Reason object, or null if unable to parse.
     */
    @JsonCreator
    public static Reason fromValue(String value) {
        Reason[] items = Reason.values();
        for (Reason item : items) {
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

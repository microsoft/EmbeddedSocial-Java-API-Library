/**
 * Copyright (c) Microsoft Corporation. All rights reserved. Licensed under
 * the MIT License. See LICENSE in the project root for license information.
 * This file was generated using AutoRest.
 */

package com.microsoft.socialplus.autorest.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for TimeRange.
 */
public enum TimeRange {
    /** Enum value Today. */
    TODAY("Today"),

    /** Enum value ThisWeek. */
    THISWEEK("ThisWeek"),

    /** Enum value ThisMonth. */
    THISMONTH("ThisMonth"),

    /** Enum value AllTime. */
    ALLTIME("AllTime");

    /** The actual serialized value for a TimeRange instance. */
    private String value;

    TimeRange(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a TimeRange instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a TimeRange instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed TimeRange object, or null if unable to parse.
     */
    @JsonCreator
    public static TimeRange fromValue(String value) {
        TimeRange[] items = TimeRange.values();
        for (TimeRange item : items) {
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

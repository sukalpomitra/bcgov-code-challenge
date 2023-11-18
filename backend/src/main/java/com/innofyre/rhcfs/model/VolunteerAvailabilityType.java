package com.innofyre.rhcfs.model;

public enum VolunteerAvailabilityType {
    IMMEDIATE(0),
    CUSTOM(1);


    private final int value;

    VolunteerAvailabilityType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VolunteerAvailabilityType fromValue(int value) {
        for (VolunteerAvailabilityType type : VolunteerAvailabilityType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid VolunteerAvailabilityType value: " + value);
    }
}

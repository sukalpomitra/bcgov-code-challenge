package com.innofyre.rhcfs.model;

public enum VolunteerStatus {
    ACTIVE(1),
    INACTIVE(2),
    PENDING(3);

    private final int value;

    VolunteerStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VolunteerStatus fromValue(int value) {
        for (VolunteerStatus status : VolunteerStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid VolunteerStatus value: " + value);
    }
}
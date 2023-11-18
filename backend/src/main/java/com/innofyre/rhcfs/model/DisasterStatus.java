package com.innofyre.rhcfs.model;

public enum DisasterStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final int value;

    DisasterStatus(int value) {
        this.value = value;
    }

  public static DisasterStatus fromValue(int value) {
        for (DisasterStatus status : DisasterStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid DisasterStatus value: " + value);
    }
}

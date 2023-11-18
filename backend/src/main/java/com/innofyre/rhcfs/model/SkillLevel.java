package com.innofyre.rhcfs.model;

public enum SkillLevel {
    ADVANCED(1),
    BEGINNER(2),
    INTERMEDIATE(3),
    NO_EXPERIENCE(4);

    private final int value;

    SkillLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SkillLevel fromValue(int value) {
        for (SkillLevel level : SkillLevel.values()) {
            if (level.value == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid SkillLevel value: " + value);
    }
}

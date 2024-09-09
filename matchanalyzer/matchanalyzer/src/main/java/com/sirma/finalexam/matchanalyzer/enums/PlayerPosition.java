package com.sirma.finalexam.matchanalyzer.enums;

public enum PlayerPosition {
    GK,
    DF,
    MF,
    FW;

    public static PlayerPosition fromString(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be null or empty");
        }

        String trimmedPosition = position.trim().toUpperCase();

        try {
            return PlayerPosition.valueOf(trimmedPosition);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid player position: " + position);
        }
    }
}

package com.kodilla.rockpaperscissors.game;

import java.util.EnumSet;

public enum SettingsDecision {

    HINTS(1), POINTS_REQUIRED_TO_WIN(2), LANGUAGE(3), BACK(4);

    int mappedInt;

    SettingsDecision(int mappedInt) {
        this.mappedInt = mappedInt;
    }

    static SettingsDecision of(int i) {
        return EnumSet.allOf(SettingsDecision.class).stream()
                .filter(d -> d.mappedInt == i)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}

package com.kodilla.rockpaperscissors.game.enumMenuOptions;

import java.util.EnumSet;


public enum SettingsDecision {

    HINTS(1), POINTS_REQUIRED_TO_WIN(2), LANGUAGE(3), BACK_TO_MENU(4);

    private int mappedInt;

    SettingsDecision(int mappedInt) {
        this.mappedInt = mappedInt;
    }

    public static SettingsDecision of(int i) {
        return EnumSet.allOf(SettingsDecision.class).stream()
                .filter(d -> d.mappedInt == i)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}

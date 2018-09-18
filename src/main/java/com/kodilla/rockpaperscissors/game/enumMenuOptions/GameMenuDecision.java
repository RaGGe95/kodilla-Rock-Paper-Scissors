package com.kodilla.rockpaperscissors.game.enumMenuOptions;

import java.util.EnumSet;

public enum GameMenuDecision {
    PLAY(1), CHANGE_SETTINGS(2), EXIT(3);

    private int mappedInt;

    GameMenuDecision(int mappedInt) {
        this.mappedInt = mappedInt;
    }

    public static GameMenuDecision of(int i){
        return EnumSet.allOf(GameMenuDecision.class).stream()
                .filter(d -> d.mappedInt == i)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

}

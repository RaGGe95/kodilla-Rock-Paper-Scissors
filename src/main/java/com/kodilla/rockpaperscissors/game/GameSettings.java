package com.kodilla.rockpaperscissors.game;


import com.kodilla.rockpaperscissors.game.enumMenuOptions.SettingsDecision;

import static com.kodilla.rockpaperscissors.game.GameUtilities.*;
import static com.kodilla.rockpaperscissors.language.GameMessenger.*;

public class GameSettings {
    private static boolean enableHint = true;
    private static int pointsRequiredToWin = 3;
    private static final int MAX_VALUE_OF_POINTS_REQUIRED_FOR_VICTORY = 9;
    private static final int MIN_VALUE_OF_POINTS_REQUIRED_FOR_VICTORY = 1;

    private GameSettings() {}


    static void printSettings(){
        printMessageWithPrefix("1.",SETTINGS_HINT_MSG);
        if (enableHint) {
            printlnMessage(SETTINGS_HINT_ON_MSG);
        } else {
            printlnMessage(SETTINGS_HINT_OFF_MSG);
        }
        printMessageWithPrefix("2.", SETTINGS_POINTS_MSG); System.out.println(getPointsRequiredToWin());
        printlnMessageWithPrefix("3.", SETTINGS_LANGUAGE_MSG);
    }


    static void changeSettings() {
        do {
            final SettingsDecision settingsDecision = SettingsDecision.of(getValidIntDecision(1, 4));

            switch (settingsDecision) {
                case HINTS:
                    toggleHint();
                    break;
                case POINTS_REQUIRED_TO_WIN:
                    printlnMessage(CHANGE_SETTINGS_SET_POINTS_MSG);
                    printMessage(ENTER_CHOICE_MSG);
                    setPointsRequiredToWin(getValidIntDecision(MIN_VALUE_OF_POINTS_REQUIRED_FOR_VICTORY, MAX_VALUE_OF_POINTS_REQUIRED_FOR_VICTORY));
                    break;
                case LANGUAGE:
                    changeLanguage();
                    break;
                case BACK_TO_MENU:
                    clearConsole();
                    return;
            }
            clearConsole();
            printChangeSettingsMenu();
        } while (true);
    }

    static void printChangeSettingsMenu() {
        printlnMessage(CHANGE_SETTINGS_MSG);
        printSettings();
        printlnMessageWithPrefix("4.", CHANGE_SETTINGS_BACK_TO_MENU_MSG);
        printMessage(ENTER_CHOICE_MSG);
    }

    private static void toggleHint() {
        enableHint = !enableHint;
    }

    private static void changeLanguage() {
        switch (getGameLanguage()) {
            case PL:
                setGameLanguage(Language.ENG);
                break;
            case ENG:
                setGameLanguage(Language.PL);
                break;
        }
    }


    static boolean isEnableHint() {
        return enableHint;
    }


    static int getPointsRequiredToWin() {
        return pointsRequiredToWin;
    }

    static void setPointsRequiredToWin(int points) {
        pointsRequiredToWin = points;
    }

    public static int getMaxValueOfPointsRequiredForVictory() {
        return MAX_VALUE_OF_POINTS_REQUIRED_FOR_VICTORY;
    }

    public static int getMinValueOfPointsRequiredForVictory() {
        return MIN_VALUE_OF_POINTS_REQUIRED_FOR_VICTORY;
    }


}

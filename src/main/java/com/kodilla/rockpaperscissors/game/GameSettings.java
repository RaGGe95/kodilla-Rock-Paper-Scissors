package com.kodilla.rockpaperscissors.game;


import static com.kodilla.rockpaperscissors.game.GameUtilities.*;
import static com.kodilla.rockpaperscissors.language.GameMessenger.*;

public class GameSettings {

    // settings options
    /*
    PYTANIE
    czy te 4 pola powinny być static?
    W programie będzie istniał tylko jeden obiekt typu GameSettings.

    Czy jedynym sposobem na to aby korzystać z jakiejś funkcji w innej klasie z tego samego pakietu,
    bez konieczności tworzenia obiektu klasy której funkcje chcemy wykorzystać.
    jest zadeklarowanie tej funkcji jako static????

    Czy da się utworzyć publiczny obiekt w jednej klasie a później wykozystywać ten obiekt w innych??
     */
    private boolean isGameWon = false;
    private boolean enableHint = true;
    private int pointsRequiredToWin = 3;
    private static final int maxValueOfPointsRequiredForVictory = 9;

    public GameSettings() {}

    public boolean isEnableHint() {
        return enableHint;
    }

    public void setEnableHint(boolean enableHint) {
        this.enableHint = enableHint;
    }

    public int getPointsRequiredToWin() {
        return pointsRequiredToWin;
    }

    public void setPointsRequiredToWin(int pointsRequiredToWin) {
        this.pointsRequiredToWin = pointsRequiredToWin;
    }

    public static int getMaxValueOfPointsRequiredForVictory() {
        return maxValueOfPointsRequiredForVictory;
    }

    public void showSettings(){
        System.out.print("1. " + msgSettingsHints());
        if (enableHint) {
            System.out.println(msgSettingsHintsON());
        } else {
            System.out.println(msgSettingsHintsOFF());
        }

        System.out.println("2. " + msgSettingsPoints() + pointsRequiredToWin);
        System.out.println("3. " + msgSettingsLanguage() + getLanguage());
    }


    public void changeSettings() {
        int decision;
        do {
            System.out.println(msgChangeSettings());
            showSettings();
            System.out.println("4. " + msgChangeSettingsBackToMenu());
            System.out.print(msgEnterChoice());

            decision = getValidIntDecision(1, 4);

            switch (decision) {
                case 1: // hints option
                    setEnableHint(!enableHint);
                    break;
                case 2: // points required for win option
                    System.out.println(msgChangeSettingsSetPoints());
                    setPointsRequiredToWin(getValidIntDecision(1, maxValueOfPointsRequiredForVictory));
                    break;
                case 3: // language option
                    if(getLanguage() == Language.PL){
                        setGameMessenger(Language.ENG);
                    } else {
                        setGameMessenger(Language.PL);
                    }
                    break;
                case 4: // back to menu
                    break;
            }
            clearConsole();
        } while (decision != 4);
    }
}

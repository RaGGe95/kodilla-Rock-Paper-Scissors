package com.kodilla.rockpaperscissors.game;


import static com.kodilla.rockpaperscissors.game.GameUtilities.clearConsole;
import static com.kodilla.rockpaperscissors.game.GameUtilities.getValidIntDecision;
import static com.kodilla.rockpaperscissors.language.GameMessenger.Language;
import static com.kodilla.rockpaperscissors.language.GameMessenger.getLanguage;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgChangeSettings;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgChangeSettingsBackToMenu;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgChangeSettingsSetPoints;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgEnterChoice;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgSettingsHint;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgSettingsHintOFF;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgSettingsHintON;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgSettingsLanguage;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgSettingsPoints;
import static com.kodilla.rockpaperscissors.language.GameMessenger.setGameMessenger;

public class GameSettings {

    // settings options
    /*
    PYTANIE
    czy te 3 pola powinny być static?
    W programie będzie istniał tylko jeden obiekt typu GameSettings. (w jaki sposób zabronić tworzenia więcej niż jednego obiektu?)

    Czy jedynym sposobem na to aby korzystać z jakiejś funkcji w innej klasie z tego samego pakietu,
    bez konieczności tworzenia obiektu klasy której funkcje chcemy wykorzystać.
    jest zadeklarowanie tej funkcji jako static????

    Czy da się utworzyć publiczny obiekt w jednej klasie a później wykozystywać ten obiekt w innych??
     */

    private boolean enableHint = true;
    private int pointsRequiredToWin = 3;
    private static final int maxValueOfPointsRequiredForVictory = 9;


    public GameSettings() {
    }


    public void showSettings() {
        System.out.print("1. " + msgSettingsHint());
        if (enableHint) {
            System.out.println(msgSettingsHintON());
        } else {
            System.out.println(msgSettingsHintOFF());
        }

        System.out.println("2. " + msgSettingsPoints() + pointsRequiredToWin);
        System.out.println("3. " + msgSettingsLanguage() + getLanguage());
    }


    public void changeSettings() {
        do {
            System.out.println(msgChangeSettings());
            showSettings();
            System.out.println("4. " + msgChangeSettingsBackToMenu());
            System.out.print(msgEnterChoice());

            final SettingsDecision settingsDecision = SettingsDecision.of(getValidIntDecision(1, 4));

            switch (settingsDecision) {
                case HINTS:
                    setEnableHint(!enableHint);
                    break;
                case POINTS_REQUIRED_TO_WIN:
                    System.out.println(msgChangeSettingsSetPoints());
                    setPointsRequiredToWin(getValidIntDecision(1, maxValueOfPointsRequiredForVictory));
                    break;
                case LANGUAGE:
                    if (getLanguage() == Language.PL) {
                        setGameMessenger(Language.ENG);
                    } else {
                        setGameMessenger(Language.PL);
                    }
                    break;
                case BACK:
                    return;
            }
            clearConsole();
        } while (true);
    }


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


}

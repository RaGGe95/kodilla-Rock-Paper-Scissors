package com.kodilla.rockpaperscissors.language;

/*
Klasa GameMessenger dostarcza komunikaty dla pozostałych klas.
Istnieje jeden obiekt typu GameMessenger.
Wszystkie funkcje są stayczne.
 */

import static com.kodilla.rockpaperscissors.game.GameSettings.getMaxValueOfPointsRequiredForVictory;

public class GameMessenger {

    public static void setGameMessenger(Language language){
        gameMessenger = new GameMessenger(language);
    }





    /*
    PYTANIE
    jak to się dzieje że ta linijka się wykonuje ? klasa jest przepisem na stworzenie obiektu,
    a ja tutaj tworze obiekt wewnątrz przepisu na ten obiekt

    Ten obiekt zostaje utworzony przed pierwszym wywołniem metody pokazującej komunikat.
    czy ten obiekt zostaje utworzony w momencie wywołania którejkolwiek ze statycznych metod poraz pierwszy?
    */
    private static GameMessenger gameMessenger = new GameMessenger(GameMessenger.Language.PL);

    public enum Language{
        PL,
        ENG
    }

    private static Language language;

    private static String introMsg;

    private static String settingsHintsMsg;
    private static String settingsHintsONMsg;
    private static String settingsHintsOFFMsg;
    private static String settingsPointsMsg;
    private static String settingsLanguageMsg;

    private static String menuFirstOptionMsg;
    private static String menuSecondOptionMsg;
    private static String menuExitGameMsg;
    private static String enterChoiceMsg;

    private static String getValidIntDecisionMsg;

    private static String changeSettingsMsg;
    private static String changeSettingsBackToMenuMsg;
    private static String changeSettingsSetPointsMsg;



    private GameMessenger(Language language){
        this.language = language;
        switch (language) {
            case PL:
               introMsg = "\nWitaj w grze Kamien, Papier, Nozyce. Aby zwyciezyc musisz pokonac komputer wymagana ilosc razy.\nUstawienia:";

               settingsHintsMsg = "(ON/OFF) Podpowiedzi: "; settingsHintsONMsg = "WLACZONE"; settingsHintsOFFMsg = "WYLACZONE";
               settingsPointsMsg = "(1-" + getMaxValueOfPointsRequiredForVictory() + ") Liczba potrzebnych punktow do zwyciestwa: ";
               settingsLanguageMsg = "(PL/ENG) Obecnie uzywany jezyk: ";

               menuFirstOptionMsg = "GRAJ";
               menuSecondOptionMsg = "ZMIEN USTAWIENIA";
               menuExitGameMsg = "ZAKONCZ GRE";
               enterChoiceMsg = "$ Wprowadz wybor: ";

               getValidIntDecisionMsg = "Niepoprawny wybor. Sprobuj ponownie.\n$ Wprowadz wybor: ";

               changeSettingsMsg = "WYBIERZ OPCJE, ABY DOKONAC ZMIAN USTAWIEN:"; changeSettingsBackToMenuMsg = "Powrot do MENU";
               changeSettingsSetPointsMsg ="Podaj ilosc punktow potrzebnych do zwyciestwa (zakres 1-" + getMaxValueOfPointsRequiredForVictory() + ") : ";

               break;

           case ENG:
               introMsg = "\nWelcome in game Rock-Paper-Scissors. In order to win you have to defeat computer expected numbers of times.\nSettings:";

               settingsHintsMsg = "(ON/OFF) Hints: "; settingsHintsONMsg = "ENABLE"; settingsHintsOFFMsg = "DISABLE";
               settingsPointsMsg = "(1-" + getMaxValueOfPointsRequiredForVictory() + ") Quantity of points required for victory: ";
               settingsLanguageMsg = "(PL/ENG) Current language: ";

               menuFirstOptionMsg = "PLAY";
               menuSecondOptionMsg = "CHANGE SETTINGS";
               menuExitGameMsg = "END GAME";
               enterChoiceMsg = "$ Enter choice: ";

               getValidIntDecisionMsg = "Invalid option. Try again.\n$ Enter choice: ";

               changeSettingsMsg = "CHOSE OPTION TO CHANGE SETTINGS:"; changeSettingsBackToMenuMsg = "Back to MENU";
               changeSettingsSetPointsMsg ="Enter amount of points required for victory (range 1-" + getMaxValueOfPointsRequiredForVictory() + ") : ";
               break;
       }
    }

    public static Language getLanguage() {
        return language;
    }

    public static String msgIntro() {
        return introMsg;
    }

    public static String msgSettingsHints() {
        return settingsHintsMsg;
    }

    public static String msgSettingsHintsON() {
        return settingsHintsONMsg;
    }

    public static String msgSettingsHintsOFF() {
        return settingsHintsOFFMsg;
    }

    public static String msgSettingsPoints() {
        return settingsPointsMsg;
    }

    public static String msgSettingsLanguage() {
        return settingsLanguageMsg;
    }

    public static String msgMenuFirstOption() {
        return menuFirstOptionMsg;
    }

    public static String msgMenuSecondOption() {
        return menuSecondOptionMsg;
    }

    public static String msgExitGame() {
        return menuExitGameMsg;
    }

    public static String msgEnterChoice() {
        return enterChoiceMsg;
    }

    public static String msgGetValidIntDecision() {
        return getValidIntDecisionMsg;
    }

    public static String msgChangeSettings() {
        return changeSettingsMsg;
    }

    public static String msgChangeSettingsBackToMenu() {
        return changeSettingsBackToMenuMsg;
    }

    public static String msgChangeSettingsSetPoints() {
        return changeSettingsSetPointsMsg;
    }
}

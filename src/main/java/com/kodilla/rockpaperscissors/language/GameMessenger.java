package com.kodilla.rockpaperscissors.language;


public class GameMessenger {
    public enum Language{
        PL,
        ENG

    }

    Language language;

    private String introMsg;

    private String settingsHints;
    private String settingsHintsON;
    private String settingsHintsOFF;
    private String settingsPointsStatment;
    private String settingsLanguage;

    private String menuFirstOption;
    private String menuSecondOption;
    private String menuExit;
    private String menuChoice;

    private String getValidIntDecisionStatment;

    private String changeSettingsCurrentSettings;
    private String changeSettingsBackToMenu;
    private String changeSettingsSetPoints;




    public GameMessenger(Language language){
        this.language = language;
        switch (language) {
            case PL:
               introMsg = "\nWitaj w grze Kamien, Papier, Nozyce. Aby zwyciezyc musisz pokonac komputer wymagana ilosc razy.\nUstawienia:";

               settingsHints = "Podpowiedzi: "; settingsHintsON = "WLACZONE"; settingsHintsOFF = "WYLACZONE";
               settingsPointsStatment = "Liczba potrzebnych punktow do zwyciestwa: ";
               settingsLanguage = "Obecnie uzywany jezyk: ";

               menuFirstOption = "GRAJ";
               menuSecondOption = "ZMIEN USTAWIENIA";
               menuExit = "ZAKONCZ GRE";
               menuChoice = "$ Wybor: ";

               getValidIntDecisionStatment = "Niepoprawny wybor. Sprobuj ponownie.\n$ Wybor: ";

               changeSettingsCurrentSettings = "AKTUALNE USTAWIENIA:"; changeSettingsBackToMenu = "Powrot do MENU";
               changeSettingsSetPoints ="Podaj ilosc punktow potrzebnych do zwyciestwa (zakres 1-99) : ";

               break;

           case ENG:
               introMsg = "\nWelcome in game Rock-Paper-Scissors. In order to win you have to defeat computer expected numbers of times.\nSettings:";

               settingsHints = "Hints: "; settingsHintsON = "ENABLE"; settingsHintsOFF = "DISABLE";
               settingsPointsStatment = "Quantity of points required for victory: ";
               settingsLanguage = "Current language: ";

               menuFirstOption = "PLAY";
               menuSecondOption = "CHANGE SETTINGS";
               menuExit = "END GAME";
               menuChoice = "$ Option: ";

               getValidIntDecisionStatment = "Invalid option. Try again.\n$ Option: ";

               changeSettingsCurrentSettings = "CURRENT SETTINGS:"; changeSettingsBackToMenu = "Back to MENU";
               changeSettingsSetPoints ="Enter amount of points required for victory (range 1-99) : ";
               break;
       }
    }

    public Language getLanguage() {
        return language;
    }

    public String getIntroMsg() {
        return introMsg;
    }

    public String getSettingsHints() {
        return settingsHints;
    }

    public String getSettingsHintsON() {
        return settingsHintsON;
    }

    public String getSettingsHintsOFF() {
        return settingsHintsOFF;
    }

    public String getSettingsPointsStatment() {
        return settingsPointsStatment;
    }

    public String getSettingsLanguage() {
        return settingsLanguage;
    }

    public String getMenuFirstOption() {
        return menuFirstOption;
    }

    public String getMenuSecondOption() {
        return menuSecondOption;
    }

    public String getMenuExit() {
        return menuExit;
    }

    public String getMenuChoice() {
        return menuChoice;
    }

    public String getGetValidIntDecisionStatment() {
        return getValidIntDecisionStatment;
    }

    public String getChangeSettingsCurrentSettings() {
        return changeSettingsCurrentSettings;
    }

    public String getChangeSettingsBackToMenu() {
        return changeSettingsBackToMenu;
    }

    public String getChangeSettingsSetPoints() {
        return changeSettingsSetPoints;
    }
}

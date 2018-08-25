package com.kodilla.rockpaperscissors.language;

/*
Klasa GameMessenger dostarcza komunikaty dla pozostałych klas.
Istnieje jeden obiekt typu GameMessenger.
Wszystkie funkcje są stayczne.
 */

import static com.kodilla.rockpaperscissors.game.GameSettings.getMaxValueOfPointsRequiredForVictory;

public class GameMessenger {

    public enum Language{
        PL,
        ENG
    }

    private static Language language;

    private static String introMsg;

    private static String settingsHintMsg;
    private static String settingsHintONMsg;
    private static String settingsHintOFFMsg;
    private static String settingsPointsMsg;
    private static String settingsLanguageMsg;

    private static String menuFirstOptionMsg;
    private static String menuSecondOptionMsg;
    private static String menuExitGameMsg;
    private static String enterChoiceMsg;

    private static String getValidDecisionMsg;

    private static String changeSettingsMsg;
    private static String changeSettingsBackToMenuMsg;
    private static String changeSettingsSetPointsMsg;

    private static String showScoresResultMsg;
    private static String showPlayerMsg;
    private static String showComputerMsg;

    private static String yourTurnMsg;
    private static String rockMsg;
    private static String paperMsg;
    private static String scissorsMsg;

    private static String playGameHintMsg;

    private static String lastTurnDetailsMsg;

    private static String askToPlayAgainMsg;

    private static String gameResultInfoPlayerCheerMsg;
    private static String gameResultInfoComputerCheerMsg;
    private static String gameResultInfoMsg;


    private GameMessenger(Language language){
        this.language = language;
        switch (language) {
            case PL:
               introMsg = "\nWitaj w grze Kamien, Papier, Nozyce. Aby zwyciezyc musisz pokonac komputer wymagana ilosc razy.\nUstawienia:";

               settingsHintMsg = "(ON/OFF) Podpowiedzi: "; settingsHintONMsg = "WLACZONE"; settingsHintOFFMsg = "WYLACZONE";
               settingsPointsMsg = "(1-" + getMaxValueOfPointsRequiredForVictory() + ") Liczba potrzebnych punktow do zwyciestwa: ";
               settingsLanguageMsg = "(PL/ENG) Obecnie uzywany jezyk: ";

               menuFirstOptionMsg = "GRAJ";
               menuSecondOptionMsg = "ZMIEN USTAWIENIA";
               menuExitGameMsg = "ZAKONCZ GRE";
               enterChoiceMsg = "$ Wprowadz wybor: ";

               getValidDecisionMsg = "Niepoprawny wybor. Sprobuj ponownie.\n$ Wprowadz wybor: ";

               changeSettingsMsg = "WYBIERZ OPCJE, ABY DOKONAC ZMIAN USTAWIEN:"; changeSettingsBackToMenuMsg = "Powrot do MENU";
               changeSettingsSetPointsMsg ="Podaj ilosc punktow potrzebnych do zwyciestwa (zakres 1-" + getMaxValueOfPointsRequiredForVictory() + ") : ";

               showScoresResultMsg = "Wynik: ";
               showPlayerMsg = "(GRACZ) ";
               showComputerMsg = " (KOMPUTER)";

               yourTurnMsg = "TWOJ RUCH: ";
               rockMsg = "KAMIEN";
               paperMsg = "PAPIER";
               scissorsMsg = "NOZYCZKI";

               playGameHintMsg = "*PODPOWIEDZ* Komputer wybral: ";

               lastTurnDetailsMsg = "Rezultat poprzednij rundy: ";

               askToPlayAgainMsg = "Czy chcesz zagrac ponownie? Wpisz: (Y/y) - Zagraj ponownie, lub (N/n) - Powrot do MENU";

               gameResultInfoPlayerCheerMsg = "BRAWO ZWYCIEZYLES!!!";
               gameResultInfoComputerCheerMsg = "PONIOSLES PORAZKE...";
               gameResultInfoMsg = "Gra zakonczona, ";

               break;

           case ENG:
               introMsg = "\nWelcome in game Rock-Paper-Scissors. In order to win you have to defeat computer expected numbers of times.\nSettings:";

               settingsHintMsg = "(ON/OFF) Hints: "; settingsHintONMsg = "ENABLE"; settingsHintOFFMsg = "DISABLE";
               settingsPointsMsg = "(1-" + getMaxValueOfPointsRequiredForVictory() + ") Quantity of points required for victory: ";
               settingsLanguageMsg = "(PL/ENG) Current language: ";

               menuFirstOptionMsg = "PLAY";
               menuSecondOptionMsg = "CHANGE SETTINGS";
               menuExitGameMsg = "END GAME";
               enterChoiceMsg = "$ Enter choice: ";

               getValidDecisionMsg = "Invalid option. Try again.\n$ Enter choice: ";

               changeSettingsMsg = "CHOOSE OPTION TO CHANGE SETTINGS:"; changeSettingsBackToMenuMsg = "Back to MENU";
               changeSettingsSetPointsMsg ="Enter amount of points required for victory (range 1-" + getMaxValueOfPointsRequiredForVictory() + ") : ";

               showScoresResultMsg = "Scores: ";
               showPlayerMsg = "(PLAYER) ";
               showComputerMsg = " (COMPUTER)";

               yourTurnMsg = "YOUR TURN: ";
               rockMsg = "ROCK";
               paperMsg = "PAPER";
               scissorsMsg = "SCISSORS";

               playGameHintMsg = "*HINT* Computer chose: ";

               lastTurnDetailsMsg = "Last turn result: ";

               askToPlayAgainMsg = "Do you want to play again? Enter: (Y/y) - Play Again, or (N/n) - Back to MENU";

               gameResultInfoPlayerCheerMsg = "EXCELLENT, YOU HAVE WON!!!";
               gameResultInfoComputerCheerMsg = "YOU HAVE BEEN DEFEATED...";
               gameResultInfoMsg = "Game ended, ";
               break;
       }
    }




    /*
PYTANIE
jak to się dzieje że 149 linijka się wykonuje ? klasa jest przepisem na stworzenie obiektu,
a ja tutaj tworze obiekt wewnątrz przepisu na ten obiekt

Ten obiekt zostaje utworzony przed pierwszym wywołniem metody pokazującej komunikat?
*/
    private static GameMessenger gameMessenger = new GameMessenger(GameMessenger.Language.PL);

    public static void setGameMessenger(Language language){
        gameMessenger = new GameMessenger(language);
    }






    public static Language getLanguage() {
        return language;
    }

    public static String msgIntro() {
        return introMsg;
    }

    public static String msgSettingsHint() {
        return settingsHintMsg;
    }

    public static String msgSettingsHintON() {
        return settingsHintONMsg;
    }

    public static String msgSettingsHintOFF() {
        return settingsHintOFFMsg;
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

    public static String msgGetValidDecision() {
        return getValidDecisionMsg;
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

    public static String msgRock() {
        return rockMsg;
    }

    public static String msgPaper() {
        return paperMsg;
    }

    public static String msgScissors() {
        return scissorsMsg;
    }

    public static String msgPlayGameHint() {
        return playGameHintMsg;
    }

    public static String msgYourTurn() {
        return yourTurnMsg;
    }

    public static String msgShowScoresResult() {
        return showScoresResultMsg;
    }

    public static String msgShowPlayer() {
        return showPlayerMsg;
    }

    public static String msgShowComputer() {
        return showComputerMsg;
    }

    public static String msgLastTurnDetails() {
        return lastTurnDetailsMsg;
    }

    public static String msgAskToPlayAgain() {
        return askToPlayAgainMsg;
    }

    public static String msgGameResultInfoPlayerCheer() {
        return gameResultInfoPlayerCheerMsg;
    }

    public static String msgGameResultInfoComputerCheer() {
        return gameResultInfoComputerCheerMsg;
    }

    public static String msgGameResultInfo() {
        return gameResultInfoMsg;
    }
}

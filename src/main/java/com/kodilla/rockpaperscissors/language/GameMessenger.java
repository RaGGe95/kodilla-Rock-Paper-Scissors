package com.kodilla.rockpaperscissors.language;


import java.util.HashMap;
import java.util.Map;

import static com.kodilla.rockpaperscissors.game.GameSettings.*;

public class GameMessenger {
    private static final Map<String, String> PL_LANGUAGE_MAP = new HashMap<>();
    private static final Map<String, String> ENG_LANGUAGE_MAP = new HashMap<>();
    private static Map<String, String> LANGUAGE_MAP = new HashMap<>();
    private static Language gameLanguage = Language.ENG;

    private GameMessenger() {}

    public enum Language{
        PL,
        ENG
    }

    static {
        setGameLanguage(gameLanguage);
    }

    public static void printMessage(String key) {
        System.out.print(LANGUAGE_MAP.get(key));
    }
    public static void printlnMessage(String key) {
        System.out.println(LANGUAGE_MAP.get(key));
    }

    public static void printMessageWithPrefix(String prefix, String key) {
        System.out.print(prefix + " " + LANGUAGE_MAP.get(key));
    }

    public static void printlnMessageWithPrefix(String prefix, String key) {
        System.out.println(prefix + " " + LANGUAGE_MAP.get(key));
    }

    public static void setGameLanguage(Language lang){
        switch (lang) {
            case ENG:
                LANGUAGE_MAP = ENG_LANGUAGE_MAP;
                break;

            case PL:
                LANGUAGE_MAP = PL_LANGUAGE_MAP;
                break;
        }
        gameLanguage = lang;
    }

    public static Language getGameLanguage(){
        return gameLanguage;
    }




    public final static String INTRO_MSG = "INTRO_MSG";

    public final static String SETTINGS_HINT_MSG = "SETTINGS_HINT_MSG";
    public final static String SETTINGS_HINT_ON_MSG = "SETTINGS_HINT_ON_MSG";
    public final static String SETTINGS_HINT_OFF_MSG = "SETTINGS_HINT_OFF_MSG";
    public final static String SETTINGS_POINTS_MSG = "SETTINGS_POINTS_MSG";
    public final static String SETTINGS_LANGUAGE_MSG = "SETTINGS_LANGUAGE_MSG";

    public final static String MENU_MSG = "MENU_MSG";
    public final static String MENU_FIRST_OPTION_MSG = "MENU_FIRST_OPTION_MSG";
    public final static String MENU_SECOND_OPTION_MSG = "MENU_SECOND_OPTION_MSG";
    public final static String MENU_EXIT_GAME_MSG = "MENU_EXIT_GAME_MSG";
    public final static String ENTER_CHOICE_MSG = "ENTER_CHOICE_MSG";

    public final static String WRONG_DECISION_MSG = "WRONG_DECISION_MSG";

    public final static String CHANGE_SETTINGS_MSG = "CHANGE_SETTINGS_MSG";
    public final static String CHANGE_SETTINGS_BACK_TO_MENU_MSG = "CHANGE_SETTINGS_BACK_TO_MENU_MSG";
    public final static String CHANGE_SETTINGS_SET_POINTS_MSG = "CHANGE_SETTINGS_SET_POINTS_MSG";

    public final static String SHOW_SCORES_RESULT_MSG = "SHOW_SCORES_RESULT_MSG";
    public final static String SHOW_PLAYER_MSG = "SHOW_PLAYER_MSG";
    public final static String SHOW_COMPUTER_MSG = "SHOW_COMPUTER_MSG";

    public final static String YOUR_TURN_MSG = "YOUR_TURN_MSG";
    public final static String ROCK_MSG = "ROCK_MSG";
    public final static String PAPER_MSG = "PAPER_MSG";
    public final static String SCISSORS_MSG = "SCISSORS_MSG";

    public final static String PLAY_GAME_HINT_MSG = "PLAY_GAME_HINT_MSG";

    public final static String LAST_TURN_DETAILS_MSG = "LAST_TURN_DETAILS_MSG";

    public final static String ASK_TO_PLAY_AGAIN_MSG = "ASK_TO_PLAY_AGAIN_MSG";

    public final static String GAME_RESULT_INFO_PLAYER_CHEER_MSG = "GAME_RESULT_INFO_PLAYER_CHEER_MSG";
    public final static String GAME_RESULT_INFO_COMPUTER_CHEER_MSG = "GAME_RESULT_INFO_COMPUTER_CHEER_MSG";

    static {
        PL_LANGUAGE_MAP.put(INTRO_MSG, "Witaj w grze Kamień, Papier, Nożyce. Aby zwycieżyć musisz pokonać komputer wymaganą ilość razy.");
        PL_LANGUAGE_MAP.put(SETTINGS_HINT_MSG, "(ON/OFF) Podpowiedzi: ");

        PL_LANGUAGE_MAP.put(SETTINGS_HINT_ON_MSG, "WŁĄCZONE");
        PL_LANGUAGE_MAP.put(SETTINGS_HINT_OFF_MSG, "WYŁĄCZONE");
        PL_LANGUAGE_MAP.put(SETTINGS_POINTS_MSG, "(" + getMinValueOfPointsRequiredForVictory() + "-" + getMaxValueOfPointsRequiredForVictory()
                + ") Liczba potrzebnych punktów do zwycięstwa: ");
        PL_LANGUAGE_MAP.put(SETTINGS_LANGUAGE_MSG, "Komunikaty dostępne w językach: (PL/ENG)");

        PL_LANGUAGE_MAP.put(MENU_MSG, "MENU");
        PL_LANGUAGE_MAP.put(MENU_FIRST_OPTION_MSG, "GRAJ");
        PL_LANGUAGE_MAP.put(MENU_SECOND_OPTION_MSG, "ZMIEN USTAWIENIA");
        PL_LANGUAGE_MAP.put(MENU_EXIT_GAME_MSG, "ZAKOŃCZ GRE");

        PL_LANGUAGE_MAP.put(ENTER_CHOICE_MSG, "$ Wprowadź wybór: ");

        PL_LANGUAGE_MAP.put(WRONG_DECISION_MSG, "Niepoprawny wybór. Sprobuj ponownie.");

        PL_LANGUAGE_MAP.put(CHANGE_SETTINGS_MSG, "WYBIERZ OPCJE, ABY DOKONAĆ ZMIANY USTAWIEŃ:");
        PL_LANGUAGE_MAP.put(CHANGE_SETTINGS_BACK_TO_MENU_MSG, "Powrót do menu");
        PL_LANGUAGE_MAP.put(CHANGE_SETTINGS_SET_POINTS_MSG, "Podaj ilość punktów potrzebnych do zwycięstwa (zakres "
                + getMinValueOfPointsRequiredForVictory() + "-" + getMaxValueOfPointsRequiredForVictory() + ")");

        PL_LANGUAGE_MAP.put(SHOW_SCORES_RESULT_MSG, "Wynik: ");
        PL_LANGUAGE_MAP.put(SHOW_PLAYER_MSG, "(GRACZ) ");
        PL_LANGUAGE_MAP.put(SHOW_COMPUTER_MSG, " (KOMPUTER)");

        PL_LANGUAGE_MAP.put(YOUR_TURN_MSG, "Twój ruch: ");
        PL_LANGUAGE_MAP.put(ROCK_MSG, "KAMIEŃ");
        PL_LANGUAGE_MAP.put(PAPER_MSG, "PAPIER");
        PL_LANGUAGE_MAP.put(SCISSORS_MSG, "NOŻYCE");

        PL_LANGUAGE_MAP.put(PLAY_GAME_HINT_MSG, "*PODPOWIEDŹ* Komputer wybrał: ");
        PL_LANGUAGE_MAP.put(LAST_TURN_DETAILS_MSG, "Rezultat poprzednij rundy: ");
        PL_LANGUAGE_MAP.put(ASK_TO_PLAY_AGAIN_MSG, "Czy chcesz zagrać ponownie? Wprowadź: (Y/y) - aby Zagrać ponownie, lub (N/n) - aby wrócić do menu");

        PL_LANGUAGE_MAP.put(GAME_RESULT_INFO_PLAYER_CHEER_MSG, "GRATULACJĘ, ZWYCIĘŻYŁEŚ!!!");
        PL_LANGUAGE_MAP.put(GAME_RESULT_INFO_COMPUTER_CHEER_MSG, "PONIOSŁEŚ PORAŻKE...");
    }

    static {
        ENG_LANGUAGE_MAP.put(INTRO_MSG, "Welcome in game Rock-Paper-Scissors. In order to win you have to defeat computer expected numbers of times.");
        ENG_LANGUAGE_MAP.put(SETTINGS_HINT_MSG, "(ON/OFF) Hints: ");

        ENG_LANGUAGE_MAP.put(SETTINGS_HINT_ON_MSG, "ENABLE");
        ENG_LANGUAGE_MAP.put(SETTINGS_HINT_OFF_MSG, "DISABLE");
        ENG_LANGUAGE_MAP.put(SETTINGS_POINTS_MSG, "(" + getMinValueOfPointsRequiredForVictory() + "-" + getMaxValueOfPointsRequiredForVictory()
                + ") Quantity of points required for victory: ");
        ENG_LANGUAGE_MAP.put(SETTINGS_LANGUAGE_MSG, "Messages enable in languages: (PL/ENG)");

        ENG_LANGUAGE_MAP.put(MENU_MSG, "MENU");
        ENG_LANGUAGE_MAP.put(MENU_FIRST_OPTION_MSG, "PLAY");
        ENG_LANGUAGE_MAP.put(MENU_SECOND_OPTION_MSG, "CHANGE SETTINGS");
        ENG_LANGUAGE_MAP.put(MENU_EXIT_GAME_MSG, "END GAME");

        ENG_LANGUAGE_MAP.put(ENTER_CHOICE_MSG, "$ Enter choice: ");

        ENG_LANGUAGE_MAP.put(WRONG_DECISION_MSG, "Invalid option. Try again.");

        ENG_LANGUAGE_MAP.put(CHANGE_SETTINGS_MSG, "CHOOSE OPTION TO CHANGE SETTINGS:");
        ENG_LANGUAGE_MAP.put(CHANGE_SETTINGS_BACK_TO_MENU_MSG, "Back to menu");
        ENG_LANGUAGE_MAP.put(CHANGE_SETTINGS_SET_POINTS_MSG, "Enter amount of points required for victory (range "
                + getMinValueOfPointsRequiredForVictory() + "-" + getMaxValueOfPointsRequiredForVictory() + ")");

        ENG_LANGUAGE_MAP.put(SHOW_SCORES_RESULT_MSG, "Scores: ");
        ENG_LANGUAGE_MAP.put(SHOW_PLAYER_MSG, "(PLAYER) ");
        ENG_LANGUAGE_MAP.put(SHOW_COMPUTER_MSG, " (COMPUTER)");

        ENG_LANGUAGE_MAP.put(YOUR_TURN_MSG, "Your turn: ");
        ENG_LANGUAGE_MAP.put(ROCK_MSG, "ROCK");
        ENG_LANGUAGE_MAP.put(PAPER_MSG, "PAPER");
        ENG_LANGUAGE_MAP.put(SCISSORS_MSG, "SCISSORS");

        ENG_LANGUAGE_MAP.put(PLAY_GAME_HINT_MSG, "*HINT* Computer chose: ");
        ENG_LANGUAGE_MAP.put(LAST_TURN_DETAILS_MSG, "Last turn result: " );
        ENG_LANGUAGE_MAP.put(ASK_TO_PLAY_AGAIN_MSG, "Do you want to play again? Enter: (Y/y) - Play again, or (N/n) - Back to menu");

        ENG_LANGUAGE_MAP.put(GAME_RESULT_INFO_PLAYER_CHEER_MSG, "CONGRATULATION, YOU HAVE WON!!!");
        ENG_LANGUAGE_MAP.put(GAME_RESULT_INFO_COMPUTER_CHEER_MSG, "YOU HAVE BEEN DEFEATED...");
    }

}

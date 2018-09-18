package com.kodilla.rockpaperscissors.game;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;


public class GameUtilities {

    private static final Scanner scanner = new Scanner(System.in);
    private GameUtilities() {}


    public static int getValidIntDecision(int bottomRange, int topRange){

        boolean isDecisionValid = false;
        int decision = 0;
        do {
            try {
                decision = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e){
            }

            if (decision >= bottomRange && decision <= topRange) {
                isDecisionValid = true;
            } else {
                printlnMessage(WRONG_DECISION_MSG);
                printMessage(ENTER_CHOICE_MSG);
            }

        } while ( ! isDecisionValid);

        return decision;
    }


    public static boolean askToPlayAgain() {
        boolean isDecisionValid = false;
        String decision;

        printlnMessage(ASK_TO_PLAY_AGAIN_MSG);
        printMessage(ENTER_CHOICE_MSG);
        do {
            decision = scanner.nextLine();
            decision = decision.toLowerCase();

            if (decision.equals("y") || decision.equals("n")) {
                isDecisionValid = true;
            } else {
                printlnMessage(WRONG_DECISION_MSG);
                printMessage(ENTER_CHOICE_MSG);
            }

        } while( ! isDecisionValid);

        clearConsole();
        if (decision.equals("y")){
            return true;
        } else {
            return false;
        }
    }

    public static void clearConsole() { for (int i = 0; i < 50; ++i) System.out.println();}


    public static void closeScanner() {
        scanner.close();
    }
}

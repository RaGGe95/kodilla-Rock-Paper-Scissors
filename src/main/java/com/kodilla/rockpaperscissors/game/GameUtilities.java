package com.kodilla.rockpaperscissors.game;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;


class GameUtilities {

    private static final Scanner scanner = new Scanner(System.in);
    private GameUtilities() {}


    static int getValidIntDecision(int bottomRange, int topRange){

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


    static boolean askToPlayAgain() {
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
        return decision.equals("y");
    }

    static void clearConsole() { for (int i = 0; i < 50; ++i) System.out.println();}


    static void closeScanner() {
        scanner.close();
    }
}

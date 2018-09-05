package com.kodilla.rockpaperscissors.game;

/*
Klasa GameUtilities dostarcza funkcje użytkowe dla klasy GameSettings or głównej klasy Game.
nie można tworzyć obiektów typu GameUtilities
 */

import java.util.Scanner;

import static com.kodilla.rockpaperscissors.language.GameMessenger.msgAskToPlayAgain;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgEnterChoice;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgGetValidDecision;


public class GameUtilities {
    /*
    PYTANIE
    kiedy linijka 19 w tym progamie się wykona?
     */
    private static final Scanner scanner = new Scanner(System.in);
    private GameUtilities() {}



    public static int getValidIntDecision(int bottomRange, int topRange){

        boolean isDecisionValid = false;
        int decision;
        do {
            decision = scanner.nextInt();

            if (decision >= bottomRange && decision <= topRange) {
                isDecisionValid = true;
            } else {
                System.out.print(msgGetValidDecision());
            }

        } while ( ! isDecisionValid);

        return decision;
    }

    public static boolean askToPlayAgain() {
        boolean isDecisionValid = false;
        String decision;
        scanner.nextLine(); // zjadam pozostawiony znak \n przez metode nextInt()

        System.out.println(msgAskToPlayAgain());
        System.out.println(msgEnterChoice());
        do {
            decision = scanner.nextLine();
            decision = decision.toLowerCase();

            if (decision.equals("y") || decision.equals("n")) {
                isDecisionValid = true;
            } else {
                System.out.print(msgGetValidDecision());
            }

        } while( ! isDecisionValid);

        clearConsole();
        if (decision.equals("y")){

            return true;
        } else {
            return false;
        }
    }

    public static void clearConsole() { for (int i = 0; i < 20; ++i) System.out.println();}


    //temporary solution
    public static void closeScanner() {
        scanner.close();
    }
}

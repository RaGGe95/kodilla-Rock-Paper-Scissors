package com.kodilla.rockpaperscissors.game;

/*
Klasa GameUtilities dostarcza funkcje użytkowe dla klasy GameSettings or głównej klasy Game.
nie można tworzyć obiektów typu GameUtilities
 */

import java.util.Scanner;

import static com.kodilla.rockpaperscissors.language.GameMessenger.msgGetValidIntDecision;


public class GameUtilities {
    private static final Scanner scanner = new Scanner(System.in);

    private GameUtilities() {}

    public static int getValidIntDecision(int bottomRange, int topRange){

        boolean isDecisionValid = false;
        int decision = 0;
        do {
            decision = scanner.nextInt();

            if (decision >= bottomRange && decision <= topRange) {
                isDecisionValid = true;
            } else {
                System.out.print(msgGetValidIntDecision());
            }

        } while ( ! isDecisionValid);

        return decision;
    }

    public static void clearConsole() { for (int i = 0; i < 20; ++i) System.out.println();}

    //temporary solution
    public static void closeScanner() {
        scanner.close();
    }
}

package com.kodilla.rockpaperscissors.game;

import static com.kodilla.rockpaperscissors.game.GameUtilities.closeScanner;

public class ASCIIArt {
    private ASCIIArt() {}

    public static void printASCIIArt(GameLogic.Result winner) {
        switch (winner) {
            case COMPUTER:
                printSkull();
                break;

            case PLAYER:
                printHappyFace();
                break;
        }
    }

    public static void printASCIIArtGoodByeAndCloseScanner(){
        System.out.println("   _____  ____   ____  _____  ______     ________   _");
        System.out.println("  / ____|/ __ \\ / __ \\|  __ \\|  _ \\ \\   / /  ____| | |");
        System.out.println(" | |  __| |  | | |  | | |  | | |_) \\ \\_/ /| |__    | |");
        System.out.println(" | | |_ | |  | | |  | | |  | |  _ < \\   / |  __|   | |");
        System.out.println(" | |__| | |__| | |__| | |__| | |_) | | |  | |____  |_|");
        System.out.println("  \\_____|\\____/ \\____/|_____/|____/  |_|  |______| (_)");

        closeScanner();
    }

    private static void printSkull(){
        System.out.println("                                 .-\"\"\"\"\"-.");
        System.out.println("                                /          \\ ");
        System.out.println("                       .-.     |   _   _   |      .-.");
        System.out.println("                      (_. '._  |  |_\\ /_|  |   _.' ._)");
        System.out.println("                        '-._'-.(_    A    _).-'_.-'");
        System.out.println("                             '-._| _____ |_.-'");
        System.out.println("                            _.-'_\\`\"\"\"\"\"`/_'-._");
        System.out.println("                       .-.-'_.-'  `-----'   '-._'-.-.");
        System.out.println("                      (,_.'`                    `'._,)");
    }

    private static void printHappyFace(){
        System.out.println("             OOOOOOOOOOO");
        System.out.println("         OOOOOOOOOOOOOOOOOOO");
        System.out.println("      OOOOOO  OOOOOOOOO  OOOOOO");
        System.out.println("    OOOOOO      OOOOO      OOOOOO");
        System.out.println("  OOOOOOOO  #   OOOOO  #   OOOOOOOO");
        System.out.println(" OOOOOOOOOO    OOOOOOO    OOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println(" OOOO  OOOOOOOOOOOOOOOOOOOOOOO  OOOO");
        System.out.println("  OOOO   OOOOOOOOOOOOOOOOOOOO  OOOO");
        System.out.println("   OOOO   OOOOOOOOOOOOOOOOO   OOO");
        System.out.println("    OOOO     OOOOOOOOOOO   OOOO");
        System.out.println("       OOOOOO          OOOOOO");
        System.out.println("            OOOOOOOOOOOO");

    }
}

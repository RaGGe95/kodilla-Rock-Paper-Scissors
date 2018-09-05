package com.kodilla.rockpaperscissors.game;

import static com.kodilla.rockpaperscissors.language.GameMessenger.msgEnterChoice;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgPaper;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgRock;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgScissors;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgYourTurn;

public class PlayerMove {
    private static GameLogic.Move playerMove = GameLogic.Move.DEFAULT;

    private PlayerMove() {
    }

    public static GameLogic.Move showMovesAndGetValidPlayerMove() {
        System.out.println(msgYourTurn());
        System.out.println("1. " + msgRock());
        System.out.println("2. " + msgPaper());
        System.out.println("3. " + msgScissors());
        System.out.print(msgEnterChoice());
        return GameLogic.Move.values()[GameUtilities.getValidIntDecision(1, 3) - 1];
    }
}

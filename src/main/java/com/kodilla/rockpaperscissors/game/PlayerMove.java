package com.kodilla.rockpaperscissors.game;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;

public class PlayerMove {
    private static GameLogic.Move playerMove = GameLogic.Move.DEFAULT;
    private PlayerMove() {}

    public static GameLogic.Move showMovesAndGetValidPlayerMove(){
        System.out.println(msgYourTurn());
        System.out.println("1. " + msgRock());
        System.out.println("2. " + msgPaper());
        System.out.println("3. " + msgScissors());
        System.out.print(msgEnterChoice());

        int decision = GameUtilities.getValidIntDecision(1, 3);

        switch (decision){
            case 1: playerMove = GameLogic.Move.ROCK;
                break;
            case 2: playerMove = GameLogic.Move.PAPER;
                break;
            case 3: playerMove = GameLogic.Move.SCISSORS;
                break;
        }
        return playerMove;
    }
}

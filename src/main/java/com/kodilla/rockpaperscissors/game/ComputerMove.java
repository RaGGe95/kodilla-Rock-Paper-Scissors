package com.kodilla.rockpaperscissors.game;

import java.util.Random;

public class ComputerMove {
    private static GameLogic.Move computerMove = GameLogic.Move.DEFAULT;
    private ComputerMove() {}

    public static GameLogic.Move getComputerMove(){
        Random rand = new Random();

        int decision = rand.nextInt(3) + 1;
        switch (decision){
            case 1: computerMove = GameLogic.Move.ROCK;
            break;
            case 2: computerMove = GameLogic.Move.PAPER;
            break;
            case 3: computerMove = GameLogic.Move.SCISSORS;
            break;
        }

        return computerMove;
    }

}




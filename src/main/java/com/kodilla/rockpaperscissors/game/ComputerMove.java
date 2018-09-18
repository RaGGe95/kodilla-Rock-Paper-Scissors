package com.kodilla.rockpaperscissors.game;

import java.util.Random;

public class ComputerMove {
    private static Random rand = new Random();
    private ComputerMove() {}

    public static GameLogic.Move getComputerMove(){
        return GameLogic.Move.values()[rand.nextInt(3)];
    }

}




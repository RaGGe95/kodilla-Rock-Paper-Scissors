package com.kodilla.rockpaperscissors.game;

import java.util.Random;

class ComputerMove {
    private static Random rand = new Random();
    private ComputerMove() {}

    static GameLogic.Move getComputerMove(){
        return GameLogic.Move.values()[rand.nextInt(3)];
    }

}




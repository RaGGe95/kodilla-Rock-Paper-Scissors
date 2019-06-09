package com.kodilla.rockpaperscissors;

import com.kodilla.rockpaperscissors.game.Game;



public class RockPaperScissorsApplication {
    public static void main(String[] args) {
        Game rpsGame = Game.getInstance();
        rpsGame.run();
    }
}

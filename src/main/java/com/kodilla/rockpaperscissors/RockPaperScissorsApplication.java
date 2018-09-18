package com.kodilla.rockpaperscissors;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodilla.rockpaperscissors.game.Game;


@SpringBootApplication
public class RockPaperScissorsApplication {
    public static void main(String[] args) {
        Game rpsGame = Game.getInstance();
        rpsGame.run();
    }
}

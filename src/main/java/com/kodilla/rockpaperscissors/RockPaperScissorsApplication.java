package com.kodilla.rockpaperscissors;

import com.kodilla.rockpaperscissors.game.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RockPaperScissorsApplication {

    public static void main(String[] args) {
        Game rpsGame = new Game();
        rpsGame.play();
    }
}

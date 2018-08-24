package com.kodilla.rockpaperscissors;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodilla.rockpaperscissors.game.GameUtilities;
import com.kodilla.rockpaperscissors.game.Game;


@SpringBootApplication
public class RockPaperScissorsApplication {

    public static void main(String[] args) {
        Game RPSGame = new Game();
        int decision;

        do {
            RPSGame.showIntro();
            decision = RPSGame.showGameMenuAndGetValidDecision();
            RPSGame.executeMenuDecision(decision);
        } while (decision != 3);




        //temporary solution
        GameUtilities.closeScanner();
    }
}

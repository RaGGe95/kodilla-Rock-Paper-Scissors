package com.kodilla.rockpaperscissors;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodilla.rockpaperscissors.game.Game;


@SpringBootApplication
public class RockPaperScissorsApplication {

    public static void main(String[] args) {
        Game RPSGame = new Game();
        int decision = 0;

        do {
            RPSGame.showIntro();
            decision = RPSGame.showMenuAndGetValidDecision();
            RPSGame.executeMenuDecision(decision);
        } while (decision != 3);





        //temporary solution
        RPSGame.closeScanner();
    }
}

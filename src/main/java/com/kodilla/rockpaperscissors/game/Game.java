package com.kodilla.rockpaperscissors.game;

import com.kodilla.rockpaperscissors.game.enumMenuOptions.GameMenuDecision;

import static com.kodilla.rockpaperscissors.game.GameLogic.*;
import static com.kodilla.rockpaperscissors.game.ComputerMove.*;
import static com.kodilla.rockpaperscissors.game.PlayerMove.*;
import static com.kodilla.rockpaperscissors.game.GameUtilities.*;
import static com.kodilla.rockpaperscissors.game.ASCIIArt.*;
import static com.kodilla.rockpaperscissors.game.GameSettings.*;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;


public class Game {
    private static Game game = null;

    private int playerScore;
    private int computerScore;

    private GameLogic.Result turnWinner;
    private GameLogic.Move computerMove;
    private GameLogic.Move playerMove;

    private Game() {
        resetScores();
    }

    public static Game getInstance() {
        if (game == null) {
            synchronized (Game.class) {
                if (game == null) {
                    game = new Game();
                }
            }
        }
        return game;
    }


    public void run() {
        while(true) {
            printlnMessage(INTRO_MSG);
            printSettings();
            printGameMenu();
            executeGameMenuDecision();
        }
    }


    private void printGameMenu(){
        printlnMessage(MENU_MSG);
        printlnMessageWithPrefix("1.", MENU_FIRST_OPTION_MSG);
        printlnMessageWithPrefix("2.", MENU_SECOND_OPTION_MSG);
        printlnMessageWithPrefix("3.", MENU_EXIT_GAME_MSG);
        printMessage(ENTER_CHOICE_MSG);
    }

    private void executeGameMenuDecision(){
        final GameMenuDecision gameMenuDecision = GameMenuDecision.of(getValidIntDecision(1, 3));
        switch (gameMenuDecision) {
            case PLAY:
                clearConsole();
                gameLoop();
                break;
            case CHANGE_SETTINGS:
                clearConsole();
                printChangeSettingsMenu();
                changeSettings();
                break;
            case EXIT:
                printASCIIArtGoodByeAndCloseScanner();
                System.exit(0);
                break;
        }
    }


    private void gameLoop(){
        do {
            GameLogic.Result winner = playGame();
            printASCIIArt(winner);
            printCongratulationForWinner(winner);
            resetScores();
        } while (askToPlayAgain());
    }


    private GameLogic.Result playGame() {
        do {
            computerMove = getComputerMove();
            if (isEnableHint()) {
                printMessage(PLAY_GAME_HINT_MSG);
                computerMove.printlnMove();
            }
            printPlayerMoves();
            playerMove = getValidPlayerMove();
            turnWinner = getResult(new GameLogic.MovePair(playerMove, computerMove));
            givePointForTurnWinner();
            clearConsole();
            showScores();
            showLastTurnDetails();
        } while ( ! isGameWon());

        if (playerScore > computerScore) {
            return Result.PLAYER;
        } else {
            return Result.COMPUTER;
        }
    }

    private void givePointForTurnWinner() {
        switch (turnWinner) {
            case PLAYER:
                playerScore++;
                break;
            case COMPUTER:
                computerScore++;
                break;
            case TIE:
                break;
        }
    }

    private void showScores(){
        printMessage(SHOW_SCORES_RESULT_MSG);
        printMessage(SHOW_PLAYER_MSG);
        System.out.print(playerScore + ":" + computerScore);
        printlnMessage(SHOW_COMPUTER_MSG);
    }

    private void showLastTurnDetails(){
        printMessage(LAST_TURN_DETAILS_MSG);
        printMessage(SHOW_PLAYER_MSG);
        playerMove.printMove();
        System.out.print(':');
        computerMove.printMove();
        printlnMessage(SHOW_COMPUTER_MSG);
    }

    private boolean isGameWon() {
        return playerScore == getPointsRequiredToWin() || computerScore == getPointsRequiredToWin();
    }

    private void printCongratulationForWinner(GameLogic.Result winner){
        switch (winner) {
            case PLAYER:
                printlnMessage(GAME_RESULT_INFO_PLAYER_CHEER_MSG);
            break;
            case COMPUTER:
                printlnMessage(GAME_RESULT_INFO_COMPUTER_CHEER_MSG);
            break;
        }
    }

    private void resetScores(){
        playerScore = 0;
        computerScore = 0;

        turnWinner = Result.DEFAULT;
        computerMove = Move.DEFAULT;
        playerMove = Move.DEFAULT;
    }
}

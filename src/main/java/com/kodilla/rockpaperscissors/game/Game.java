package com.kodilla.rockpaperscissors.game;

import com.kodilla.rockpaperscissors.language.GameMessenger;

import static com.kodilla.rockpaperscissors.game.ASCIIArt.showASCIIArtGoodByeAndCloseScanner;
import static com.kodilla.rockpaperscissors.game.ASCIIArt.showASCIIArtWinner;
import static com.kodilla.rockpaperscissors.game.ComputerMove.getComputerMove;
import static com.kodilla.rockpaperscissors.game.GameLogic.Move;
import static com.kodilla.rockpaperscissors.game.GameLogic.Result;
import static com.kodilla.rockpaperscissors.game.GameLogic.getResult;
import static com.kodilla.rockpaperscissors.game.GameUtilities.askToPlayAgain;
import static com.kodilla.rockpaperscissors.game.GameUtilities.clearConsole;
import static com.kodilla.rockpaperscissors.game.GameUtilities.getValidIntDecision;
import static com.kodilla.rockpaperscissors.game.PlayerMove.showMovesAndGetValidPlayerMove;
import static com.kodilla.rockpaperscissors.language.GameMessenger.INTRO_MSG;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgExitGame;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgGameResultInfo;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgGameResultInfoComputerCheer;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgGameResultInfoPlayerCheer;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgIntro;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgLastTurnDetails;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgMenuFirstOption;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgMenuSecondOption;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgPlayGameHint;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgShowComputer;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgShowPlayer;
import static com.kodilla.rockpaperscissors.language.GameMessenger.msgShowScoresResult;


public class Game {
    private GameSettings gameSettings = new GameSettings();

    private static int playerScore = 0;
    private static int computerScore = 0;

    private GameLogic.Result turnResult = Result.DEFAULT;
    private GameLogic.Move computerMove = Move.DEFAULT;
    private GameLogic.Move playerMove = Move.DEFAULT;


    public Game() {
    }

    public void showIntro() {
        GameMessenger.printMessage(INTRO_MSG);
        gameSettings.showSettings();
    }

    public int showGameMenuAndGetValidDecision() {
        showIntro();
        System.out.println("\nMENU");
        System.out.println("1. " + msgMenuFirstOption());
        System.out.println("2. " + msgMenuSecondOption());
        System.out.println("3. " + msgExitGame());
        System.out.print(GameMessenger.enterChoiceMsg);
        return getValidIntDecision(1, 3);
    }

    public void play() {
        while (true) {
            int decision = showGameMenuAndGetValidDecision();
            clearConsole();
            switch (decision) {
                case 1:
                    gameLoop();
                    break;
                case 2:
                    gameSettings.changeSettings();
                    break;
                case 3:
                    showASCIIArtGoodByeAndCloseScanner();
                    System.exit(0);
                    break;
            }
        }
    }


    private void gameLoop() {

        do {
            GameLogic.Result winner = playGame();
            showASCIIArtWinner(winner);
            showGameResultInformationAndResetScore(winner);
        } while (askToPlayAgain());
    }

    private GameLogic.Result playGame() {
        do {

            computerMove = getComputerMove();
            if (gameSettings.isEnableHint()) {
                System.out.println(msgPlayGameHint() + computerMove.toString());
            }
            playerMove = showMovesAndGetValidPlayerMove();

            turnResult = getResult(new GameLogic.MovePair(playerMove, computerMove));

            switch (turnResult) {
                case PLAYER:
                    playerScore++;
                    break;
                case COMPUTER:
                    computerScore++;
                    break;
                case TIE:
                    break;
            }
            clearConsole();
            showScores();
            if (turnResult != Result.DEFAULT) {
                showLastTurnDetails();
            }
        } while (!isGameWon());

        if (playerScore > computerScore) {
            return Result.PLAYER;
        } else {
            return Result.COMPUTER;
        }
    }

    private void showScores() {
        System.out.println(msgShowScoresResult() + msgShowPlayer() + playerScore + ":" + computerScore + msgShowComputer());
    }

    private void showLastTurnDetails() {
        System.out.println(msgLastTurnDetails() + msgShowPlayer() + playerMove + ":" + computerMove + msgShowComputer());
    }

    private boolean isGameWon() {
        return playerScore == gameSettings.getPointsRequiredToWin() || computerScore == gameSettings.getPointsRequiredToWin();
    }

    private void showGameResultInformationAndResetScore(GameLogic.Result winner) {
        showLastTurnDetails();
        switch (winner) {
            case PLAYER:
                System.out.println(msgGameResultInfoPlayerCheer());
                System.out.print(msgGameResultInfo());
                showScores();

                break;
            case COMPUTER:
                System.out.println(msgGameResultInfoComputerCheer());
                System.out.print(msgGameResultInfo());
                showScores();
                break;
        }
        resetScores();
    }

    private void resetScores() {
        turnResult = Result.DEFAULT;
        playerScore = 0;
        computerScore = 0;
    }


}

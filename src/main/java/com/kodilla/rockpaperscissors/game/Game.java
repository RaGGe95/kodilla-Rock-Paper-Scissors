package com.kodilla.rockpaperscissors.game;

import static com.kodilla.rockpaperscissors.game.GameLogic.*;
import static com.kodilla.rockpaperscissors.game.ComputerMove.*;
import static com.kodilla.rockpaperscissors.game.PlayerMove.*;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;
import static com.kodilla.rockpaperscissors.game.GameUtilities.*;
import static com.kodilla.rockpaperscissors.game.ASCIIArt.*;


public class Game {
    private GameSettings gameSettings = new GameSettings();

    private static int playerScore = 0;
    private static int computerScore = 0;

    private GameLogic.Result turnResult = Result.DEFAULT;
    private GameLogic.Move computerMove = Move.DEFAULT;
    private GameLogic.Move playerMove = Move.DEFAULT;



    public Game() {}

    public void showIntro(){
        System.out.println(msgIntro());
        gameSettings.showSettings();
    }

    public int showGameMenuAndGetValidDecision(){
        System.out.println("\nMENU");
        System.out.println("1. " + msgMenuFirstOption());
        System.out.println("2. " + msgMenuSecondOption());
        System.out.println("3. " + msgExitGame());
        System.out.print(msgEnterChoice());
        int decision = getValidIntDecision(1,3 );
        return decision;
    }

    public void executeMenuDecision(int decision){
        clearConsole();
        switch (decision) {
            case 1: gameLoop();
            break;
            case 2: gameSettings.changeSettings();
            break;
            case 3:
                showASCIIArtGoodByeAndCloseScanner();
                System.exit(0);
            break;
        }
    }




    private void gameLoop(){

        do {
            GameLogic.Result winner = playGame();
            showASCIIArtWinner(winner);
            showGameResultInformationAndResetScore(winner);
        } while (askToPlayAgain());
    }

    private GameLogic.Result playGame() {
        do {
            showScores();
            if (turnResult != Result.DEFAULT){
                showLastTurnDetails();
            }

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
        } while ( ! isGameWon());

        if (playerScore == gameSettings.getPointsRequiredToWin()){
            return Result.PLAYER;
        }
        else {
            return Result.COMPUTER;
        }
    }

    private void showScores(){
        System.out.println(msgShowScoresResult() + msgShowPlayer() + playerScore + ":" + computerScore + msgShowComputer());
    }

    private void showLastTurnDetails(){
        System.out.println(msgLastTurnDetails() + msgShowPlayer() + playerMove + ":" + computerMove + msgShowComputer());
    }

    private boolean isGameWon() {
        return playerScore == gameSettings.getPointsRequiredToWin() || computerScore == gameSettings.getPointsRequiredToWin();
    }

    private void showGameResultInformationAndResetScore(GameLogic.Result winner){
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

    private void resetScores(){
        turnResult = Result.DEFAULT;
        playerScore = 0;
        computerScore = 0;
    }


}

package com.kodilla.rockpaperscissors.game;


import static com.kodilla.rockpaperscissors.game.GameUtilities.*;
import static com.kodilla.rockpaperscissors.language.GameMessenger.*;



public class Game {
    private GameSettings gameSettings = new GameSettings();

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
            case 1: playGame();
            break;
            case 2: gameSettings.changeSettings();
            break;
            case 3: System.exit(0);
            break;
        }
    }

    private void playGame(){
        System.out.println("function playGame()");
        System.exit(0);
    }

}

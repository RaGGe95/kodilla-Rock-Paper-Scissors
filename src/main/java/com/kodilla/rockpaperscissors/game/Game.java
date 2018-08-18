package com.kodilla.rockpaperscissors.game;

import com.kodilla.rockpaperscissors.language.GameMessenger;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private GameMessenger gameMessenger = new GameMessenger(GameMessenger.Language.PL);

    // settings
    private boolean isGameWon;
    private boolean enableHint;
    private int pointsRequiredToWin;



    public Game() {
        this.isGameWon = false;

        this.enableHint = true;
        this.pointsRequiredToWin = 3;
    }


    public boolean isEnableHint() {
        return enableHint;
    }

    public void setEnableHint(boolean enableHint) {
        this.enableHint = enableHint;
    }

    public int getPointsRequiredToWin() {
        return pointsRequiredToWin;
    }

    public void setPointsRequiredToWin(int pointsRequiredToWin) {
        this.pointsRequiredToWin = pointsRequiredToWin;
    }

    private void clearConsole() { for (int i = 0; i < 20; ++i) System.out.println();}
    
    public void showIntro(){
        System.out.println(gameMessenger.getIntroMsg());
        showSettings();
    }

    private void showSettings(){
        System.out.print("1. " + gameMessenger.getSettingsHints());
        if (enableHint) {
            System.out.println(gameMessenger.getSettingsHintsON());
        } else {
            System.out.println(gameMessenger.getSettingsHintsOFF());
        }

        System.out.println("2. " + gameMessenger.getSettingsPointsStatment() + pointsRequiredToWin);
        System.out.println("3. " + gameMessenger.getSettingsLanguage() + gameMessenger.getLanguage());
    }

    public int showMenuAndGetValidDecision(){
        System.out.println("\nMENU");
        System.out.println("1. " + gameMessenger.getMenuFirstOption());
        System.out.println("2. " + gameMessenger.getMenuSecondOption());
        System.out.println("3. " + gameMessenger.getMenuExit());
        System.out.print(gameMessenger.getMenuChoice());
        int decision = getValidIntDecision(1,3 );
        return decision;
    }

    private int getValidIntDecision(int bottomRange, int topRange){

        boolean isDecisionValid = false;
        int decision = 0;
        do {
            decision = scanner.nextInt();

            if (decision >= bottomRange && decision <= topRange) {
                isDecisionValid = true;
            } else {
                System.out.print(gameMessenger.getGetValidIntDecisionStatment());
            }

        } while ( ! isDecisionValid);

        return decision;
    }


    public void executeMenuDecision(int decision){
        switch (decision) {
            case 1: playGame();
            break;
            case 2: changeSettings();
            break;
            case 3: System.exit(0);
            break;
        }
    }

    private void playGame(){
        System.out.println("function playGame()");
        System.exit(0);
    }

    private void changeSettings() {
        int decision = 0;
        do {
            System.out.println(gameMessenger.getChangeSettingsCurrentSettings());
            showSettings();
            System.out.println("4. " + gameMessenger.getChangeSettingsBackToMenu());
            System.out.print(gameMessenger.getMenuChoice());

            decision = getValidIntDecision(1, 4);

            switch (decision) {
                case 1:
                    setEnableHint(!isEnableHint());
                    break;
                case 2:
                    System.out.println(gameMessenger.getChangeSettingsSetPoints());
                    setPointsRequiredToWin(getValidIntDecision(1, 99));
                    break;
                case 3:
                    if (gameMessenger.getLanguage() == GameMessenger.Language.PL) {
                        gameMessenger = new GameMessenger(GameMessenger.Language.ENG);
                    } else {
                        gameMessenger = new GameMessenger(GameMessenger.Language.PL);
                    }
                    break;
                case 4:
                    break;
            }
            clearConsole();
        } while (decision != 4);
    }

    //temporary solution
    public void closeScanner() {
        this.scanner.close();
    }
}

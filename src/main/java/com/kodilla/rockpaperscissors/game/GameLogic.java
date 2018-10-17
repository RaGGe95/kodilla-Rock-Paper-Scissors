package com.kodilla.rockpaperscissors.game;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;

class GameLogic {
    private static final Map<MovePair, Result> gameMap = new HashMap<>();

    private GameLogic() {}

    static {
        gameMap.put(new MovePair(Move.ROCK, Move.ROCK), Result.TIE);
        gameMap.put(new MovePair(Move.ROCK, Move.SCISSORS), Result.PLAYER);
        gameMap.put(new MovePair(Move.ROCK, Move.PAPER), Result.COMPUTER);

        gameMap.put(new MovePair(Move.SCISSORS, Move.SCISSORS), Result.TIE);
        gameMap.put(new MovePair(Move.SCISSORS, Move.PAPER), Result.PLAYER);
        gameMap.put(new MovePair(Move.SCISSORS, Move.ROCK), Result.COMPUTER);

        gameMap.put(new MovePair(Move.PAPER, Move.PAPER), Result.TIE);
        gameMap.put(new MovePair(Move.PAPER, Move.ROCK), Result.PLAYER);
        gameMap.put(new MovePair(Move.PAPER, Move.SCISSORS), Result.COMPUTER);
    }


    static Result getResult(MovePair movePair) {
        return gameMap.get(movePair);
    }


    public enum Move {
        ROCK, PAPER, SCISSORS, DEFAULT;

        public void printMove() {
            switch (this) {
                case ROCK:
                    printMessage(ROCK_MSG);
                    break;
                case PAPER:
                    printMessage(PAPER_MSG);
                    break;
                case SCISSORS:
                    printMessage(SCISSORS_MSG);
                    break;
            }
        }

        public void printlnMove() {
            switch (this) {
                case ROCK:
                    printlnMessage(ROCK_MSG);
                    break;
                case PAPER:
                    printlnMessage(PAPER_MSG);
                    break;
                case SCISSORS:
                    printlnMessage(SCISSORS_MSG);
                    break;
            }
        }
    }

    public enum Result {
        TIE, PLAYER, COMPUTER, DEFAULT;
    }

        public static class MovePair {
            private final Move playerMove;
            private final Move computerMove;

            MovePair(Move playerMove, Move computerMove) {
                this.playerMove = playerMove;
                this.computerMove = computerMove;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                MovePair movePair = (MovePair) o;

                if (computerMove != movePair.computerMove) return false;
                return playerMove == movePair.playerMove;
            }

            @Override
            public int hashCode() {
                int result = computerMove.hashCode();
                result = 31 * result + playerMove.hashCode();
                return result;
            }
        }
}


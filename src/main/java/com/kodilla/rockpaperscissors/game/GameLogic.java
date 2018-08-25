package com.kodilla.rockpaperscissors.game;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.rockpaperscissors.language.GameMessenger.*;

public class GameLogic {
    private static final Map<MovePair, Result> gameMap = new HashMap<>();
    private GameLogic() {}
    static {
        gameMap.put( new MovePair(Move.ROCK,Move.ROCK), Result.TIE );
        gameMap.put( new MovePair(Move.ROCK,Move.SCISSORS), Result.PLAYER );
        gameMap.put( new MovePair(Move.ROCK,Move.PAPER), Result.COMPUTER );

        gameMap.put( new MovePair(Move.SCISSORS,Move.SCISSORS), Result.TIE );
        gameMap.put( new MovePair(Move.SCISSORS,Move.PAPER), Result.PLAYER );
        gameMap.put( new MovePair(Move.SCISSORS,Move.ROCK), Result.COMPUTER );

        gameMap.put( new MovePair(Move.PAPER,Move.PAPER), Result.TIE );
        gameMap.put( new MovePair(Move.PAPER,Move.ROCK), Result.PLAYER );
        gameMap.put( new MovePair(Move.PAPER,Move.SCISSORS), Result.COMPUTER );
    }


    public static Result getResult(MovePair movePair) {
        return gameMap.get(movePair);
    }







    public enum Move {
        ROCK, PAPER, SCISSORS, DEFAULT;

        @Override
        public String toString() {
            switch (this){
                case ROCK:
                    return msgRock();
                case PAPER:
                    return msgPaper();
                case SCISSORS:
                    return msgScissors();
            }
            return "";
        }
    }

    public enum Result {
        TIE, PLAYER, COMPUTER, DEFAULT;

        @Override
        public String toString() {
            switch (this){
                case PLAYER:
                    return msgShowPlayer();
                case COMPUTER:
                    return msgShowComputer();
            }
            return "";
        }
    }

    public static class MovePair {
        private final Move playerMove;
        private final Move computerMove;

        public MovePair(Move playerMove, Move computerMove) {
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

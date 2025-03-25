package com.kodilla.rps;

import java.util.Random;

public class Enemy {

    private final Random rand = new Random();
    private final double winProbability = 0.5;
    private final double loseOrTieProbability = 0.25;

    public Move getMove(Move playerMove) {
        double roll = rand.nextDouble();

        if (roll < loseOrTieProbability) {
            return playerMove; //tie
        } else if (roll < winProbability + (1 - winProbability - loseOrTieProbability)) {
            return losingMove(playerMove); //computer losing
        } else {
            return winningMove(playerMove); //computer winning
        }
    }

    private Move losingMove(Move playerMove) {
        if (playerMove == Move.ROCK) return Move.SCISSORS;
        if (playerMove == Move.SCISSORS) return Move.PAPER;
        return Move.ROCK;
    }

    private Move winningMove(Move playerMove) {
        if (playerMove == Move.ROCK) return Move.PAPER;
        if (playerMove == Move.PAPER) return Move.SCISSORS;
        return Move.ROCK;
    }
}

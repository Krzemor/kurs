package com.kodilla.rps;

import java.util.Random;

public class Enemy {

    private final Random rand = new Random();

    public Move getMove() {
        return Move.fromInt(rand.nextInt(3) + 1);
    }
}

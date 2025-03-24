package com.kodilla.rps;

public enum Move {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String name;

    Move(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public  static Move fromInt (int move) {
        if (move == 1) {
            return ROCK;
        } else if (move == 2) {
            return PAPER;
        } else if (move == 3) {
            return SCISSORS;
        } else {
            return null;
        }
    }
}

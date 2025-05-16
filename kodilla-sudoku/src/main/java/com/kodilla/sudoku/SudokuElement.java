package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {

    public static final int EMPTY = -1;
    private int value = EMPTY;
    private Set<Integer> possibleValues = new HashSet<>();

    public SudokuElement() {
        this.value = EMPTY;
        for (int i = 1; i <= 9; i++) {
            possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        if (value != EMPTY) {
            possibleValues.clear();
        }
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }

    public SudokuElement copy() {
        SudokuElement copy = new SudokuElement();
        if (this.value != EMPTY) {
            copy.setValue(this.value);
        } else {
            copy.possibleValues = new HashSet<>(this.possibleValues);
        }
        return copy;
    }


    @Override
    public String toString() {
        return (value == EMPTY) ? "." : String.valueOf(value);
    }
}

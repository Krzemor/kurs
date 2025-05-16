package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {
        this(true);
    }

    public SudokuRow(boolean init) {
        if (init) {
            for (int i = 0; i < 9; i++) {
                elements.add(new SudokuElement());
            }
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    public SudokuRow copy() {
        SudokuRow copy = new SudokuRow(false);
        for (SudokuElement element : this.getElements()) {
            copy.getElements().add(element.copy());
        }
        return copy;
    }
}

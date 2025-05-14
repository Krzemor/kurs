package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public SudokuElement get(int row, int col) {
        return rows.get(row).getElements().get(col);
    }

    public void set(int row, int col, int value) {
        get(row, col).setValue(value);
    }

    public boolean isFilled() {
        return rows.stream()
                .flatMap(r -> r.getElements().stream())
                .noneMatch(e -> e.getValue() == SudokuElement.EMPTY);
    }

    public SudokuBoard copy() {
        SudokuBoard copy = new SudokuBoard();
        for (int i = 0; i < 9; i++) {
            copy.rows.set(i, rows.get(i).copy());
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                sb.append("+-------+-------+-------+\n");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    sb.append("| ");
                }
                sb.append(get(row, col)).append(" ");
            }
            sb.append("|\n");
        }
        sb.append("+-------+-------+-------+");
        return sb.toString();
    }
}

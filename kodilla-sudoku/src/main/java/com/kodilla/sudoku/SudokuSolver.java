package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SudokuSolver {

    private Stack<BacktrackState> backtrackStates = new Stack<>();

    public boolean solveSudoku(SudokuBoard board) {
        while (true) {
            boolean progress = eliminate(board);

            if (board.isFilled()) {
                return true;
            }

            if (!progress) {
                boolean guessed = guess(board);
                if (!guessed) {
                    return false;
                }
            }
        }
    }

    private boolean eliminate(SudokuBoard board) {
        boolean changed = false;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuElement element = board.get(row, col);

                if (element.getValue() != SudokuElement.EMPTY) {
                    continue;
                }

                Set<Integer> toRemove = new HashSet<>();

                for (int i = 0; i < 9; i++) {
                    int rowVal = board.get(row, i).getValue();
                    int colVal = board.get(i, col).getValue();
                    int blockVal = board.get((row / 3) * 3 + i / 3, (col / 3) * 3 + i % 3).getValue();

                    if (rowVal != SudokuElement.EMPTY) toRemove.add(rowVal);
                    if (colVal != SudokuElement.EMPTY) toRemove.add(colVal);
                    if (blockVal != SudokuElement.EMPTY) toRemove.add(blockVal);
                }

                if (element.getPossibleValues().removeAll(toRemove)) {
                    changed = true;
                }

                if (element.getPossibleValues().isEmpty()) {
                    return backtrack(board);
                }

                if (element.getPossibleValues().size() == 1) {
                    int value = element.getPossibleValues().iterator().next();
                    element.setValue(value);
                    changed = true;
                }
            }
        }

        return changed;
    }

    private boolean guess(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuElement element = board.get(row, col);
                if (element.getValue() == SudokuElement.EMPTY && !element.getPossibleValues().isEmpty()) {
                    int guess = element.getPossibleValues().iterator().next();
                    SudokuBoard boardCopy = board.copy();
                    boardCopy.set(row, col, guess);
                    backtrackStates.push(new BacktrackState(boardCopy, row, col, guess));
                    board.set(row, col, guess);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(SudokuBoard board) {
        while (!backtrackStates.isEmpty()) {
            BacktrackState state = backtrackStates.pop();

            SudokuElement element = state.board.get(state.row, state.col);
            Set<Integer> remaining = new HashSet<>(element.getPossibleValues());
            remaining.remove(state.guessedValue);

            if (remaining.isEmpty()) {
                continue;
            }

            int newGuess = remaining.iterator().next();
            SudokuBoard newBoard = state.board.copy();
            newBoard.set(state.row, state.col, newGuess);
            backtrackStates.push(new BacktrackState(newBoard, state.row, state.col, newGuess));

            copyBoard(board, newBoard);
            return true;
        }
        return false;
    }

    private void copyBoard(SudokuBoard target, SudokuBoard source) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                SudokuElement src = source.get(row, col);
                SudokuElement dest = target.get(row, col);
                dest.setValue(src.getValue());
                dest.getPossibleValues().clear();
                dest.getPossibleValues().addAll(src.getPossibleValues());
            }
        }
    }
}

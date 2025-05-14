package com.kodilla.sudoku;

public class BacktrackState {

    public SudokuBoard board;
    public int row;
    public int col;
    public int guessedValue;

    public BacktrackState(SudokuBoard board, int row, int col, int value) {
        this.board = board.copy();
        this.row = row;
        this.col = col;
        this.guessedValue = value;
    }
}

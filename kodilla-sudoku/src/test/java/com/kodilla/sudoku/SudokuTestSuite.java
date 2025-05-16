package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuTestSuite {

    @Test
    public void testSudokuSolver() {
        //Given
        SudokuBoard board = new SudokuBoard();
        board.set(0, 0, 5);
        board.set(0, 1, 3);
        board.set(0, 4, 7);
        board.set(1, 0, 6);
        board.set(1, 3, 1);
        board.set(1, 4, 9);
        board.set(1, 5, 5);
        board.set(2, 1, 9);
        board.set(2, 2, 8);
        board.set(2, 7, 6);
        board.set(3, 0, 8);
        board.set(3, 4, 6);
        board.set(3, 8, 3);
        board.set(4, 0, 4);
        board.set(4, 3, 8);
        board.set(4, 5, 3);
        board.set(4, 8, 1);
        board.set(5, 0, 7);
        board.set(5, 4, 2);
        board.set(5, 8, 6);
        board.set(6, 1, 6);
        board.set(6, 6, 2);
        board.set(6, 7, 8);
        board.set(7, 3, 4);
        board.set(7, 4, 1);
        board.set(7, 5, 9);
        board.set(7, 8, 5);
        board.set(8, 4, 8);
        board.set(8, 7, 7);
        board.set(8, 8, 9);

        //When
        SudokuSolver solver = new SudokuSolver();
        boolean result = solver.solveSudoku(board);
        System.out.println(board);

        //Then
        assertTrue(result, "Sudoku solver should solve the puzzle successfully");
        assertTrue(board.isFilled(), "Board should be completely filled after solving");
    }
}

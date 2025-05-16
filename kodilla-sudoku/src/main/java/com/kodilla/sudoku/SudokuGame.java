package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    private Scanner scanner = new Scanner(System.in);

    public boolean resolveSudoku() {
        SudokuBoard board = new SudokuBoard();

        System.out.println("Welcome to the Sudoku Game!");
        System.out.println("Please enter the numbers in [column,row,value] format or type SUDOKU to solve the sudoku game.");
        System.out.println(board);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("SUDOKU")) {
                break;
            }

            try {
                String[] values = line.split(",");
                int col = Integer.parseInt(values[0]) - 1;
                int row = Integer.parseInt(values[1]) - 1;
                int value = Integer.parseInt(values[2]);

                if (value < 1 || value > 9 || row < 0 || col < 0 || row >= 9 || col >= 9) {
                    System.out.println("Wrong data, please try again.");
                    continue;
                }

                board.set(row, col, value);
                board.get(row, col).getPossibleValues().clear();
                System.out.println(board);
            } catch (Exception e) {
                System.out.println("Wrong format, please try again eg. 1,5,4.");
            }
        }

        SudokuSolver solver = new SudokuSolver();
        if (solver.solveSudoku(board)) {
            System.out.println("Sudoku solution: ");
            System.out.println(board);
        } else {
            System.out.println("Failed to solve sudoku");
        }

        System.out.println("Do you want to solve another sudoku? (y/n)");
        String answer = scanner.nextLine().trim().toUpperCase();
        return !answer.equals("Y");
    }
}

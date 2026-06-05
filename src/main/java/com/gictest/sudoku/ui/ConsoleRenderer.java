package com.gictest.sudoku.ui;

import com.gictest.sudoku.board.SudokuBoard;

public class ConsoleRenderer {
    public void render(SudokuBoard board) {
        System.out.println();
        System.out.println("    1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < 9; row++) {
            char rowName = (char) ('A' + row);
            System.out.print("  " + rowName + " ");
            for (int col = 0; col < 9; col++) {
                int value = board.getValue(row, col);
                if (value == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(
                            value + " "
                    );
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWelcome() {
        System.out.println("Welcome to Sudoku!");
        System.out.println();
    }

    public void printPrompt() {
        System.out.println("Enter command (e.g., A3 4, C5 clear, hint, check, quit):");
    }

    public void printMoveAccepted() {
        System.out.println("Move accepted.");
    }

    public void printInvalidMove(String reason) {
        System.out.println("Invalid move. " + reason);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printVictory() {
        System.out.println();
        System.out.println("You have successfully completed the Sudoku puzzle!");
        System.out.println();
    }
}

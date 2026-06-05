package com.gictest.sudoku.generator;

import com.gictest.sudoku.board.SudokuBoard;

import java.util.Random;

public class SudokuGenerator {
    private static final int PREFILLED_CELLS = 30;

    private final SudokuSolver solver = new SudokuSolver();
    private final Random random = new Random();
    private int[][] solution;

    public SudokuBoard generate() {
        int[][] fullBoard = new int[9][9];
        solver.solve(fullBoard);
        solution = copy(fullBoard);
        int cellsToRemove = 81 - PREFILLED_CELLS;

        while (cellsToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);

            if (fullBoard[row][col] != 0) {
                fullBoard[row][col] = 0;
                cellsToRemove--;
            }
        }

        SudokuBoard board = new SudokuBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = fullBoard[row][col];
                boolean fixed = value != 0;
                board.setCell(row, col, value, fixed);
            }
        }
        return board;
    }

    public int[][] getSolution() {
        return copy(solution);
    }

    private int[][] copy(int[][] source) {
        int[][] result = new int[9][9];
        for (int row = 0; row < 9; row++) {
            System.arraycopy(
                    source[row],
                    0,
                    result[row],
                    0,
                    9
            );
        }
        return result;
    }
}

package com.gictest.sudoku;

import com.gictest.sudoku.generator.SudokuSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuSolverIsValidTest {
    private final SudokuSolver solver = new SudokuSolver();

    @Test
    void shouldRejectNumberAlreadyInRow() {

        int[][] board = new int[9][9];

        board[0][0] = 5;

        boolean result =
                solver.isValid(board,0,4,5);

        assertFalse(result);
    }

    @Test
    void shouldRejectNumberAlreadyInColumn() {

        int[][] board = new int[9][9];

        board[0][0] = 7;

        boolean result =
                solver.isValid(board,4,0,7);

        assertFalse(result);
    }

    @Test
    void shouldRejectNumberAlreadyInSubgrid() {

        int[][] board = new int[9][9];

        board[0][0] = 9;

        boolean result =
                solver.isValid(board,1,1,9);

        assertFalse(result);
    }

    @Test
    void shouldAcceptValidNumber() {

        int[][] board = new int[9][9];

        board[0][0] = 5;
        board[1][1] = 6;

        boolean result =
                solver.isValid(board,0,1,7);

        assertTrue(result);
    }
}

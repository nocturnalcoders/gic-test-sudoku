package com.gictest.sudoku;

import com.gictest.sudoku.generator.SudokuSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuSolverSolveTest {
    private final SudokuSolver solver = new SudokuSolver();

    @Test
    void shouldSolveValidPuzzle() {

        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        boolean solved = solver.solve(board);

        assertTrue(solved);

        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                assertNotEquals(
                        0,
                        board[row][col]
                );
            }
        }
    }
}

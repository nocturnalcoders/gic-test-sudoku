package com.gictest.sudoku.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuSolver {

    public Boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    List<Integer> numbers = createShuffledNumbers();
                    for (int number : numbers) {
                        if (isValid(board, row, col, number)) {
                            board[row][col] = number;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(
            int[][] board,
            int row,
            int col,
            int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
            if (board[i][col] == number) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Integer> createShuffledNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}

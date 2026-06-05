package com.gictest.sudoku;

import com.gictest.sudoku.board.SudokuBoard;
import com.gictest.sudoku.hint.HintService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HintServiceTest {

    @Test
    void shouldRevealHint() {
        SudokuBoard board = new SudokuBoard();
        int[][] solution = new int[9][9];
        solution[0][0] = 7;
        HintService hintService = new HintService(solution);
        String result = hintService.revealHint(board);
        assertTrue(result.contains("Hint"));
    }

}

package com.gictest.sudoku;

import com.gictest.sudoku.board.SudokuBoard;
import com.gictest.sudoku.validation.SudokuValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SudokuValidatorTest {
    @Test
    void shouldDetectRowViolation() {

        SudokuBoard board = new SudokuBoard();

        board.setCell(0,0,5,true);
        board.setCell(0,1,5,false);

        SudokuValidator validator =
                new SudokuValidator();

        assertFalse(
                validator.validate(board).isValid()
        );
    }

    @Test
    void shouldDetectColumnViolation() {

        SudokuBoard board = new SudokuBoard();

        board.setCell(0,0,5,true);
        board.setCell(1,0,5,false);

        SudokuValidator validator =
                new SudokuValidator();

        assertFalse(
                validator.validate(board).isValid()
        );
    }

    @Test
    void shouldDetectSubgridViolation() {

        SudokuBoard board = new SudokuBoard();

        board.setCell(0,0,8,true);
        board.setCell(1,1,8,false);

        SudokuValidator validator =
                new SudokuValidator();

        assertFalse(
                validator.validate(board).isValid()
        );
    }


}

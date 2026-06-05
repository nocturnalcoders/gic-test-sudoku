package com.gictest.sudoku.validation;

import com.gictest.sudoku.board.SudokuBoard;

import java.util.HashSet;
import java.util.Set;


public class SudokuValidator {

    public ValidationResult validate(SudokuBoard board) {
        ValidationResult result = validateRows(board);

        if(!result.isValid()) {
            return result;
        }

        result = validateColumns(board);

        if(!result.isValid()) {
            return result;
        }

        return validateSubgrids(board);
    }

    private ValidationResult validateRows(SudokuBoard board) {

        for(int row=0; row<9; row++) {
            Set<Integer> seen = new HashSet<>();
            for(int col=0; col<9; col++) {
                int value = board.getValue(row,col);
                if(value == 0) {
                    continue;
                }
                if(!seen.add(value)) {
                    return new ValidationResult(
                            false,
                            "Number " + value + " already exists in Row "
                                    + (char)('A'+row) + "."
                    );
                }
            }
        }
        return new ValidationResult(true,"");
    }

    private ValidationResult validateColumns(SudokuBoard board) {

        for(int col=0; col<9; col++) {
            Set<Integer> seen = new HashSet<>();
            for(int row=0; row<9; row++) {
                int value = board.getValue(row,col);
                if(value==0) {
                    continue;
                }
                if(!seen.add(value)) {
                    return new ValidationResult(
                            false,
                            "Number " + value + " already exists in Column "
                                    + (col+1) + "."
                    );
                }
            }
        }
        return new ValidationResult(true,"");
    }

    private ValidationResult validateSubgrids(SudokuBoard board) {

        for(int boxRow=0; boxRow<9; boxRow+=3) {
            for(int boxCol=0; boxCol<9; boxCol+=3) {
                Set<Integer> seen = new HashSet<>();
                for(int row=0; row<3; row++) {
                    for(int col=0; col<3; col++) {
                        int value = board.getValue(
                                boxRow+row, boxCol+col);
                        if(value==0) {
                            continue;
                        }
                        if(!seen.add(value)) {
                            return new ValidationResult(
                                    false,
                                    "Number " + value + " already exists in the same 3×3 subgrid."
                            );
                        }
                    }
                }
            }
        }
        return new ValidationResult(
                true, "No rule violations detected."
        );
    }
}

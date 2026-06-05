package com.gictest.sudoku.hint;

import com.gictest.sudoku.board.SudokuBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
public class HintService {
    private int[][] solution;

    public String revealHint(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getValue(row, col) == 0) {
                    int value = solution[row][col];
                    board.updateValue(
                            row,
                            col,
                            value
                    );
                    char rowLabel = (char) ('A' + row);
                    return "Hint: Cell " + rowLabel + (col + 1) + " = " + value;
                }
            }
        }
        return "No hints available.";
    }
}

package com.gictest.sudoku.command;

import com.gictest.sudoku.board.SudokuBoard;
import com.gictest.sudoku.game.GameContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
public class PlaceNumberCommand implements Command{
    private final Integer row;
    private final Integer col;
    private final Integer value;

    public String execute(GameContext context) {
        SudokuBoard board = context.getBoard();
        if (board.isFixedCell(row, col)) {
            char rowLabel = (char) ('A' + row);
            return "Invalid move. " + rowLabel + (col + 1) + " is pre-filled.";
        }
        if (value < 1 || value > 9) {
            return "Invalid move. Number must be between 1 and 9.";
        }
        board.updateValue(row, col, value);
        return "Move accepted.";
    }

}

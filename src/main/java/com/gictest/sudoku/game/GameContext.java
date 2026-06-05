package com.gictest.sudoku.game;

import com.gictest.sudoku.board.SudokuBoard;
import com.gictest.sudoku.hint.HintService;
import com.gictest.sudoku.validation.SudokuValidator;
import lombok.Getter;

@Getter
public class GameContext {

    private final SudokuBoard board;
    private final HintService hintService;
    private final SudokuValidator validator;
    private boolean quitRequested;

    public GameContext(
            SudokuBoard board,
            HintService hintService,
            SudokuValidator validator
    ) {
        this.board = board;
        this.hintService = hintService;
        this.validator = validator;
    }

    public void requestQuit() {
        this.quitRequested = true;
    }
}
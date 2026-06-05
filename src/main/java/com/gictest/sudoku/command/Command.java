package com.gictest.sudoku.command;

import com.gictest.sudoku.game.GameContext;

public interface Command {
    String execute(GameContext context);
}

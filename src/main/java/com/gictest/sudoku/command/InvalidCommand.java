package com.gictest.sudoku.command;

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
public class InvalidCommand implements Command {

    private final String message;

    public String execute(GameContext context) {
        return message;
    }
}
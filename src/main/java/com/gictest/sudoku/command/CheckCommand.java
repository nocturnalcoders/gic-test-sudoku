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
public class CheckCommand implements Command {

    @Override
    public String execute(GameContext context) {
        return context
                .getValidator()
                .validate(context.getBoard())
                .getMessage();
    }

}
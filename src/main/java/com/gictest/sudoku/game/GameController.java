package com.gictest.sudoku.game;

import com.gictest.sudoku.board.SudokuBoard;
import com.gictest.sudoku.command.Command;
import com.gictest.sudoku.generator.SudokuGenerator;
import com.gictest.sudoku.hint.HintService;
import com.gictest.sudoku.parser.CommandParser;
import com.gictest.sudoku.ui.ConsoleRenderer;
import com.gictest.sudoku.validation.SudokuValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.BufferedReader;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GameController {

    private final CommandParser parser = new CommandParser();
    private final ConsoleRenderer renderer = new ConsoleRenderer();
    private final SudokuGenerator generator = new SudokuGenerator();

    private SudokuBoard board;
    private GameContext context;
    private HintService hintService;
    private SudokuValidator validator;


    public void start() {
        renderer.printWelcome();
        board = generator.generate();
        validator = new SudokuValidator();
        hintService = new HintService(generator.getSolution());
        context = new GameContext(
                board,
                hintService,
                validator
        );

        Scanner scanner = new Scanner(System.in);
        renderer.render(board);
        while (!context.isQuitRequested()) {
            renderer.printPrompt();
            String input = scanner.nextLine();
            Command command = parser.parse(input);
            String result = command.execute(context);
            renderer.printMessage(result);
            if (!context.isQuitRequested()) {
                renderer.render(board);
                checkWinCondition();
            }
        }
    }

    private void checkWinCondition() {
        if (!board.isComplete()) {
            return;
        }
        if (validator.validate(board).isValid()) {
            renderer.printVictory();
            context.isQuitRequested();
        }
    }
}

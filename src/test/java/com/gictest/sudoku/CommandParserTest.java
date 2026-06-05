package com.gictest.sudoku;

import com.gictest.sudoku.command.Command;
import com.gictest.sudoku.command.PlaceNumberCommand;
import com.gictest.sudoku.parser.CommandParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandParserTest {

    @Test
    void shouldParsePlaceCommand() {

        CommandParser parser = new CommandParser();
        Command command = parser.parse("A3 4");
        assertTrue(command instanceof PlaceNumberCommand);
    }
}

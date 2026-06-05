package com.gictest.sudoku.parser;

import com.gictest.sudoku.command.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Accessors(chain = true)
public class CommandParser {

    public Command parse(String input) {
        if (input == null || input.isBlank()) {
            return new InvalidCommand("Invalid command.");
        }
        input = input.trim();
        if ("hint".equalsIgnoreCase(input)) {
            return new HintCommand();
        }
        if ("check".equalsIgnoreCase(input)) {
            return new CheckCommand();
        }
        if ("quit".equalsIgnoreCase(input)) {
            return new QuitCommand();
        }
        String[] parts = input.split("\\s+");
        if (parts.length != 2) {
            return new InvalidCommand("Invalid command.");
        }
        String cell = parts[0].toUpperCase();
        if (!cell.matches("[A-I][1-9]")) {

            return new InvalidCommand(
                    "Invalid cell reference."
            );
        }
        int row = cell.charAt(0) - 'A';
        int col = Character.getNumericValue(
                cell.charAt(1)) - 1;
        if ("clear".equalsIgnoreCase(parts[1])) {
            return new ClearCellCommand(row, col);
        }

        try {
            int value = Integer.parseInt(parts[1]);
            return new PlaceNumberCommand(row, col, value);
        } catch (NumberFormatException ex) {
            return new InvalidCommand("Invalid number.");
        }
    }
}
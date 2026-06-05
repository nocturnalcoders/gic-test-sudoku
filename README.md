# Sudoku Command Line Application

## Overview

This application provides a command-line Sudoku game.

Features:
- Sudoku puzzle generation
- User move validation
- Hint support
- Grid validation
- Puzzle completion detection
- Command-line interaction

## Design

The application is designed using object-oriented principles and follows SOLID principles where appropriate.

Main components:

- GameController
    - Controls the game lifecycle and user interaction.

- SudokuBoard
    - Stores puzzle state and fixed cells.

- SudokuGenerator
    - Generates playable Sudoku puzzles and solutions.

- SudokuSolver
    - Uses backtracking to solve Sudoku puzzles.

- SudokuValidator
    - Validates rows, columns and 3x3 subgrids.

- Command Pattern
    - PlaceCommand
    - ClearCommand
    - HintCommand
    - CheckCommand
    - QuitCommand

This separation keeps responsibilities focused and improves maintainability and testability.

## Assumptions

- A Sudoku puzzle contains exactly 30 pre-filled cells.
- Empty cells are represented by '_'.
- User input is case-insensitive.
- Validation is executed only when the user enters the 'check' command.
- A hint reveals one correct value from the solution.
- Pre-filled cells cannot be modified.


## SOLID Considerations

- Single Responsibility Principle
    - Solver, Validator, Generator and Renderer each have a dedicated responsibility.

- Open/Closed Principle
    - Commands are implemented using the Command pattern and can be extended without changing existing command implementations.

- Liskov Substitution Principle
    - All commands implement the Command interface and can be used interchangeably.

- Interface Segregation Principle
    - Small focused interfaces are used.

- Dependency Inversion Principle
    - Partially applied. Further improvement could be achieved by introducing interfaces for rendering, generation and validation services.

## Environment

Requirements:

- Java 17+
- Maven 3.9+

Operating Systems:

- Windows
- Linux
- macOS

## Build

mvn clean compile

## Run

mvn exec:java -Dexec.mainClass="com.gictest.sudoku.Application"
or
java -jar sudoku.jar

## Run Tests

mvn test

## Commands

Place a number:

A3 4

Clear a cell:

C5 clear

Request a hint:

hint

Validate current board:

check

Quit:

quit

## Project Structure

src
- board
- command
- generator
- game
- hint
- parser
- ui
- validation

package com.gictest.sudoku;

import com.gictest.sudoku.game.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GicTestSudokuApplication {

	public static void main(String[] args) {
		new GameController().start();
	}

}

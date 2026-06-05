package com.gictest.sudoku.board;

public class SudokuBoard {
    public static final int SIZE = 9;

    private final Cell[][] cells;

    public SudokuBoard() {
        cells = new Cell[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new Cell(0,false);
            }
        }
    }

    public Cell getCell(int row,int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, int value, boolean fixed) {
        cells[row][col] = new Cell(value,fixed);
    }

    public boolean isFixedCell(int row, int col) {
        return cells[row][col].isFixed();
    }

    public int getValue(int row, int col) {
        return cells[row][col].getValue();
    }

    public void updateValue(int row, int col, int value) {
        cells[row][col].setValue(value);
    }

    public boolean isComplete() {
        for(int row=0; row<SIZE; row++) {
            for(int col=0; col<SIZE; col++) {
                if(cells[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] toMatrix() {
        int[][] matrix = new int[SIZE][SIZE];
        for(int row=0; row<SIZE; row++) {
            for(int col=0; col<SIZE; col++) {
                matrix[row][col] =
                        getValue(row,col);
            }
        }
        return matrix;
    }

}
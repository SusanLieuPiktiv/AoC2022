package org.example.day_8;

import java.io.*;

public class Day8 {

    public void run() throws IOException {
        // readInput();
        RandomAccessFile raf = new RandomAccessFile("input", "r");
        int a = solveA(new FileReader(raf.getFD()), 99);
        System.out.println(a);

        RandomAccessFile raf2 = new RandomAccessFile("input", "r");
        int b = solveB(new FileReader(raf2.getFD()), 99);
        System.out.println(b);
    }

    public int solveA(Reader reader, int size) throws IOException {
        int[][] grid = parseIntoGrid(reader, size);
        int result = size * 4 - 4;

        for (int y = 1; y < size - 1; y++) {
            for (int x = 1; x < size - 1; x++) {
                if (isTreeVisible(grid, x, y)) {
                    result++;
                }
            }
        }

        return result;
    }

    public int solveB(Reader reader, int size) throws IOException {
        int[][] grid = parseIntoGrid(reader, size);

        int currentMax = 0;

        for (int y = 1; y < size - 1; y++) {
            for (int x = 1; x < size - 1; x++) {
                int value = calculateScenicValue(grid, x, y);
                currentMax = Math.max(currentMax, value);
            }
        }

        return currentMax;
    }


    public int[][] parseIntoGrid(Reader reader, int size) throws IOException {
        final BufferedReader br = new BufferedReader(reader);

        int[][] result = new int[size][size];

        int rowIndex = 0;
        String currentLine;
        while ((currentLine = br.readLine()) != null) {

            for (int columnIndex = 0; columnIndex < size; ++columnIndex) {
                int height = Integer.parseInt(currentLine.substring(columnIndex, columnIndex + 1));
                result[rowIndex][columnIndex] = height;
            }

            rowIndex++;
        }

        return result;
    }

    private int calculateScenicValue(int[][] grid, int column, int row) {
        int ourHeight = grid[row][column];
        int size = grid.length;

        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;

        // checks to the left
        for (int i = column - 1; i >= 0; i--) {
            left++;
            if (grid[row][i] >= ourHeight) {
                break;
            }
        }

        // checks to the right
        for (int i = column + 1; i < size; i++) {
            right++;
            if (grid[row][i] >= ourHeight) {
                break;
            }
        }

        // checks to the top
        for (int i = row - 1; i >= 0; i--) {
            top++;
            if (grid[i][column] >= ourHeight) {
                break;
            }
        }

        // checks to the bottom
        for (int i = row + 1; i < size; i++) {
            bottom++;
            if (grid[i][column] >= ourHeight) {
                break;
            }
        }

        return left * right * top * bottom;
    }

    private boolean isTreeVisible(int[][] grid, int column, int row) {
        int ourHeight = grid[row][column];
        int size = grid.length;

        boolean isVisibleFromLeft = true;
        boolean isVisibleFromRight = true;
        boolean isVisibleFromTop = true;
        boolean isVisibleFromBottom = true;

        // checks to the left
        for (int i = column - 1; i >= 0; i--) {
            if (grid[row][i] >= ourHeight) {
                isVisibleFromLeft = false;
            }
        }

        // checks to the right
        for (int i = column + 1; i < size; i++) {
            if (grid[row][i] >= ourHeight) {
                isVisibleFromRight = false;
            }
        }

        // checks to the top
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][column] >= ourHeight) {
                isVisibleFromTop = false;
            }
        }

        // checks to the bottom
        for (int i = row + 1; i < size; i++) {
            if (grid[i][column] >= ourHeight) {
                isVisibleFromBottom = false;
            }
        }

        return isVisibleFromLeft || isVisibleFromRight || isVisibleFromTop || isVisibleFromBottom;
    }
}

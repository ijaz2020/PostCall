package com.cp.matrix;

import com.cp.Utils.PrintUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NewYearCandiesLR {
    static int[] top = {1, -1, -1, 2, 1, -1}, bottom = {2, -1, -1, 2, -1, 3}, left = {2, 3, -1, -1, -1}, right = {-1, -1, -1, 1, -1};

    public static void main(String[] args) throws FileNotFoundException {
        NewYearCandiesLR n = new NewYearCandiesLR();
        Scanner scanner = new Scanner(new File("/Users/ijaza/code-base/PostCall/src/com/hotel/matrix/NewYearCandy.txt"));
        int row = Integer.parseInt(scanner.next());
        int col = Integer.parseInt(scanner.next());
        scanner.next();
        char[][] candyGrid = new char[row][col];
        n.init(candyGrid);
        n.arrangeCandyGrid(candyGrid, 0, 0);
        PrintUtils.printMatrix(candyGrid);
    }

    private void init(char[][] candyGrid) {
        for (int i = 0; i < candyGrid.length; i++)
            for (int j = 0; j < candyGrid[0].length; j++)
                candyGrid[i][j] = 'X';
    }

    public void arrangeCandyGrid(char[][] candyGrid, int row, int col) {
        char[][] candy = {{'S', 'B'}, {'B', 'S'}};
        for(int i=row; i< candyGrid.length; i++) {
            for (int j = col; j < candyGrid[0].length; j++) {
                for (char[] c : candy) {
                    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                    for (int[] dir : dirs) {
                        int row1 = i + dir[0], col1 = j + dir[1];
                        if (isValidBlock(candyGrid, i, j, row1, col1, c)) {
                            candyGrid[i][j] = c[0];
                            candyGrid[row1][col1] = c[1];
                            int sweetCount = getHorizontalLimit(i, candyGrid, 'S'),
                                    bitterCount = getHorizontalLimit(i, candyGrid, 'B');
                            if ((left[i] == -1 || sweetCount == left[i]) && (right[i] == -1 || bitterCount == right[i])) {
                                arrangeCandyGrid(candyGrid, i + 1, 0);
                            } else if (sweetCount < left[i] || bitterCount < right[i]) {
                                arrangeCandyGrid(candyGrid, i, j + 1);
                            } else {
                                candyGrid[i][j] = 'X';
                                candyGrid[row1][col1] = 'X';
                            }
                        }
                    }
                }
            }
        }
    }

    int getHorizontalLimit(int index, char[][] candyGrid, char candy) {
        int count = 0;
        for (int i = 0; i < candyGrid[0].length; i++) {
            if (candyGrid[index][i] == candy) count++;
        }
        return count;
    }

    boolean isValidBlock(char[][] candyGrid, int row, int col, int row1, int col1, char[] candy) {
        return checkValidIndex(candyGrid, row, col) && candyGrid[row][col] == 'X'
                && checkValidIndex(candyGrid, row1, col1) && candyGrid[row1][col1] == 'X'
                && checkAdjacentCandy(candyGrid, candy[0], row, col) && checkAdjacentCandy(candyGrid, candy[1], row1, col1);
    }

    boolean checkAdjacentCandy(char[][] candyGrid, char c, int row, int col) {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            if (checkValidIndex(candyGrid, row +dir[0], col +dir[1]) && candyGrid[row +dir[0]][col +dir[1]] == c) return false;
        }
        return true;
    }

    boolean checkValidIndex(char[][] candyGrid, int row, int col) {
        return row >= 0 && row < candyGrid.length && col >= 0 && col < candyGrid[0].length;
    }
}

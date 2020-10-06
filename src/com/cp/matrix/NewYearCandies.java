package com.cp.matrix;

import com.cp.Utils.PrintUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class NewYearCandies {

    static int[] top = {1,-1,-1,2,1,-1}, bottom = {2,-1,-1,2,-1,3}, left = {2,3,-1,-1,-1}, right = {-1, -1, -1, 1, -1};
    static final char SWEET = 'S', BITTER = 'B', DEFAULT = 'X';

    public static void main(String[] args) throws FileNotFoundException {
        NewYearCandies n = new NewYearCandies();
        Scanner scanner = new Scanner(new File("/Users/ijaza/code-base/PostCall/src/com/hotel/matrix/NewYearCandy.txt"));
        int row = Integer.parseInt(scanner.next());
        int col = Integer.parseInt(scanner.next());
        char[][] candyGrid = new char[row][col];
        n.init(candyGrid);
        n.arrangeCandyGrid(candyGrid, 0, 0);
        PrintUtils.printMatrix(candyGrid);
    }

    private void init(char[][] candyGrid) {
        for (int i = 0; i < candyGrid.length; i++)
            for (int j = 0; j < candyGrid[0].length; j++)
                candyGrid[i][j] = DEFAULT;
    }

    public void arrangeCandyGrid(char[][] candyGrid, int row, int col) {
        char[][] candy = {{SWEET, BITTER}, {BITTER, SWEET}};
        for (int i = 0; i < candyGrid.length; i++) {
            for (int j = 0; j < candyGrid[0].length; j++) {
                for (char[] c : candy) {
                    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                    for (int[] dir : dirs) {
                        int row1 = i + dir[0], col1 = j + dir[1];
                        if (isValidBlock(candyGrid, i, j, row1, col1, c)) {
                            candyGrid[i][j] = c[0];
                            candyGrid[row1][col1] = c[1];
                            int leftSweetCount = getHorizontalLimit(i, candyGrid, SWEET),
                                    rightBitterCount = getHorizontalLimit(i, candyGrid, BITTER),
                                    topSweetCount = getVerticalLimit(j, candyGrid, SWEET),
                                    bottomBitterCount = getVerticalLimit(j, candyGrid, BITTER);
                            if ((left[i] != -1 && leftSweetCount > left[i]) || (right[i] != -1 && rightBitterCount > right[i])
                                    || (top[j] != -1 && topSweetCount > top[j]) || (bottom[j] != -1 && bottomBitterCount > bottom[j])) {
                                candyGrid[i][j] = DEFAULT;
                                candyGrid[row1][col1] = DEFAULT;
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

    int getVerticalLimit(int index, char[][] candyGrid, char candy) {
        int count = 0;
        for (int i = 0; i < candyGrid.length; i++) {
            if (candyGrid[i][index] == candy) count++;
        }
        return count;
    }

    boolean isValidBlock(char[][] candyGrid, int row, int col, int row1, int col1, char[] candy) {
        int leftSweetCount = getHorizontalLimit(row, candyGrid, SWEET),
                rightBitterCount = getHorizontalLimit(row, candyGrid, BITTER),
                topSweetCount = getVerticalLimit(col, candyGrid, SWEET),
                bottomBitterCount = getVerticalLimit(col, candyGrid, BITTER);

        return checkValidIndex(candyGrid, row, col) && candyGrid[row][col] == DEFAULT
                && checkValidIndex(candyGrid, row1, col1) && candyGrid[row1][col1] == DEFAULT
                && checkAdjacentCandy(candyGrid, candy[0], row, col) && checkAdjacentCandy(candyGrid, candy[1], row1, col1)
                && (left[row] == -1 || leftSweetCount < left[row])
                && (right[row] == -1 || rightBitterCount < right[row])
                && (top[col] == -1 || topSweetCount < top[col])
                && (bottom[col] == -1 || bottomBitterCount < bottom[col]);
    }

    boolean checkAdjacentCandy(char[][] candyGrid, char c, int row, int col) {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            if (checkValidIndex(candyGrid, row + dir[0], col + dir[1]) && candyGrid[row + dir[0]][col + dir[1]] == c)
                return false;
        }
        return true;
    }

    boolean checkValidIndex(char[][] candyGrid, int row, int col) {
        return row >= 0 && row < candyGrid.length && col >= 0 && col < candyGrid[0].length;
    }
}

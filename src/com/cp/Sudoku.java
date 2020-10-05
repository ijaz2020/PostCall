package com.hotel;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    /***
     * {
     * {'.','.','.','.','5','.','.','1','.'},
     * {'.','4','.','3','.','.','.','.','.'},
     * {'.','.','.','.','.','3','.','.','1'},
     * {'8','.','.','.','.','.','.','2','.'},
     * {'.','.','2','.','7','.','.','.','.'},
     * {'.','1','5','.','.','.','.','.','.'},
     * {'.','.','.','.','.','2','.','.','.'},
     * {'.','2','.','9','.','.','.','.','.'},
     * {'.','.','4','.','.','.','.','.','.'}
     * }
     * @param args
     */
    public static void main(String args[]) {
        Sudoku s = new Sudoku();
        char[][] a = {
                {'5', '4', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'5', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(s.isValidSudoku1(a));
    }

    public boolean isValidSudoku1(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    boolean result = checkSudoku(i, j, board[i][j], board);
                    if (!result) return result;
                }
            }
        }
        return true;
    }

    private boolean checkSudoku(int i, int j, char current, char[][] board) {

        for (int k = 0; k < 9; k++)
            if (k != j && board[i][k] == current)
                return false;
        for (int k = 0; k < 9; k++)
            if (k != i && board[k][j] == current)
                return false;
        for (int k = getStartIndex(i); k <= getEndIndex(i); k++) {
            for (int l = getStartIndex(j); l <= getEndIndex(j); l++) {
                if (k == i && l == j) continue;
                if (board[k][l] == current)
                    return false;
            }
        }
        return true;

    }

    int getStartIndex(int i) {
        if (i >= 0 && i <= 2) return 0;
        if (i >= 3 && i <= 5) return 3;
        return 6;
    }

    int getEndIndex(int i) {
        if (i >= 0 && i <= 2) return 2;
        if (i >= 3 && i <= 5) return 5;
        return 8;
    }
}

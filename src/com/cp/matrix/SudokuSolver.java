package com.cp.matrix;

import com.cp.Sudoku;
import com.cp.Utils.PrintUtils;


public class SudokuSolver {
    public static void main(String[] args){
        SudokuSolver s = new SudokuSolver();
        char [][] board = {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(s.sudoku2(board));
        PrintUtils.printMatrix(board);
    }

    public void solveSudoku(char[][] board) {
         doSolve(board, 0, 0);
    }

    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col=0) { // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(i, j, num, board)) {
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }


    boolean sudoku2(char[][] grid) {
        return solveSudoku(0, 0, grid);
    }

    boolean solveSudoku(int row, int col, char[][] grid){
        for(int i=row; i<9; i++, col=0){
            for(int j=col; j<9; j++){
                if(grid[i][j] != '.') continue;
                for(char k='1'; k<='9';k++){
                    if(isValid(i, j, k, grid)){
                        grid[i][j] = k;
                        if(solveSudoku(i, j+1, grid)) return true;
                        grid[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    boolean isValid(int row, int col, char k, char[][] grid){
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3;
        for(int i=0; i<9; i++)
            if(grid[row][i] == k || grid[i][col] == k || grid[blkrow +i/3][blkcol+i%3] == k)
                return false;
        return true;
    }
}

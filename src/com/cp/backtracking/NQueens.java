package com.hotel.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens q = new NQueens();
        q.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        init(board, n);
        solve(board, n, 0, result);
        return result;
    }

    void init(char[][] board, int n){
        for(int i =0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j] = '.';
    }
    List<String> getResult(char[][] board, int n) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                sb.append(board[i][j]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    void solve(char[][] board, int n, int row, List<List<String>> result) {
            for (int j = 0; j < n && row < n; j++) {
                if (isValid(row, j, board, n)) {
                    board[row][j] = 'Q';
                    solve(board, n, row + 1, result);
                    board[row][j] = '.';
                }
            }

        if(row == n) result.add(getResult(board, n));
    }

    //-1, -1 // -1, +1 // +1, -1, //+1, +1
    boolean isValid(int row, int col, char[][] board, int n) {
        for (int i = 0; i < n; i++)
            if (board[row][i] == ('Q') || board[i][col] == 'Q')
                return false;
        int[][] dirs = {{-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        for (int[] dir : dirs) {
            int currRow = row + dir[0], currCol = col + dir[1];
            while (currRow >= 0 && currCol >= 0 && currRow < n && currCol < n) {
                if (board[currRow][currCol] == 'Q') return false;
                currRow += dir[0]; currCol += dir[1];
            }
        }
        return true;
    }
}

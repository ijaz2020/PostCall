package com.cp.backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueenII {
    static int result =0;
    public static void main(String args[]){
        NQueenII n = new NQueenII();
//        n.totalNQueens(4);
        System.out.println(n.totalNQueensOL(4));
        System.out.println(result);
    }

        private final Set<Integer> occupiedCols = new HashSet<Integer>();
        private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
        private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
        public int totalNQueensOL(int n) {
            return totalNQueensHelper(0, 0, n);
        }

        private int totalNQueensHelper(int row, int count, int n) {
            for (int col = 0; col < n; col++) {
                if (occupiedCols.contains(col))
                    continue;
                int diag1 = row - col;
                if (occupiedDiag1s.contains(diag1))
                    continue;
                int diag2 = row + col;
                if (occupiedDiag2s.contains(diag2))
                    continue;
                // we can now place a queen here
                if (row == n-1)
                    count++;
                else {
                    occupiedCols.add(col);
                    occupiedDiag1s.add(diag1);
                    occupiedDiag2s.add(diag2);
                    count = totalNQueensHelper(row+1, count, n);
                    // recover
                    occupiedCols.remove(col);
                    occupiedDiag1s.remove(diag1);
                    occupiedDiag2s.remove(diag2);
                }
            }

            return count;
        }

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        solve(board, n, 0);
        return result;
    }

    void solve(boolean[][] board, int n, int row){
        for(int i=0; i< n && row < n;i++){
            if(isValid(board, row, i, n)){
                board[row][i] = true;
                solve(board, n, row+1);
                board[row][i] = false;
            }
        }
        if(n==row) ++result;

    }

    boolean isValid(boolean[][] board, int row, int col, int n){
        for(int i=0; i<n;i++)
            if(board[row][i] || board[i][col]) return false;
        int[][] dirs = {{-1,-1}, {1,1}, {-1,1}, {1, -1}};
        for(int[] dir : dirs){
            int row1 = row + dir[0], col1 = col + dir[1];
            while(row1 >= 0 && col1 >=0 && row1 < n && col1 < n){
                if(board[row1][col1]) return false;
                row1 += dir[0]; col1 += dir[1];
            }
        }
        return true;
    }

}

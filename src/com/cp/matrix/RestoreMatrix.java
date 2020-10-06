package com.cp.matrix;

import java.util.Arrays;

public class RestoreMatrix {
    public static void main(String[] args) {
        int[] r = {3,7}, c = {4, 6};
        System.out.println(Arrays.deepToString(new RestoreMatrix().restoreMatrix(r, c)));
    }

    public int[][] restoreMatrix(int[] row, int[] col) {
        int m = row.length, n = col.length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0 ; j < n; ++j) {
                A[i][j] = Math.min(row[i], col[j]);
                row[i] -= A[i][j];
                col[j] -= A[i][j];
            }
        }
        return A;
    }
}

package com.cp.matrix;

import com.cp.Utils.PrintUtils;

public class ChangeRookPath {
    public static void main(String[] args){
        int[][] mat = {
                {1,0,1,0},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,0,1},
        };
        new ChangeRookPath().findPath(mat);
        PrintUtils.printMatrix(mat);
    }

    void findPath(int[][] mat){
        for(int i=0; i<mat.length;i++){
            for (int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    populateMatrix(mat, i, j);
                    i++;j++;
                }
            }
        }
    }

    void populateMatrix(int[][] matrix, int i, int j){
        for(int k=0; k<matrix.length; k++){
            matrix[i][k] = 1;
            matrix[k][j] = 1;
        }
    }

}

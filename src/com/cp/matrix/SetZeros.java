package com.hotel.matrix;

import com.hotel.Utils.PrintUtils;

public class SetZeros {
  public static void main(String[] args) {
    int[][] nums = {
      {0,1,2,0},
      {3,4,5,2},
      {1,3,1,5}
    };
    new SetZeros().setZeroes(nums);
    PrintUtils.printMatrix(nums);
  }

  void setZeroes(int[][] matrix) {
    int col0 = 1, rows = matrix.length, cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) col0 = 0;
      for (int j = 1; j < cols; j++)
        if (matrix[i][j] == 0)
          matrix[i][0] = matrix[0][j] = 0;
    }

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 1; j--)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      if (col0 == 0) matrix[i][0] = 0;
    }
  }

  public void setZeroes1(int[][] matrix) {
    if(matrix==null){
      return;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    boolean rowHasZero = false;
    boolean colHasZero = false;

    for(int i=0; i<n; i++){
      if(matrix[0][i]==0){
        rowHasZero = true;
        break;
      }
    }

    for(int i=0; i<m; i++){
      if(matrix[i][0]==0){
        colHasZero = true;
        break;
      }
    }

    for(int i=1; i<m; i++){
      for(int j=1; j<n; j++){
        if(matrix[i][j]==0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }



    for(int j=1;j<n; j++){
      if(matrix[0][j]==0){
        nullifyCol(matrix, j, m, n);
      }
    }

    for(int i=1; i<m; i++){
      if(matrix[i][0]==0){
        nullifyRow(matrix, i, m, n);
      }
    }

    if(rowHasZero){
      nullifyRow(matrix, 0, m, n);
    }
    if(colHasZero){
      nullifyCol(matrix, 0, m, n);
    }

  }

  public void nullifyRow(int[][] matrix, int i, int m, int n){
    for(int col=0; col<n; col++){
      matrix[i][col] = 0;
    }
  }

  public void nullifyCol(int[][] matrix, int j, int m, int n){
    for(int row=0; row<m; row++){
      matrix[row][j] = 0;
    }
  }
}

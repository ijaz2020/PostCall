package com.cp.matrix;

import java.util.Arrays;

public class SetZeroMatrix {
  public static void main(String[] args) {
    int[][] mat = {{0,1,2,0},
                   {3,4,5,2},
                   {1,3,1,5}};
    new SetZeroMatrix().setZeroes(mat);
    System.out.println(Arrays.deepToString(mat));
  }

  public void setZeroes(int[][] matrix) {
    boolean fr = matrix[0][0] == 0, fc = matrix[0][0] == 0;
    int m =matrix.length, n = matrix[0].length;
    for(int i=1; i<m; i++){
      fr = (fr || matrix[0][i] ==0);
      fc = (fc || matrix[i][0] ==0);
      for(int j=1; j<n; j++){
        if(matrix[i][j] == 0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for(int i=0; i<m; i++){
      int o = matrix[i][0];
      matrix[i][0] = fc  ? 0 : matrix[i][0];
      if(o == 0){
        makeZeroR(i, matrix);
      }
    }

    for(int i=0; i<n; i++){
      int o = matrix[0][i];
      matrix[0][i] = fr  ? 0 : matrix[0][i];
      if(o == 0){
        makeZeroC(i, matrix);
      }
    }
  }

  private void makeZeroR(int k, int[][] matrix){
    for(int i=1; i<matrix[0].length;i++){
      matrix[k][i] = 0;
    }
  }

  private void makeZeroC(int k, int[][] matrix){
    for(int i=1; i<matrix.length;i++){
      matrix[i][k] = 0;
    }
  }

  public void setZeroes1(int[][] matrix) {
    if(matrix.length == 0 ) return;
    boolean zeroCol = false;
    int m = matrix.length, n = matrix[0].length;
    for(int i=0; i<m; i++){
      if(matrix[i][0] == 0) zeroCol = true;
      for(int j=1; j < n ; j++){
        if(matrix[i][j] == 0)
          matrix[i][0] = matrix[0][j] = matrix[i][j];
      }
    }


    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 1; j--)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      if (zeroCol) matrix[i][0] = 0;
    }
  }
}

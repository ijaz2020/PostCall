package com.cp.matrix;

class SubrectangleQueries {
/*
[[[1,2,1],
  [4,3,4],    1 0
  [3,2,1],    2 1
  [1,1,1]]]
*/
  int[][] mat;
  int m,n ;
  public SubrectangleQueries(int[][] rectangle) {
    mat = rectangle;
    m= rectangle.length;
    n = rectangle[0].length;
  }

  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    for(int i=row1; i <= row2; i++){
      for(int j = col1; j <= col2; j++){
        mat[i][j] = newValue;
      }
    }
  }

  public int getValue(int row, int col) {
    return mat[row][col];
  }
}

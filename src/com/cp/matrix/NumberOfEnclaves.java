package com.cp.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
  public static void main(String[] args) {
    int[][] nums = {
      {0,0,0,1,1,1,0,1,0,0},
      {1,1,0,0,0,1,0,1,1,1},
      {0,0,0,1,1,1,0,1,0,0},
      {0,1,1,0,0,0,1,0,1,0},
      {0,1,1,1,1,1,0,0,1,0},
      {0,0,1,0,1,1,1,1,0,1},
      {0,1,1,0,0,0,1,1,1,1},
      {0,0,1,0,0,1,0,1,0,1},
      {1,0,1,0,1,1,0,0,0,0},
      {0,0,0,0,1,1,0,0,0,1}};
    System.out.println(new NumberOfEnclaves().numEnclaves(nums));
  }
  public int numEnclaves(int[][] grid) {
    int res = 0, m = grid.length, n =grid[0].length;
    for(int i=0; i<m; i++){
      for(int j=0; j < n; j++){
        if( (i == 0 || j == 0 || i == m-1 ||
          j == n-1) &&  grid[i][j] == 1){
          fill(i, j, grid);
        }
      }
    }

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(grid[i][j] == 1){
          res++;
        }
      }
    }
    return res;
  }

  private void fill(int i, int j, int[][] grid){
    int m = grid.length, n =grid[0].length;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{i, j});
    while(!q.isEmpty()){
      int[] curr = q.poll();
      grid[curr[0]][curr[1]] = 0;
      int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
      for(int[] dir : dirs){
        int x = dir[0] + curr[0] , y = dir[1]+curr[1];
        if(x < 0 || y<0 || x >= m-1 || y >= n-1 || grid[x][y] == 0) continue;
        q.offer(new int[]{x, y});
      }
    }
  }
}

package com.hotel.matrix;

import java.util.HashSet;
import java.util.Set;

public class PathWithMAxGold {
  public static void main(String[] args) {
//    System.out.println(new PathWithMAxGold().getMaximumGold());
  }

  int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
  int max = 0;
  public int getMaximumGold(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for( int i=0; i< m; i++){
      for(int j=0; j<n; j++){
        backTrack(i, j, grid, 0, new HashSet<>());
      }
    }
    return max;
  }

  private void backTrack(int i, int j, int[][] grid, int curr, Set<String> path){
    int m = grid.length, n = grid[0].length;
    if(i< 0 || j < 0 || i >= m || j >=n || grid[i][j] == 0 || !path.add(i+""+j)) return;
    curr +=  grid[i][j];
    max = Math.max(max, curr);
    for(int[] dir : dirs){
      backTrack(i+dir[0], j+dir[1], grid, curr, path);
    }
    path.remove(i+""+j);
  }
}

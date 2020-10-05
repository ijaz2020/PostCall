package com.hotel.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinPathSum {
  public static void main(String[] args) {
    int[][] grid ={ {1,3,1},
                    {1,5,1},
                    {4,2,1}};
    System.out.println(new MinPathSum().minPathSum(grid));
  }

  int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
  public int minPathSum(int[][] grid) {
    if(grid.length ==0 || grid[0].length ==0) return 0;
    int m = grid.length, n = grid[0].length;
    int[][] pathSum = new int[m][n];
    for(int[] sum : pathSum)
      Arrays.fill(sum, Integer.MAX_VALUE);
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0,0});
    pathSum[0][0] = grid[0][0];
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int x = curr[0], y = curr[1];
      for(int[] dir: dirs){
        int i = x + dir[0], j = y + dir[1];
        if(i <0 || j <0 || i>=m || j>=n || grid[i][j]+pathSum[x][y] >=  pathSum[i][j]) continue;
        pathSum[i][j] = pathSum[x][y] + grid[i][j];
        q.offer(new int[]{i, j});
      }
    }
    return pathSum[m-1][n-1];
  }
}

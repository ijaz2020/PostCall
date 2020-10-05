package com.hotel.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static javax.swing.UIManager.put;

public class Mincost {
  public static void main(String[] args) {
    int[][] grid ={{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
    System.out.println(new Mincost().minCost(grid));
  }
  public int minCost(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Map<Integer, int[]> map = new HashMap<>(){{
      put(1, new int[]{0, 1});
      put(2, new int[]{0, -1});
      put(3, new int[]{1, 0});
      put(4, new int[]{-1, 0});
    }};
    int[][] dp = new int[m][n];
    for(int[] i : dp)
      Arrays.fill(i, Integer.MAX_VALUE);
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0,0});
    dp[0][0] = 0;
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int i = curr[0], j= curr[1];
      int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
      for(int[] dir : dirs){
        int x = i + dir[0], y = j + dir[1], currCost =0;
        int[] arr = map.get(grid[i][j]);

        if (arr[0] != dir[0] || arr[1] != dir[1]) {
          currCost = 1;
        }
        if(x < 0 || y < 0 || x >= m || y >= n || dp[i][j]+currCost >= dp[x][y]) continue;
        dp[x][y] = dp[i][j]+currCost;
        q.offer(new int[]{x,y});
      }
    }
    return dp[m-1][n-1];
  }
}

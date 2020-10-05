package com.hotel.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarAsLandPossible {
  public static void main(String[] args) {
    int[][] grid ={
      {0,0,1,1,1},
      {0,1,1,0,0},
      {0,0,1,1,0},
      {1,0,0,0,0},
      {1,1,0,0,1}};

    System.out.println(new AsFarAsLandPossible().maxDistance(grid));
  }

  public int maxDistance(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          queue.offer(new int[] {i, j});
        }
      }
    }
    return fillAround(queue, grid);
  }

  int fillAround(Queue<int[]> queue, int[][] grid) {
    int m = grid.length, n = grid[0].length, score = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean visited = false;
      while (size-- > 0) {
        int[] current = queue.poll();
        int x = current[0], y = current[1];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
          int i = x + dir[0], j = y + dir[1];
          if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) {
            continue;
          }
          if (!visited) {
            score++;
            visited = true;
          }
          grid[i][j] = 1;
          queue.offer(new int[] {i, j});
        }
      }
    }
    return score == 0 ? -1 : score;
  }
}

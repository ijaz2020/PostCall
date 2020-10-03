package com.hotel.bfs;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DetectCyclesInMatrix {
  public static void main(String[] args) {
    char[][] grid= {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
    System.out.println(new DetectCyclesInMatrix().containsCycle(grid));
  }

  int[][] dirs = {{0, 1}, {1, 0}};
  public boolean containsCycle(char[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (char c = 'a'; c <= 'z'; c++) {
      Set<String> coord = new HashSet<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == c && !coord.contains(i+":"+j)) {
            Pair<Set<String>, Boolean> res = bfs(new int[] {i, j}, grid, c);
            if (res.getValue()) {
              return true;
            }
            coord.addAll(res.getKey());
          }
        }
      }
    }
    return false;
  }


  Pair<Set<String>, Boolean> bfs(int[] pos, char[][] grid, char c) {
    Set<String> vis = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    vis.add(pos[0] +":"+pos[1]);
    q.offer(pos);
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      for (int[] dir : dirs) {
        int x = curr[0] + dir[0], y = curr[1] + dir[1];
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != c) {
          continue;
        }
        if (vis.contains(x +":"+ y)) {
          return new Pair<>(vis, true);
        }
        q.offer(new int[] {x, y});
        vis.add(x +":"+ y);
      }
    }
    return new Pair<>(vis, false);
  }
}

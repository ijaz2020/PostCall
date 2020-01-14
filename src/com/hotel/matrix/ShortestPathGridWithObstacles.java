package com.hotel.matrix;

import java.util.*;

public class ShortestPathGridWithObstacles {
    public static void main(String args[]) {
        ShortestPathGridWithObstacles s = new ShortestPathGridWithObstacles();
        int[][] a = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        System.out.println(s.shortestPathWithObstacles(a, 1));
    }

    int max = -1;

    public int shortestPath(int[][] grid, int k) {
        Set<String> visited = new HashSet<>();
        shortestPath(grid, 0, 0, 0, 0, k, visited);
        return max;
    }

    private void shortestPath(int[][] grid, int row, int col, int current, int obsCount, int obstacles, Set<String> visited) {
        if (obsCount > obstacles || row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1
                || visited.contains(row + "" + col)) return;
        if (row == grid.length - 1 && col == grid.length - 1) {
            if (current > max)
                max = current;
            return;
        }
        visited.add(row + "" + col);
        if (grid[row][col] == 1) obsCount++;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            shortestPath(grid, row + dir[0], col + dir[1], current + 1, obsCount, obstacles, visited);
        }
    }

    public int shortestPathWithObstacles(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] dirs = new int[][]{{0,1},{1,0}, {-1, 0}, {0, -1}};
        Queue<int[]> currentLevel = new LinkedList<>();
        currentLevel.offer(new int[]{0,0,0});
        int step =0;
        while(!currentLevel.isEmpty()) {
            int size = currentLevel.size();
            while(size-- > 0){
                int[] currentCell = currentLevel.poll();
                if(currentCell[0] == m-1 && currentCell[1]== n-1) return step;
                for(int[] dir: dirs){
                    int i = currentCell[0]+dir[0], j=currentCell[1]+dir[1];
                    int obstacles = currentCell[2];
                    if(i <0 || j <0 || i >m-1 || j >n-1) continue;
                    int obstacleCount = grid[i][j] + obstacles;
                    if(obstacleCount >= visited[i][j] || obstacleCount > k) continue;
                    visited[i][j] =obstacleCount;
                    currentLevel.offer(new int[]{i, j, obstacleCount});
                }
            }
            step++;
        }
        return -1;
    }


}

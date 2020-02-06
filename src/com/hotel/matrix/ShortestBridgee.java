package com.hotel.matrix;

import com.hotel.Utils.PrintUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestBridgee {
    public static void main(String args[]) {
        ShortestBridgee s = new ShortestBridgee();
        int[][] a = {{0,1,0},{0,0,0},{0,0,1}} ;

        System.out.println(s.shortestBridge(a));
    }

    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        Queue<int[]> currentLevel = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    get1stIsland(A, currentLevel, i, j, visited);
                    return travelToNextIsland(A, currentLevel, visited);
                }
            }
        }
        return -1;
    }

    private int travelToNextIsland(int[][] A, Queue<int[]> currentLevel, Set<String> visited) {
        int m = A.length, n = A[0].length;
        int step = 0;
        while (!currentLevel.isEmpty()) {
            int size = currentLevel.size();
            while (size-- > 0) {
                int[] cell = currentLevel.poll();
                int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] dir : dirs) {
                    int row = dir[0] + cell[0], col = dir[1] + cell[1];
                    if (row < 0 || col < 0 || row > m - 1 || col > n - 1 || !visited.add(row + "," + col)) continue;
                    if (A[row][col] == 1) return step;
                    currentLevel.offer(new int[]{row, col});
                }
            }
            step++;
        }
        return -1;
    }

    private void get1stIsland(int[][] A, Queue<int[]> currentLevel, int i, int j, Set<String> visited) {
        int m = A.length, n = A[0].length;
        Queue<int[]> firstIsland = new LinkedList<>();
        firstIsland.offer(new int[]{i, j});
        currentLevel.offer(new int[]{i, j});
        visited.add(i + "," + j);
        while (!firstIsland.isEmpty()) {
            int size = firstIsland.size();
            while (size-- > 0) {
                int[] cell = firstIsland.poll();
                int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] dir : dirs) {
                    int row = dir[0] + cell[0], col = dir[1] + cell[1];
                    if (row < 0 || col < 0 || row > m - 1 || col > n - 1 || A[row][col] == 0 || !visited.add(row + "," + col))
                        continue;
                    firstIsland.offer(new int[]{row, col});
                    currentLevel.offer(new int[]{row, col});
                }
            }
        }
    }

}

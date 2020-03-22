package com.hotel.matrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumCostOneValidPath {
    public static void main(String[] args){
        int[][] grid = {{1,1,1,1},
                        {2,2,2,2},
                        {1,1,1,1},
                        {2,2,2,2}};
        System.out.println();
    }

    public int minCost(int[][] grid) {
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{0, 1});
        map.put(2, new int[]{0, -1});
        map.put(3, new int[]{1, 0});
        map.put(4, new int[]{-1, 1});
        int m =grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> currentLevel = new LinkedList<>();
        currentLevel.offer(new int[]{0,0,0});
        while (!currentLevel.isEmpty()){

        }
        return 1;
    }
}

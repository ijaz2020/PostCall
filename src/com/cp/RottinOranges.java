package com.cp;

import java.util.LinkedList;
import java.util.Queue;

public class RottinOranges {
    public static void main(String[] args){
        RottinOranges r = new RottinOranges();
        int[][] A= {{2,1,1},{1,1,0},{0,1,1}};
        int[][] B= {
                    {0,1,1,0,1},
                    {0,1,0,1,0},
                    {0,0,0,0,1},
                    {0,1,0,0,1}};
        int[][] B1= {
                    {1}};
//        System.out.println(r.orangesRotting(A));
        System.out.println(r.softwareUpdate(B1));
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n =grid[0].length, freshCount = 0;
        Queue<int[]> currentLevel = new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 2) currentLevel.offer(new int[]{i,j});
                else if(grid[i][j] == 1)freshCount++;
            }
        }
        int steps = 0;
        while(!currentLevel.isEmpty()){
            int size = currentLevel.size();
            while(size-- > 0){
                int[] rottenCell = currentLevel.poll();
                int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
                for(int[] dir: dirs){
                    int row = dir[0] + rottenCell[0], col = dir[1] + rottenCell[1];
                    if(row <0 || col <0 || row >= m || col >= n || grid[row][col] ==0 ||
                            grid[row][col] == 2) continue;
                    currentLevel.offer(new int[]{row, col});
                    grid[row][col] = 2; freshCount--;
                    if(freshCount ==0){
                        currentLevel.clear(); size=0;
                    }
                }
            } steps++;
        }
        return freshCount == 0 ? steps: -1;
    }

    public int softwareUpdate(int[][] grid) {
        int m = grid.length, n =grid[0].length, outOfDateCount = 0;
        Queue<int[]> currentLevel = new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 1) currentLevel.offer(new int[]{i,j});
                else if(grid[i][j] == 0)outOfDateCount++;
            }
        }
        int days = 0;
        while(!currentLevel.isEmpty()){
            int size = currentLevel.size();
            while(size-- > 0){
                int[] updatedServer = currentLevel.poll();
                int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
                for(int[] dir: dirs){
                    int row = dir[0] + updatedServer[0], col = dir[1] + updatedServer[1];
                    if(row <0 || col <0 || row >= m || col >= n || grid[row][col] == 1) continue;
                    currentLevel.offer(new int[]{row, col});
                    grid[row][col] = 1; outOfDateCount--;
                    if(outOfDateCount ==0){
                        currentLevel.clear(); size=0;
                    }
                }
            } days++;
        }
        return outOfDateCount == 0 ? days: -1;
    }
}

package com.cp.stack;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDays(int m, int n, List<List<Integer> > grid1)
    {
        // WRITE YOUR CODE HERE
        int[][] grid= new int[m][n];
        for(int i =0; i<m; i++){
            for(int j=0; j<n;j++){
                grid[i][j] = grid1.get(i).get(j);
            }
        }
        int outOfDateCount = 0;
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
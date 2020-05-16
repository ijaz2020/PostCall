package com.hotel.matrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ValidPathInGrid {
    public static void main(String[] args) {
        int[][] grid = {{2,4,3},{6,5,2}};
//        1 which means a street connecting the left cell and the right cell.
//        2 which means a street connecting the upper cell and the lower cell.
//        3 which means a street connecting the left cell and the lower cell.
//        4 which means a street connecting the right cell and the lower cell.
//        5 which means a street connecting the left cell and the upper cell.
//        6 which means a street connecting the right cell and the upper cell.
        System.out.println(new ValidPathInGrid().hasValidPath(grid));
    }
    Map<Integer, int[][]> dirs = new HashMap<>() {{
        put(1, new int[][]{ {0,-1} , {0,1} });
        put(2, new int[][]{ {-1,0} , {1,0} });
        put(3, new int[][]{ {0,-1} , {1,0} });
        put(4, new int[][]{ {0,1}  , {1,0} } );
        put(5, new int[][]{ {0,-1} , {-1,0} });
        put(6, new int[][]{ {0,1}  , {-1,0} });
    }};
    public boolean hasValidPath(int[][] grid)
    {
        int m = grid.length, n =grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] current = queue.poll();
                int x =  current[0], y =current[1];
                visited[x][y] = true;
                if(x == m-1 && y == n-1)  return true;
                for(int[] dir : dirs.get(grid[x][y])){
                    int i = x + dir[0], j = y+dir[1];
                    if( i < 0 || i >= m || j <0 || j>=n || visited[i][j]) continue;
                    for (int[] rev : dirs.get(grid[i][j])){
                        if(i + rev[0] == x && j+ rev[1] == y){
                            queue.offer(new int[]{i, j});
                        }
                    }
                }
            }
        }
        return false;
    }

}

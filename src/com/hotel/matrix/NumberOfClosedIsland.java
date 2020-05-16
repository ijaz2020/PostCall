package com.hotel.matrix;

public class NumberOfClosedIsland {
    public static void main(String[] args) {
        /*[[0,0,0,0],
           [1,0,1,0],
           [0,1,1,0],
           [0,0,0,0]]*/
        /*[ [0,0,0,1,1,1,0,1,0,0],
            [1,1,0,0,0,1,0,1,1,1],
            [0,0,0,1,1,1,0,1,0,0],
            [0,1,1,0,0,0,1,0,1,0],
            [0,1,1,1,1,1,0,0,1,0],
            [0,0,1,0,1,1,1,1,0,1],
            [0,1,1,0,0,0,1,1,1,1],
            [0,0,1,0,0,1,0,1,0,1],
            [1,0,1,0,1,1,0,0,0,0],
            [0,0,0,0,1,1,0,0,0,1]]*/
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(new NumberOfClosedIsland().closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        int res = 0, m= grid.length, n= grid[0].length;
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(i * j * (i-(m-1)) * (j - (n-1)) == grid[i][j]){
                    fill(i, j, grid);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    res++;
                    fill(i, j, grid);
                }
            }
        }
        return res;
    }


    private void fill(int i, int j, int[][] grid){
        int m= grid.length, n= grid[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        grid[i][j] = 1;
        for(int k = 0; k < dirs.length -1; k++){
            int o= i +dirs[k], p = j+dirs[k+1];
            if(o < 0 || p < 0 || o>= m-1 || p >= n-1 || grid[o][p] == 1) continue;
            fill(o, p, grid);
        }
    }

    int[] directions = new int[]{0, 1, 0, -1, 0};

    public int closedIsland1(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (i == 0 || j == 0 || i == g.length - 1 || j == g[i].length - 1) {
                    fill(g, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g[i].length; ++j) {
                if (g[i][j] == 0) {
                    res++;
                    fill(g, i, j);
                }
            }
        }

        return res;
    }

    private void fill(int[][] g, int x, int y) {
        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || g[x][y] == 1)
            return;
        g[x][y] = 1;
        for (int i = 0; i < directions.length - 1; i++) {
            fill(g, x + directions[i], y + directions[i + 1]);
        }
    }
}

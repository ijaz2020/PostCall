package com.hotel;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args){
        FloodFill f  = new FloodFill();
        int[][] A = {{0,0,0},{0,0,0}};
        int[][] B = {{0,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(f.floodFill(A, 0, 0, 2)));
        System.out.println(Arrays.deepToString(f.floodFill1(B, 0, 0, 2)));
    }

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        return floodFill1(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor, int currentColor) {
        if(sr < 0 || sr >= image.length || sc <0 || sc >= image[0].length || image[sr][sc] != currentColor) return image;

        image[sr][sc] = newColor;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs){
            floodFill1(image, sr+dir[0], sc+dir[1], newColor, currentColor);
        }
        return image;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}


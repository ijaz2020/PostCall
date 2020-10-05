package com.hotel.graph;

import java.util.Arrays;

public class CityWithThreshhold {
    public static void main(String[] args){
        int[][] n={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println(new CityWithThreshhold().findTheCity(4, n, 4));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], 100000000);
            d[i][i] = 0;
        }
        for (int[] edge : edges) {
            d[edge[0]][edge[1]] = Math.min(d[edge[0]][edge[1]], edge[2]);
            d[edge[1]][edge[0]] = Math.min(d[edge[1]][edge[0]], edge[2]);
        }
        // Floyd warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE, res = -1;
        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }
            if (reachable <= min) {
                min = reachable;
                res = i;
            }
        }
        return res;
    }
}

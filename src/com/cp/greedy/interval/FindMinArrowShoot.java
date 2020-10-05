package com.cp.greedy.interval;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class FindMinArrowShoot {
    public static void main(String[] args){
        System.out.println();
    }
    public int findMinArrowShots(int[][] points) {
        int result = 0, n = points.length ;
        if(n == result) return result;
        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));
        int[] current = points[0];
        for(int i=1; i < n; i++){
            if(current[1] > points[i][0]){
                result++;
                current = new int[]{current[0], Math.max(current[1], points[i][1])};
            }
            else current = points[i];
        }
        return result;
    }
}

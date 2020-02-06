package com.hotel.greedy.interval;

import java.util.Arrays;
import java.util.Comparator;

public class OverlappingInterval {
    public static void main(String[] args){
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new OverlappingInterval().eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length, count = 0;;
        if(n == 0) return count;
        Arrays.sort(intervals, Comparator.comparingInt(i->i[1]));
        count =1; int end = intervals[0][1];
        for(int i=1; i<n;i++){
            if(intervals[i][0] >= end){
                end=intervals[i][1];
                count++;
            }
        }
        return n-count;
    }
}

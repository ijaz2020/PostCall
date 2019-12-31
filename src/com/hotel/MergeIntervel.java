package com.hotel;

import java.util.*;

public class MergeIntervel {
    public static void main(String[] args){
//        int[][] A = {{1,3},{2,6}};
        int[][] A = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] A = {{2,3},{3,4},{4,5},{6,7},{7,8}, {8,9}, {1,10}};
        System.out.println(Arrays.deepToString(merge(A)));
        String s =""; s.toLowerCase();
    }

    public static int[][] merge1(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }

        int activeInterval = 0;
        int start = 0;
        for (int key: map.keySet()) {
            if (activeInterval == 0) {
                start = key;
            }
            activeInterval += map.get(key);
            if (activeInterval == 0) {
                list.add(new int[]{start, key});
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    private static int[][] listToArray(List<int[]> list) {
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

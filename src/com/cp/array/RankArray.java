package com.cp.array;

import java.util.*;

public class RankArray {
    public static void main(String[] args){
//        int[] arr = {37,12,28,9,100,56,80,5,12};
        int[] arr = {40,10,20,30};
        System.out.println(Arrays.toString(new RankArray().arrayRankTransform(arr)));
    }
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> current = map.getOrDefault(arr[i], new ArrayList<>());
            current.add(i);
            map.put(arr[i], current);
        }

        int rank = 1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> currentList = entry.getValue();
            for(int i: currentList)
             arr[i] = rank;
            rank++;
        }
        return arr;
    }
}

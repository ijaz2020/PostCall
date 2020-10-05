package com.hotel.array;

import java.util.*;

public class NumberSmallerThanCurrent {
    public static void main(String[] args){
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(new NumberSmallerThanCurrent().smallerNumbersThanCurrent(nums)));
    }

    public int[] smallerNumbersThanCurrent(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> current = map.getOrDefault(arr[i], new ArrayList<>());
            current.add(i);
            map.put(arr[i], current);
        }
        int rank = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> currentList = entry.getValue();
            for (int i : currentList) arr[i] = rank;
            rank+= currentList.size();
        }
        return arr;
    }
}

package com.cp.map;

import java.util.*;

public class SplitArrayToConsecutiveSubsequence {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 8};
        System.out.println(new SplitArrayToConsecutiveSubsequence().isPossible(nums));
//        System.out.println(new SplitArrayToConsecutiveSubsequence().isPossible1(nums));
    }

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        Map<Integer, Integer> lastElementMap = new HashMap<>();

        for(int i : nums){
            if(freqMap.get(i) == 0 ) continue;
            if(lastElementMap.getOrDefault(i,0) > 0){
                reduce(lastElementMap, i);
                lastElementMap.put(i+1, lastElementMap.getOrDefault(i+1, 0) +1);
            }
            else if(freqMap.getOrDefault(i+1, 0) > 0 && freqMap.getOrDefault(i+2, 0) >0){
                reduce(freqMap, i+1);
                reduce(freqMap, i+2);
                lastElementMap.put(i+3, lastElementMap.getOrDefault(i+3, 0) +1);
            }
            else return false;
            reduce(freqMap, i);
        }
        return true;
    }

    void reduce(Map<Integer, Integer> map, Integer i ){
        map.put(i, map.get(i) -1);
    }

    public boolean isPossible1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) continue;
            else if (appendfreq.getOrDefault(i, 0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i + 1, appendfreq.getOrDefault(i + 1, 0) + 1);
            } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                appendfreq.put(i + 3, appendfreq.getOrDefault(i + 3, 0) + 1);
            } else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}

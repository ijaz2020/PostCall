package com.cp.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinimumSubsequence {
  public static void main(String[] args) {
    System.out.println();
  }

  public List<Integer> minSubsequence(int[] nums) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    List<Integer> result = new ArrayList<>();
    int subTotal = 0;
    Arrays.stream(nums).forEach( i -> treeMap.put(i, treeMap.getOrDefault(i, 0) + 1));
    Integer total = Arrays.stream(nums).reduce(0, Integer::sum);

    while(subTotal <= total){
      Integer last = treeMap.lastEntry().getKey();
      subTotal += last;
      total -= last;
      result.add(last);
      treeMap.compute(last, (k, v) ->{
        if(--v ==0)  return null;
        else return v;
      });
    }
    return result;
  }
}

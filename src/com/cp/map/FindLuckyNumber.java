package com.cp.map;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyNumber {
  public static void main(String[] args){
    int[] nums = {1,2,2,3,3,3};
    System.out.println(new FindLuckyNumber().findLucky(nums));
  }

  public int findLucky(int[] arr) {
    int max = -1;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : arr)
      map.put(i, map.getOrDefault(i, 0) + 1);
    for(Integer key : map.keySet()){
      if(key.equals(map.get(key)) && key > max){
        max = key;
      }
    }
    return max;
  }
}

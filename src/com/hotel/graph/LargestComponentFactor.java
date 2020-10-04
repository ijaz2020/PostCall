package com.hotel.graph;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentFactor {
  public static void main(String[] args) {
    int[] nums = {2,3,6,7,4,12,21,39};
    System.out.println(new LargestComponentFactor().largestComponentSize(nums));
  }
  int unionFind[];
  int get(int i){
    return unionFind[i] == i ? i : (unionFind[i] = get(unionFind[i]));
  }

  void add(int i, int j){
    unionFind[get(i)] = unionFind[get(j)];
  }

  public int largestComponentSize(int[] A) {
    int max = Integer.MIN_VALUE;
    for(int a : A){
      max = Math.max(max, a);
    }
    unionFind = new int[max+1];
    for(int i=1; i<=max; i++){
      unionFind[i] = i;
    }
    for(int i : A){
      for(int j=2; j <= (int)Math.sqrt(i); j++){
        if(i%j == 0){
          add(i, j);
          add(i, i/j);
        }
      }
    }
    Map<Integer, Integer> resultMap = new HashMap<>();
    int result = 0;
    for(int i : A){
      int j = get(i);
      resultMap.merge(j, 1, Integer::sum);
      result = Math.max(result, resultMap.get(j));
    }
    return result;
  }

}

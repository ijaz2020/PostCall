package com.cp.array;

import java.util.ArrayList;
import java.util.List;

public class Stugaroo {
  public static void main(String[] args) {
/*    int[] nums = {2, -3, 3,
                  1, 10, 8,
                  2, 5, 13,
                 -5, 3, -18};*/
    int[] nums = {-3, -14, -5, 7, 8, 42, 8, 3};
    System.out.println(new Stugaroo().solution(nums));
  }

  public String solution(int[] nums) {
    // write your code in Java SE 8
    String[] seasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
    int min = Integer.MIN_VALUE, j=-1, n= nums.length;
    List<int[]> res = new ArrayList<>();
    for(int i=0; i<4; i++) res.add(i, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
    for(int i=0; i< n; i++){
      int index = i/(n/4);
      int[] curr = res.get(index);
      int mi = Math.min(curr[0], nums[i]), max = Math.max(curr[1], nums[i]);
      res.set(index, new int[]{mi, max});
    }

    for(int i=0; i<4;i++){
      int[] curr = res.get(i);
      if(curr[1] -curr[0] > min){
        min = curr[1] - curr[0];
        j = i;
      }
    }

    return seasons[j];
  }
}

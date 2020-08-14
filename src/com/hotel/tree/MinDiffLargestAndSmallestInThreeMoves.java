package com.hotel.tree;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinDiffLargestAndSmallestInThreeMoves {
  public static void main(String[] args) {
    int[] nums = {6,6,0,1,1,4,6};
    System.out.println(new MinDiffLargestAndSmallestInThreeMoves().minDifference(nums));
  }

  public int minDifference(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    if (n <= 4) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i + n - 4 < n; i++) {
      min = Math.min(min, nums[i + n - 4] - nums[i]);
    }
    return min;
  }

}

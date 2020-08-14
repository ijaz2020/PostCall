package com.hotel.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSubset {
  public static void main(String[] args) {
    int[] nums = {3,4,16,8};
    System.out.println(new LongestDivisibleSubset().largestDivisibleSubset(nums));
  }

  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length, max = 1, prev = -1;
    Arrays.sort(nums);
    List<Integer> res = new ArrayList<>();
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for(int i=0; i<n; i++){
      int curr = nums[i];
      for(int j = i+1; j < n; j++){
        if(nums[j] % curr == 0){
          dp[j] = Math.max(1 + dp[i], dp[j]);
          max = Math.max(dp[j], max);
        }
      }
    }
    // nums - 1 2 3 6
    // dp   - 1 2 2 3
    for(int i=n-1; i >=0 && max > 0; i--){
      if(dp[i] == max){
        if(prev == -1 || prev % nums[i] == 0) {
          res.add(nums[i]);
          max--;
          prev = nums[i];
        }
      }
    }
    return res;
  }
}

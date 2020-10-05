package com.hotel.dp;

public class NonOverlappingSubArraySum {
  public static void main(String[] args) {
    int[] nums ={-1,3,5,1,4,2,-9};
    System.out.println(new NonOverlappingSubArraySum().maxNonOverlapping(nums, 6));
  }

  public int maxNonOverlapping(int[] nums, int target) {
    int N = nums.length;
    int[] dp = new int[N + 1];
    for (int i = 0; i < N; ++i) {
      int sum = 0;
      for (int j = i; j >= 0; --j) {
        sum += nums[j];
        dp[i + 1] = Math.max(dp[i + 1], dp[j] + (sum == target ? 1 : 0));
      }
    }
    return dp[N];
  }
}

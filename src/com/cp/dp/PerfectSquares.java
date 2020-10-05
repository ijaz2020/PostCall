package com.hotel.dp;

import java.util.Arrays;

public class PerfectSquares {
  public static void main(String[] args) {
    System.out.println(new PerfectSquares().numSquares(12));
  }

  public int numSquares(int n) {
    int max= Integer.MAX_VALUE;
    int[] dp= new int[n+1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for(int i=1, o =1; i>0 && i<=n; o=o+2,i=i+o){
      for(int j = i; j <=n; j++){
        dp[j] = Math.min(dp[j], dp[j-i]+1);
      }
    }
    return dp[n];
  }
}

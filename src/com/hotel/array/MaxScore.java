package com.hotel.array;

public class MaxScore {
  public static void main(String[] args) {
    System.out.println(new MaxScore().maxScore("011101"));
  }
  public int maxScore(String s) {
    int n= s.length(), res = 0, zero=0, one = 0;
    int[] dp = new int[n], dp1 = new int[n];
    for(int i=1; i<n; i++){
      if(s.charAt(i) -'0' == 0)
        dp[i] = ++zero;
      else dp[i] = zero;
    }
    for(int i=n-2; i>=0; i--){
      if(s.charAt(i) -'0' == 1)
        dp1[i] = ++one;
      else dp1[i] = one;
      res = Math.max(res, dp[i]+dp1[i]);
    }
    return res;
  }
}

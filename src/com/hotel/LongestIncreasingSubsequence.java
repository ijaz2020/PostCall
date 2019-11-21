package com.hotel;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){

        int[] a = {0};
        System.out.println(lengthOfLIS(a));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] +1);
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

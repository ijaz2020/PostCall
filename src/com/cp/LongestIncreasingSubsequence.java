package com.hotel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){

        Map<String, Integer> oneMap = new HashMap<>();
        int[] a = {10,9,2,5,3,7,101,18};
//        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS1(a));
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

    public static int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}

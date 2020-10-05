package com.hotel.dp;

public class LongestPalindromingSubsequence {
    public static void main(String[] args){
        System.out.println(new LongestPalindromingSubsequence().longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        int res = 0, n = s.length();
        int[][] dp = new int[n][n];
        for(int i=n-1; i>=0; i--){
            dp[i][i] = 1;
            for(int j=i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}

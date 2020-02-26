package com.hotel.dp;

public class LongestPalindromeSubstring {
    public static void main(String[] args){
        System.out.println(new LongestPalindromeSubstring().longestPalindrome1("babad"));
    }
    public String longestPalindrome1(String S) {
        String res = "";
        for(int i=0; i< S.length(); i++){
            res =checkPalindrome(i, i, res, S);
            res = checkPalindrome(i, i+1, res, S);
        }
        return res;
    }

    String checkPalindrome(int i, int j, String res, String s){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--; j++;
        }
        if(j-i-1 > res.length())
            res = s.substring(i+1, j);
        return res;
    }
    public String longestPalindrome(String S) {
        String res = ""; char[] s=S.toCharArray();
        int n = S.length();

        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                dp[i][j] = s[i] == s[j] && (j-i+1 < 3 || dp[i+1][j-1]);
                if(dp[i][j] && j-i+1> res.length())
                    res = S.substring(i, j+1);
            }
        }
        return res;
    }
}

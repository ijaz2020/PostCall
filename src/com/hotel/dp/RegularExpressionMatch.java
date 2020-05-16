package com.hotel.dp;

public class RegularExpressionMatch {
    public static void main(String[] args){
        System.out.println(new RegularExpressionMatch().isMatch("ab", ".*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        boolean t = true, f =false;
        for(int i=0; i<= m; i++){
            for(int j=0; j<=n ; j++){
                if(i == 0 && j==0)
                    dp[i][j] = t;
                else if(j==0)
                    dp[i][j] = f;
                else if(i==0){
                    if(getP(p, j-1) == '*' && dp[i][j-2])
                        dp[i][j] = t;
                }
                else{
                    if(s.charAt(i-1) == getP(p, j-1) || getP(p, j-1) == '.')
                        dp[i][j] = dp[i-1][j-1];
                    else if(getP(p, j-1) == '*'){
                        if(dp[i][j-2] || ( s.charAt(i-1) == getP(p, j-2) && dp[i-1][j]))
                            dp[i][j] = t;
                    }
                }
            }
        }
        return dp[m][n];
    }

    char getP(String p, int j){
        return p.charAt(j);
    }
}

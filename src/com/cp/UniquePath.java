package com.cp;

import java.util.ArrayList;
import java.util.List;

public class UniquePath {
        public static void main(String[] args){
//            System.out.println(uniquePaths(3, 5));
//            System.out.println(uniquePaths1(5, 3));
            List<Integer> l = new ArrayList<>();

            System.out.println(uniquePaths2(5, 3));
        }
        public static int uniquePaths(int m, int n) {
            if( m ==0 || n==0) return 0;
            int[][] dp = new int[m][n];
            dp[0][0] = 0;
            for(int i=0; i<m;i++){
                for(int j=0; j<n;j++){
                    if(i ==0 || j ==0){
                        dp[i][j] =1;
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            return dp[m-1][n-1];
        }

    public static int uniquePaths1(int cols, int rows) {
        int[] cur = new int[cols];
        int[] pre = new int[cols];

        for(int i=0;i<cols;i++){
            pre[i] = 1;
            cur[i] = 1;
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++)
                cur[j] = cur[j-1] + pre[j];

            pre = cur;
        }

        return cur[cols-1];
    }

    public static int uniquePaths2(int cols, int rows) {
        int[] cur = new int[cols];

//        for(int i=0;i<cols;i++)
//            cur[i] = 1;


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                if(i ==0 || j==0){
                       cur[j] = 1;
                }else {
                    cur[j] = cur[j - 1] + cur[j];
                }
        }

        return cur[cols-1];
    }
}

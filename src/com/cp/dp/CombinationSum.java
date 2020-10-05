package com.cp.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

public class CombinationSum {
    public static void main(String[] args) {
        //[2,3,6,7], target = 7
        int[] ca ={2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(ca, 7));
    }
    //NOT WORKING - WORKING version accepted in LC
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> dp[] = new ArrayList[target+1];
        Arrays.fill(dp, new ArrayList<>());
        List<List<Integer>> tmp = new ArrayList();
        tmp.add(new ArrayList<>());
        dp[0] = tmp;
        for(int c : candidates){
            for(int i=c; i<=target; i++){
                List<List<Integer>> curr = dp[(i-c)];
                int size = curr.size();
                for(int j=0; j< size; j++){
                    List<List<Integer>> ref = dp[i] == null ? new ArrayList<>() : dp[i];
                    List<Integer> temp = new ArrayList<>(curr.get(j));
                    temp.add(c);
                    ref.add(temp);
                    dp[i] = ref;
                }
            }
        }
        return dp[target];
    }
}

package com.hotel.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinLengthTwoNonOverlappingSubArrays {
  public static void main(String[] args) {
    int[] nums = {3,1,1,1,5,1,2,1};
      /*{3,2,2,4,3};*/
    System.out.println(new MinLengthTwoNonOverlappingSubArrays().minSumOfLengths(nums, 3));
//    System.out.println(new MinLengthTwoNonOverlappingSubArrays().minSumOfLengths1(nums, 3));
  }

  public int minSumOfLengths(int[] nums, int s) {
    int i=0, j=0, n = nums.length, res = n+1, max = Integer.MAX_VALUE;
    int[] dp = new int[n];
    Arrays.fill(dp, max);
    while(j < n){
      s -= nums[j];
      while(s <=0){
        if(s == 0) {
          dp[j] = j-i+1;
        }
        s += nums[i++];
      }
      j++;
    }
    int currMin = max;
    for(int k = 0 ; k < n; k++){
      if(dp[k] != max){
        if(k - dp[k] >= 0 && dp[ k - dp[k]] != max){
          res = Math.min(res, dp[k] + dp[k - dp[k]]);
        }
      }
      currMin = Math.min(currMin, dp[k]);
      dp[k] = currMin;
    }
    return res == n+1 ? -1: res;
  }

  public int minSumOfLengths1(int[] arr, int target) {
    HashMap<Integer,Integer> hmap=new HashMap<>();
    int sum=0,lsize=Integer.MAX_VALUE,result=Integer.MAX_VALUE;
    hmap.put(0,-1);
    for(int i=0;i<arr.length;i++){
      sum+=arr[i];
      hmap.put(sum,i); // stores key as sum upto index i, and value as i.
    }
    sum=0;
    for(int i=0;i<arr.length;i++){
      sum+=arr[i];
      if(hmap.get(sum-target)!=null){
        lsize=Math.min(lsize,i-hmap.get(sum-target));      // stores minimum length of sub-array starting with index<= i with sum target. This ensures non- overlapping property.
      }
      //hmap.get(sum+target) searches for any sub-array starting with index i+1 with sum target.
      if(hmap.get(sum+target)!=null&&lsize<Integer.MAX_VALUE){
        result=Math.min(result,hmap.get(sum+target)-i+lsize); // updates the result only if both left and right sub-array exists.
      }
    }
    return result==Integer.MAX_VALUE?-1:result;
  }

}

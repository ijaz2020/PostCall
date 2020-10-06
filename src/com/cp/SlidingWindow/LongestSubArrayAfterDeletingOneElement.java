package com.cp.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class LongestSubArrayAfterDeletingOneElement {

  public static void main(String[] args) {
    int[] nums ={1,1,1};
    System.out.println(new LongestSubArrayAfterDeletingOneElement().longestSubarray(nums));
  }

  public int longestSubarray(int[] nums) {
    //[0,1,1,1,0,1,1,0,1] n = 9
    //  0 1 2 3 4 5 6 7 8
    int sum = 0, i=0, j=0, n = nums.length, min = 0;
    while(j < n ){
      sum += nums[j];
      if(j-i > sum){
        sum -= nums[i++];
      }
      else{
        if(j-i + 1 == sum)
          min = Math.max(min, sum -1);
        else
          min = Math.max(min, sum);
        j++;
      }
    }
    return min;
  }

 /* int kthFactor( int n, int k) {
    List<Integer> left = new ArrayList<>(), right = new ArrayList<>(;
    int i = 1;
    double sqrt = Math.sqrt(n);
    while (i < sqrt) {
      if (n % i == 0) {
        left.add(i);
        right = (n/i).concat(right);
      }
      i++;
    }
    if (i == sqrt)
      left.push(i);

    const res = left.concat(right);

    return k > res.length ? -1 : res[k-1];
  };*/
}

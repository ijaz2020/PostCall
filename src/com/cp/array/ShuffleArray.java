package com.cp.array;

import java.util.Arrays;

public class ShuffleArray {
  public static void main(String[] args) {
    int[] num = {1,2,3,4,   4,3,2,1}; int n = 4;
    System.out.println(Arrays.toString(new ShuffleArray().shuffle(num, n)));
  }

  public int[] shuffle(int[] nums, int n) {
    int l = nums.length, i =0;
    int[] res = new int[l];
    for(int j=0; j< l/2; j++){
      res[i++] = nums[j];
      res[i++] = nums[j+n];
    }
    return res;
  }
}

package com.cp.Math;

public class CanMakeArithmeticProgression {
  public static void main(String[] args) {
    int[] nums = {1,-8,20,9};
    System.out.println(new CanMakeArithmeticProgression().canMakeArithmeticProgression(nums));
  }

  // incorrect method - will not work
  public boolean canMakeArithmeticProgression(int[] arr) {
    int min = arr[0], s_min =arr[1], sum = 0, n = arr.length;
    for(int i : arr){
      sum += i;
      if( i < min) {
        s_min = min;
        min =i;
      }
    }
    int d= s_min - min;
    return ((2 * min + (n - 1) * d) * n) / 2 == sum;
  }
}

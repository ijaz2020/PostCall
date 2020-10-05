package com.cp.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
  public static void main(String[] args) {
//    int[] nums = {3,30,34,5,9};
    int[] nums = {10, 2};
    System.out.println(new LargestNumber().largestNumber(nums));
  }
  public String largestNumber(int[] nums) {
    Integer[] nos = new Integer[nums.length];
    for(int i=0; i<nums.length;i++) nos[i]= nums[i];
    Arrays.sort(nos, (a, b) -> (a+""+b).compareTo(b+""+a));
    StringBuilder sb = new StringBuilder();
    for(int i = nos.length -1;i >=0 ;i--)  sb.append(nos);
    return sb.toString().replaceFirst("^0+(?!$)", "");
  }
}

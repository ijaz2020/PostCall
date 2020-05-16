package com.hotel.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
  public static void main(String[] args) {
    int[] nums = {3,30,34,5,9};
    System.out.println(new LargestNumber().largestNumber(nums));
  }
  public String largestNumber(int[] nums) {
    Integer[] nos = new Integer[nums.length];
    for(int i=0; i<nums.length;i++) nos[i]= nums[i];
    Arrays.sort(nos, (a, b) -> (a+""+b).compareTo(b+""+a));
    StringBuilder sb = new StringBuilder();
    for(int i: nos) sb.append(i);
    return sb.toString();
  }
}

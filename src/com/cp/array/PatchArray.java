package com.hotel.array;

public class PatchArray {
  public static void main(String[] args) {
    int[] nums = {1,5,10};
    System.out.println(
      new PatchArray().minPatches(nums, 20));
  }

  int minPatches(int[] nums, int n) {
    int miss = 1, added = 0, i = 0;
    while (miss <= n) {
      if (i < nums.length && nums[i] <= miss) {
        miss += nums[i++];
      } else {
        miss += miss;
        added++;
      }
    }
    return added;
  }
}

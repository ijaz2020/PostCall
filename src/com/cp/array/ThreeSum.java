package com.cp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {
  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(new ThreeSum().threeSum(nums));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    // -4 -1 -1 0 1 2
    //  0  1  2 3 4 5
    int n = nums.length;
    Arrays.sort(nums);
    Set<List<Integer>> res = new HashSet<>();
    for(int i=0; i <n-2; i++){
      int l = i+1, r = n -1;
      if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        while (l < r) {
          int sum = nums[i] + nums[l] + nums[r];
          if (sum == 0) {
            res.add(IntStream.of(nums[i], nums[l++], nums[r--]).boxed().collect(Collectors.toList()));
          } else if (sum > 0) {
            r--;
          } else {
            l++;
          }
        }
      }
    }
    return new ArrayList<>(res);
  }
}

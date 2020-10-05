package com.cp.array;

public class MinimumNeededForOne {

  public static void main(String[] args) {
    int[] nums = {-3,2,-3,4,2};
    System.out.println(new MinimumNeededForOne().minStartValue(nums));
  }
  public int minStartValue(int[] nums) {
    int res = 1, need = 1;
    for(int i : nums){
      int curr = res + i;
      if(curr < 1){
        need -= curr;
        res -= curr;
      }
      else res+= i;
    }
    return need;
  }
}

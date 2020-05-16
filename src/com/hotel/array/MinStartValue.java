package com.hotel.array;

public class MinStartValue {
  public static void main(String[] args) {
    int[] nums = {-3,2,-3,4,2};
    System.out.println(new MinStartValue().minStartValue(nums));
  }

  public int minStartValue(int[] nums) {
    int init = 1, res = 0;
    for(int i : nums){
      init += i;
      if(init < 1){
        res += 1 -init;
        init += 1 -init;
      }
    }
    return res;
  }
}

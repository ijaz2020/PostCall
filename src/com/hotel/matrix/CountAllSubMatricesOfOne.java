package com.hotel.matrix;

public class CountAllSubMatricesOfOne {
  public static void main(String[] args) {
    int[] nums = {1,1,1,1,0,1};
    System.out.println(new CountAllSubMatricesOfOne().numSubmat(nums));
  }

  public int numSubmat(int[] A) {
    int res = 0, length = 0;
    for (int i : A) {
      length = i == 0 ? 0 : length + 1;
      res += length;
    }
    return res;
  }
}

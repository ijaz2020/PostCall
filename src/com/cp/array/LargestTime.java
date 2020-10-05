package com.hotel.array;

public class LargestTime {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(new LargestTime().largestTimeFromDigits(nums));
  }

  public String largestTimeFromDigits(int[] A) {
    String res = "";
    for (int l = 0; l < 4; ++l) {
      for (int m = l+1; m < 4; ++m) {
        for (int n = m+1; n < 4; ++n) {
          if (l == m || l == n || m == n) {
            continue;
          }
          String hour = "" + A[l] + A[m],
            minute = "" + A[n] + A[6 - l - m - n],
            time = hour + ":" + minute;
          if (hour.compareTo("24") < 0 && minute.compareTo("60") < 0 && res.compareTo(time) < 0) {
            res = time;
          }
        }
      }
    }
    return res;
  }
}

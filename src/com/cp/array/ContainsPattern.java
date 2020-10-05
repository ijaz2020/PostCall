package com.hotel.array;

public class ContainsPattern {
  public static void main(String[] args) {
    int[] arr = {1,2,1,2,1,2,1,3};
    System.out.println(new ContainsPattern().containsPattern(arr, 2, 3));
  }

  public boolean containsPattern(int[] arr, int m, int k) {
    for(int i = 0, j = i + m, count = 0; j < arr.length; ++i, ++j) {
      if (arr[i] != arr[j]) {
        count = 0;
      } else if (++count == (k - 1) * m) {
        return true;
      }
    }
    return false;
  }
}

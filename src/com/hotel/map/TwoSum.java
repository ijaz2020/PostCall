package com.hotel.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TwoSum {

  public static void main(String[] args) {
    int[][] a ={{1, 3}, {2, 5}, {3, 7}, {4, 10}};
    int[][] b ={{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    List<int[]> res = (new TwoSum().findPairs(a, b, 10));
    for(int[] i : res){
      System.out.println(Arrays.toString(i));
    }
  }

  public List<int[]> findPairs(int[][] a, int[][] b, int target) {
    Arrays.sort(a, Comparator.comparingInt((int[] o) -> o[1]));
    Arrays.sort(b, Comparator.comparingInt((int[] o) -> o[1]));

    List<int[]> res = new ArrayList<>();
    int i = 0, j = a.length - 1;
    int max = 0;
    while (i < b.length && j >= 0) {
      if (a[j][1] + b[i][1] > target) {
        j--;
      } else {
        if (a[j][1] + b[i][1] > max) {
          max = a[j][1] + b[i][1];
          res.clear();
          res.add(new int[]{a[j][0], b[i][0]});
        } else if (a[j][1] + b[i][1] == max) {
          res.add(new int[]{a[j][0], b[i][0]});
        }
        i++;
      }
    }
    return res;
  }
}

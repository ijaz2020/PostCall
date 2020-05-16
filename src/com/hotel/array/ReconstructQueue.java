package com.hotel.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {
  public static void main(String[] args) {
    int[][] nums = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    System.out.println(Arrays.deepToString(new ReconstructQueue().reconstructQueue(nums)));
  }
//[[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
  public int[][] reconstructQueue(int[][] people) {
//    Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    List<int[]> list = new LinkedList<>();
    for (int[] p : people) {
      list.add(p[1], p);
    }
    return list.toArray(new int[list.size()][]);
  }

}

package com.hotel.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ReconstructQueue {
  public static void main(String[] args) {
    int[][] nums = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    System.out.println(Arrays.deepToString(new ReconstructQueue().reconstructQueue(nums)));
  }
//[[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
  public int[][] reconstructQueue(int[][] people) {
/*
    Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    List<int[]> list = new ArrayList<>();
    for (int[] p : people) {
      list.add(p[1], p);
    }
    return list.toArray(new int[list.size()][]);
*/
    return Stream.of(people)

      // sorting by height desc and then by number of higher people in the queue
      .sorted( (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]/*Comparator.<int[]>comparingInt(person -> person[0]).reversed().thenComparing(person -> person[1])*/)

      // collecting to list by inserting people by number of higher people in the queue
      .collect(LinkedList::new, (list, person) -> list.add(person[1], person), LinkedList::addAll)

      .toArray(new int[people.length][]); // converting to array
  }

}

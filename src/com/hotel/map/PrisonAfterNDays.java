package com.hotel.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrisonAfterNDays {
  public static void main(String[] args) {
    /*[1,1,0,0,0,0,1,1]
    7*/
//    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
    int[] n = {1,0,0,1,0,0,1,0};
    System.out.println(Arrays.toString(new PrisonAfterNDays().prisonAfterNDays(n, 1000000000)));
  }

  public int[] prisonAfterNDays(int[] cells, int N) {
    var list = new ArrayList<Integer>();
    var set = new HashSet<Integer>();
    int n = 0;
    while (N-- > 0) {
      for (int i = 0; i < 8; i++) {
        n <<= 1;
        if (i == 0 || i == 7) {
          continue;
        }
        int j = cells[i - 1] ^ cells[i + 1] ^ 1;
        n |= j;
      }
      if (!set.add(n)) {
        return getArr(list.get(N % list.size()));
      }
      list.add(n);
      cells = getArr(n);
    }
    return cells;
  }

  int[] getArr(int n) {
    int[] cells1 = new int[8];
    for (int i = 7; i >= 0; i--) {
      cells1[i] = (n & 1) == 1 ? 1 : 0;
      n >>= 1;
    }
    return cells1;
  }

  public int[] prisonAfterNDays1(int[] cells, int N) {
    Map<String, Integer> visited = new HashMap<>();

    while (N > 0) {
      int[] cells2 = new int[8];
      visited.put(Arrays.toString(cells), N--);
      for (int i = 1; i < 7; i++) {
        cells2[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
      }
      cells = cells2;
      if (visited.containsKey(Arrays.toString(cells))) {
        N %= visited.get(Arrays.toString(cells)) - N;
      }
    }
    return cells;
  }

  public int[] prisonAfterNDays2(int[] cells, int N) {
    HashSet<String> visited = new HashSet<>();
    int[] cells2 = new int[8];
    while (N-- > 0) {
      for (int i = 1; i < 7; i++) {
        cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
      }
      String curr = Arrays.toString(cells2);
      if (visited.contains(curr)) {
        N = N % visited.size();
        visited.clear();
      }
      visited.add(curr);
      cells = cells2;
    }
    return cells2;
  }
}

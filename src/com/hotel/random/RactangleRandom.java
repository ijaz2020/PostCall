package com.hotel.random;

import java.util.Random;
import java.util.TreeMap;

public class RactangleRandom {
  int[][] r;
  TreeMap<Integer, Integer> integerIntegerTreeMap;
  Random ranDrandom;
  int sum = 0;

  public RactangleRandom(int[][] rope) {
    this.r = rope;
    integerIntegerTreeMap = new TreeMap<>();

    ranDrandom = new Random();

    for (int i = 0; i < rope.length; i++) {
      int[] rect = rope[i];
      sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
      integerIntegerTreeMap.put(sum, i);

    }
  }

  public int[] pick() {
    int rand = ranDrandom.nextInt(sum) + 1;

    int k = integerIntegerTreeMap.ceilingKey(rand);
    int i = k - rand;
    int[] roct = r[integerIntegerTreeMap.get(k)];
    int l = roct[0],
      b = roct[1],
      r = roct[2];
    int o = l + i % (r - l + 1);
    int m = b + i / (r - l + 1);
    return new int[] {o, m};
  }
}

package com.cp.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperature {
  public static void main(String[] args) {
    //[1, 1, 4, 2, 1, 1, 0, 0]
    int[] n = {73, 74, 75, 71, 69, 72, 76, 73};
    System.out.println(Arrays.toString(new DailyTemperature().dailyTemperatures(n)));
  }

  public int[] dailyTemperatures(int[] T) {
    Deque<Integer> d = new ArrayDeque<>();
    int[] res = new int[T.length];
    for(int i=0; i<T.length;i++){
      while (!d.isEmpty() && T[i] > T[d.getLast()]){
        int idx = d.pollLast();
        res[idx] = i - idx;
      }
      d.offer(i);
    }
    return res;
  }
}

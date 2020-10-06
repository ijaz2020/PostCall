package com.cp.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingElementsWhichHasNext {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(new CountingElementsWhichHasNext().countElements(nums));
  }

  public int countElements(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    Arrays.stream(arr).forEach(i -> {
      freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
    });

    int result = 0;
    for (Integer i : freqMap.keySet()) {
      if (freqMap.containsKey(i + 1))
        result += freqMap.get(i);
    }

    return result;
/*    return freqMap.entrySet().stream()
      .filter(entry -> freqMap.containsKey(entry.getKey()+1))
      .reduce(0, (a, b) -> (a.getValue() + b.getValue()));
  }*/
  }

}

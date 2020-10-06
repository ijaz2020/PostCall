package com.cp.priorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindUniqueAfterKRemoval {
  public static void main(String[] args) {
    /*[2,1,1,3,3,3]
    3*/
    int[] arr = {2,1,1,3,3,3}; int k = 3;
    System.out.println(new FindUniqueAfterKRemoval().findLeastNumOfUniqueInts(arr, k));
  }

  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : arr){
      map.put(i, map.getOrDefault(i, 0) +1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      pq.offer(entry);
    }
    int res =0;
    while(k-- > 0){
      Map.Entry<Integer, Integer> curr = pq.poll();
      curr.setValue(curr.getValue() -1);
      if(curr.getValue() > 0){
        pq.offer(curr);
      }
    }
    for(Integer i : map.keySet()){
      res += map.get(i) > 0 ? 1 : 0;
    }
    return res;
  }
}

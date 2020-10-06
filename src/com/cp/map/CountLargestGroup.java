package com.cp.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CountLargestGroup {
  public static void main(String[] args) {
    System.out.println(new CountLargestGroup().countLargestGroup1(13));
  }

  public int countLargestGroup(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=1; i<=n; i++){
      int digit = sumDigit(i);
      map.put(digit, map.getOrDefault(digit, 0)+1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      pq.offer(entry);
    }
    int result = 1, start = pq.poll().getValue();
    while(!pq.isEmpty()){
      if(start != pq.poll().getValue()) break;
      result++;
    }
    return result;
  }

  private int sumDigit(int i){
    int sum =0;
    while(i !=0){
      sum += i %10;
      i /= 10;
    }
    return sum;
  }

  int dsum(int n) {
    return n == 0 ? 0 : n % 10 + dsum(n / 10);
  }
  public int countLargestGroup1(int n) {
    ArrayList<Integer> cnt = new ArrayList<>(Collections.nCopies(37, 0));
    for (int i = 1; i <= n; ++i) {
      int c = dsum(i);
      cnt.set(c, cnt.get(c) + 1);
    }
    return Collections.frequency(cnt, Collections.max(cnt));
  }
}

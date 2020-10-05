package com.hotel.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeastIntervel {
  public static void main(String[] args) {
    char[] c = {'A','A','A','B','B','B'};
    System.out.println(new LeastIntervel().leastInterval(c, 2));
  }

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for(char c: tasks){
      freqMap.merge(c, 1, Integer::sum);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    pq.addAll(freqMap.values());
    Map<Integer, Integer> coolDown = new HashMap<>();
    int res = 0;
    while(!pq.isEmpty() || !coolDown.isEmpty()){
      if(coolDown.containsKey(res)){
        pq.offer(coolDown.remove(res));
      }
      if(!pq.isEmpty()){
        int curr = pq.poll()-1;
        if(curr!=0){
          coolDown.put(curr, res+n+1);
        }
      }
      res++;
    }
    return res;
  }
}

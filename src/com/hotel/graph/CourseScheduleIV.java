package com.hotel.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleIV {
  public static void main(String[] args) {
    int[][] p = {{0,1},{1,2},{2,3},{3,4}}, queries = {{0,4},{4,0},{1,3},{3,0}};
    System.out.println(new CourseScheduleIV().checkIfPrerequisite(5, p, queries));
  }

  public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i=0; i<n;i++) inDegree.put(i, 0);
    for (int[] prerequisite : p)
      inDegree.put(prerequisite[0], inDegree.getOrDefault(prerequisite[0], 0) + 1);
    Queue<Integer> processedVertex = new LinkedList<>();
    for(Integer key: inDegree.keySet())
      if(inDegree.get(key) == 0) {
        processedVertex.offer(key);
        map.put(key, new HashSet<>());
      }
    while ( !processedVertex.isEmpty() ){
      Integer vertex = processedVertex.poll();
      for(int[] i : p){
        if(vertex == i[1]){
          inDegree.put(i[0], inDegree.get(i[0]) -1);
          map.compute(i[1], (k, v) ->{
            if(v == null){
              Set<Integer> s = new HashSet<>();
              s.add(i[0]);
              return s;
            }
            else{
              v.add(i[0]);
            }
            return v;
          });
          if(inDegree.get(i[0]) == 0){
            processedVertex.offer(i[0]);
          }
        }
      }
    }

    List<Boolean> res = new ArrayList<>();
    for(int[] i : q){
      if(map.get(i[1]) == null){
        res.add(false);
      }
      else{
        res.add(map.get(i[1]).contains(i[0]));
      }
    }

    return res;
  }
}

package com.cp.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PossibleBiPartition {

  public static void main(String[] args) {
    //N = 4, dislikes = [[1,2],[1,3],[2,4]]
    int[][] dislikes = {};
    System.out.println(new PossibleBiPartition().possibleBipartition(1, dislikes));
  }
  // 1,  2, 3, 4
  // 1  -1 -1  1

  // 1 - 2,3
  // 2 - 1,4
  // 3 - 1
  // 4 - 2
  public boolean possibleBipartition(int N, int[][] dislikes) {
    int[] c = new int[N+1];
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for(int[] d : dislikes){
      graph.computeIfAbsent(d[0], k -> new HashSet<>());
      graph.get(d[0]).add(d[1]);
      graph.computeIfAbsent(d[1], k -> new HashSet<>());
      graph.get(d[1]).add(d[0]);
    }

    for(int i=1; i < N+1; i++){
      if(c[i] == 0){
        c[i] = 1;
        boolean res = bfs(graph, c, i);
        if(!res) return false;
      }
    }
    return true;
  }

  boolean bfs(Map<Integer, Set<Integer>> graph, int[] c, int i){
    Queue<Integer> q = new LinkedList<>();
    q.offer(i);
    while(!q.isEmpty()){
      int curr = q.poll(), opp = -(c[curr]);
      if(graph.get(curr) == null) continue;
      for(Integer j : graph.get(curr)){
        if(c[j] == 0){
          c[j] = opp;
          q.offer(j);
        }
        else if(c[j] != opp) return false;
      }
    }
    return true;
  }
}

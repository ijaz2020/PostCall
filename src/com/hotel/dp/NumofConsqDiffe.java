package com.hotel.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumofConsqDiffe {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new NumofConsqDiffe().numsSameConsecDiff(3, 7)));
  }

  public int[] numsSameConsecDiff(int N, int K) {
    Queue<Integer> res = new LinkedList<>();  //[181,292,707,818,929]
    for(int i=1; i<=9; i++) res.offer(i);
    dfs(N-1, K, res);
    return res.stream().mapToInt(i -> i).toArray();
  }

  void dfs(int n, int k, Queue<Integer> res){
    if( n == 0) return;
    int dir[] = {k, -k}, size = res.size();
    while(size-- > 0){
      int curr = res.poll();
      for(int j : dir){
        int ne = (curr%10)+j;
        if(ne <0 || ne >9) continue;
        res.offer(curr*10+ne);
      }
    }
    dfs(n-1, k, res);
  }
}

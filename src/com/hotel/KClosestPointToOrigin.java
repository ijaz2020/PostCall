package com.hotel;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
  public static void main(String[] args) {
    int[][] nums = {{3,3},{5,-1},{-2,4}};
    System.out.println(Arrays.deepToString(new KClosestPointToOrigin().kClosest(nums, 2)));
  }

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for(int i=0; i< points.length; i++){
      int dis  = findDistance(points[i][0], points[i][1]);
      if(pq.isEmpty() || pq.size() <K){
        pq.offer(new int[]{i, dis});
      }
      else if(pq.peek()[1] > dis){
        pq.poll();
        pq.offer(new int[]{i, dis});
      }
    }
    int[][] res = new int[pq.size()][2];
    int i = 0;
    while(!pq.isEmpty()){
      res[i++] = points[pq.poll()[0]];
    }
    return res;
  }

  int findDistance(int x, int y){
    return (int)Math.sqrt( (x*x) + (y*y) );
  }
}

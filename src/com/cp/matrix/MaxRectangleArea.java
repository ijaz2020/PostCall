package com.cp.matrix;

import java.util.Arrays;

public class MaxRectangleArea {
  //h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
  public static void main(String[] args) {
    int[] hCuts = {1,2,4}, vCuts = {1,3};
    System.out.println(new MaxRectangleArea().maxArea(5, 4, hCuts, vCuts));
  }

  public int maxArea(int hi, int wi, int[] hCuts, int[] vCuts) {
    int max = 0, m = hCuts.length+2, n = vCuts.length+2;
    int[] h = new int[m], v = new int[n];
    h[m-1] = hi; v[n-1] = wi;
    for(int i=0; i<hCuts.length; i++) h[i+1] = hCuts[i];
    for(int i=0; i<vCuts.length; i++) v[i+1] = vCuts[i];
    Arrays.sort(h);
    Arrays.sort(v);

    for(int i=1; i < n; i++){
      for(int j=1; j < m; j++){
        max = Math.max(max, ((h[j] - h[j-1]) * (v[i] - v[i-1])));
      }
    }
    return max;
  }
}

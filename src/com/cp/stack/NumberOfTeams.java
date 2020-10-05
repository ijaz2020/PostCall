package com.cp.stack;

import java.util.Stack;

public class NumberOfTeams {
  public static void main(String[] args) {
    int[] rating = {2,5,3,4,1};
    System.out.println(new NumberOfTeams().numTeams(rating));
  }

  public int numTeams(int[] arr) {
    int res = 0, n = arr.length;
    int[] countSmaller = new int[n];
    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if (arr[j] < arr[i])
          countSmaller[i]++;
      }
    }
    for(int i=0; i<n;i++){
      if(countSmaller[i] >=2){
        res += countSmaller[i]-1;
      }
    }

    for (int i = 0; i < n; i++)
    {
      for (int j = i + 1; j < n; j++)
      {
        if (arr[j] > arr[i])
          countSmaller[i]++;
      }
    }

    for(int i=0; i<n;i++){
      if(countSmaller[i] >=2){
        res += countSmaller[i]-1;
      }
    }
    return res;
  }
}

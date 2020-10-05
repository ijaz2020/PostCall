package com.cp.array;

import java.util.Arrays;

public class SumEvenAfterQueries {
  public static void main(String[] args) {
    int[][] q= {{1,0},{-3,1},{-4,0},{2,3}};
    int[] A= {1,2,3,4};
    System.out.println(Arrays.toString(new SumEvenAfterQueries().sumEvenAfterQueries(A, q)));
  }

  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int even =0, j=0;
    int[] res = new int[queries.length];
    for(int i : A) even += (i & 1) ==0 ? i : 0;
    for(int[] query: queries){
      int k = query[1];
      even -= (A[k] & 1) == 0 ? A[k] : 0;
      A[k]+=query[0];
      even += (A[k] & 1) == 0 ? A[k] : 0;
      res[j++] = even;
    }
    return res;
  }
}

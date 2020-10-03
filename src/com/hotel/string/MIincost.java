package com.hotel.string;

import java.util.Arrays;

public class MIincost {
  public static void main(String[] args) {
    System.out.println();
  }

  public int minCost(String s, int[] cost) {
    char[] chars = s.toCharArray();
    int res = 0, count =1;
    for(int i=1; i < chars.length; i++){
      if(chars[i-1] == chars[i]) count++;
      else {
        int[] curr = Arrays.copyOfRange(cost, i-count, i);
        Arrays.sort(curr);
        for(int j=0; j<curr.length-1; j++){
          res += curr[j];
        }
        count =1;
      }
    }
    if(count > 1){
      int[] curr = Arrays.copyOfRange(cost, cost.length-count, cost.length);
      Arrays.sort(curr);
      for(int i=0; i<curr.length-1; i++){
        res += curr[i];
      }
    }

    return res;
  }
}

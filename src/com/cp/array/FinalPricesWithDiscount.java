package com.cp.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FinalPricesWithDiscount {

  public static void main(String[] args) {
    int[] a = {8,4,6,2,3};
    System.out.println(Arrays.toString(new FinalPricesWithDiscount().finalPrices(a)));
  }

  public int[] finalPrices(int[] A) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < A.length; i++) {
      while (!stack.isEmpty() && A[stack.peek()] >= A[i])
        A[stack.pop()] -= A[i];
      stack.push(i);
    }
    return A;
  }

  public int[] finalPrices1(int[] prices) {
    Stack<int[]> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();
    int n = prices.length;
    for(int i=0; i < n; i++){
      while(!stack.isEmpty() && stack.peek()[0] >= prices[i])
        map.put(stack.pop()[1], prices[i]);
      stack.push(new int[]{prices[i], i});
    }
    int[] res = prices.clone();
    for(Integer i : map.keySet()){
      res[i] = prices[i] - map.getOrDefault(i, 0);
    }
    return res;
  }
}

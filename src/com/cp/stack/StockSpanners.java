package com.cp.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanners {
  public static void main(String[] args) {
    StockSpanners s = new StockSpanners();
    //[100],[80],[60],[70],[60],[75],[85]]
    System.out.println(s.next(100));
    System.out.println(s.next(80));
    System.out.println(s.next(60));
    System.out.println(s.next(70));
    System.out.println(s.next(60));
    System.out.println(s.next(75));
    System.out.println(s.next(85));
  }

  Stack<Integer> stack = new Stack<>();
  List<Integer> res = new ArrayList<>();

  public int next(int price) {
    int count = 1;
    while(!stack.isEmpty() && res.get(stack.peek()) <= price){
      count += res.get(stack.pop());
    }
    res.add(count);
    stack.push(res.size() -1);
    return count;
  }
}

package com.hotel.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RoboticsChallenge {
  public static void main(String[] args) {
    List<String> str =new ArrayList<>();
    str.add("5");
    str.add("-2");
    str.add("4");
    str.add("Z");
    str.add("X");
    str.add("9");
    str.add("+");
    str.add("+");
    List<String> str1 =new ArrayList<>();
    str1.add("+");
    str1.add("X");
    str1.add("g");
    System.out.println(new RoboticsChallenge().totalScore(8, str1));
  }

  public int totalScore(int num, List<String> blocks)
  {
    // WRITE YOUR CODE HERE
    Stack<Integer> stk = new Stack<>();
    stk.push(0);
    stk.push(0);
    for(String s : blocks){
      switch (s) {
        case "+":
          int l = stk.pop();
          int p = stk.peek();
          stk.push(l);
          stk.push(l + p);
          break;
        case "X":
          stk.push(2 * stk.peek());
          break;
        case "Z":
          stk.pop();
          break;
        default:
          stk.push(Integer.valueOf(s));
          break;
      }
    }
    int res = 0;
    while(!stk.isEmpty()){
      res += stk.pop();
    }
    return res;
  }

  public int totalScore1(int num, List<String> blocks)
  {
    // WRITE YOUR CODE HERE
    Stack<Integer> stk = new Stack<>();
    stk.push(0);
    stk.push(0);
    for(String s : blocks){
      if(s.equals("+")){
        int l =stk.pop();
        int p = stk.peek();
        stk.push(l);
        stk.push(l+p);
      }
      else if(s.equals("X")){
        stk.push(2 * stk.peek());
      }
      else if(s.equals("Z")){
        stk.pop();
      }
      else{
        stk.push(Integer.valueOf(s));
      }
    }
    int res = 0;
    while(!stk.isEmpty()){
      res += stk.pop();
    }
    return res;
  }
}

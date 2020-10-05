package com.cp.stack;

import javafx.util.Pair;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
  public static void main(String[] args) {
    System.out.println();
  }

  public String removeDuplicates(String s, int k) {
    Stack<Pair<Character, Integer>> stack = new Stack<>();
    for(char c: s.toCharArray()){
      if(stack.isEmpty() || stack.peek().getKey() != c){
        stack.push(new Pair<>(c, 1));
      }
      else{
        var p = stack.pop();
        if(p.getValue() != k)
          stack.push(new Pair<>(c, p.getValue() + 1));
      }
    }
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()){
      var p =stack.pop();
      sb.append(String.valueOf(p.getKey()).repeat(p.getValue()));
    }
    return sb.reverse().toString();
  }
}

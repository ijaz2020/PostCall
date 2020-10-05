package com.cp.stack;

import java.util.Stack;

public class checkValidString {
  public static void main(String[] args){
    System.out.println(new checkValidString().checkValidString("((*)(*))((*"));
  }
//**((*
  public boolean checkValidString(String s) {
    Stack<Character> stack = new Stack<>();
    int star = 0;
    for(char c: s.toCharArray()){
      if( c== '(') stack.push(c);
      else if( c == ')'){
        if(!stack.isEmpty() && stack.peek() == '(' ) stack.pop();
        else if(star > 0) star--;
        else return false;
      }
      else star++;
    }
    return stack.isEmpty() || stack.size() <= star;
  }
}

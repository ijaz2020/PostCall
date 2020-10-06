package com.cp.string;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

public class DecryptPass {
  public static void main(String[] args) {
    System.out.println(new DecryptPass().decryptPassword("51Pa*0Lp*0e"));
  }

  public String decryptPassword(String s) {
    // Write your code here
    int n = s.length();
    Stack<Character> stk = new Stack<>();
    char[] ch = s.toCharArray();
    int i=0;
    while(i < n){
      if(Character.isDigit(ch[i])){
        stk.push(ch[i++]);
      }
      else
        break;
    }
    Stack<Character> aq = new Stack<>();
    for(int j=i; j <n; j++){
      if(aq.isEmpty()){
        aq.push(ch[j]);
      }else{
        if(ch[j] == '*'){
          char o1 = aq.pop(), t2 = aq.pop();        // 51Pa*0Lp*0e
          aq.push(o1);
          aq.push(t2);
        }
        else if(ch[j] == '0'){
          aq.push(stk.pop());
        }
        else{
          aq.push(ch[j]);
        }
      }
    }
    Iterator<Character> it = aq.iterator();
    StringBuilder sb = new StringBuilder();
    while(it.hasNext()){
      sb.append(it.next());
    }
    return sb.toString();
  }
}

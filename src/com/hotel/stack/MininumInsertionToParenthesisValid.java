package com.hotel.stack;



public class MininumInsertionToParenthesisValid {
  public static void main(String[] args) {
    String s = "())(())))";
    System.out.println(new MininumInsertionToParenthesisValid().minInsertions(s));
  }

  public int minInsertions(String s) {
    char[] chars = s.toCharArray();
    int need = 0, right =0;
    for(char c: chars){
      if(c ==')'){
        if(need == 0){
          right++;
        }
        else{
          need--;
        }
      }
      else{
        need +=2;
      }
    }
    return need + ( (right & 1) == 1 ? (right/2 + 2): right/2);
  }
}

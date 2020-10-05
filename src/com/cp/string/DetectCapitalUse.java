package com.hotel.string;

public class DetectCapitalUse {
  public static void main(String[] args) {
    System.out.println(new DetectCapitalUse().detectCapitalUse("Google"));
  }

  public boolean detectCapitalUse(String word) {
    int small = 0, big = 0, l = word.length();
    for(char c : word.toCharArray()){
      int n = c - 'A';
      small += n  > 25 ? 1 : 0;
      big   += n <= 25 ? 1 : 0;
    }
    return l ==0 || small == l || big == l || (small == l-1 && word.charAt(0) -'A' <= 25);
  }
}

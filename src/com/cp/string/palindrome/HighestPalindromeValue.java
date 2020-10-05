package com.hotel.string.palindrome;

import java.util.HashSet;
import java.util.Set;

public class HighestPalindromeValue {
  public static void main(String[] args) {
    System.out.println(highestValuePalindrome("777", 3, 0));
  }

  //992299
  static String highestValuePalindrome(String s, int n, int k) {
    char[] chars = s.toCharArray();
    int l =0, r =n-1;
    Set<Integer> index = new HashSet<>();
    while (l < r && k > 0){
      if(chars[l] != chars[r]){
        k--;
        chars[l] = chars[r] = (char)Math.max(chars[l] - '0', chars[r] - '0');
        index.add(l);
      }
      l++;
      r--;
    }
    if(k < 0) return "-1";
    l = 0; r = n-1;
    while(l < r && k > 0){
      if(chars[l] != '9' && (k > 1 || index.contains(l))){
        chars[l] = chars[r] = '9';
        k--;
        if(!index.contains(l)){
          k--;
        }
      }
      l++;
      r--;
    }
    if( (n & 1) == 1 && k >=1){
      chars[n>>1] = '9';
    }
    return new String(chars);
  }
}

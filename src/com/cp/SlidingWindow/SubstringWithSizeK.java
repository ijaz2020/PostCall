package com.cp.SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWithSizeK {
  public static void main(String[] args) {
    System.out.println(new SubstringWithSizeK().substringWithK("abcabc", 3));
    System.out.println(new SubstringWithSizeK().substringWithK("awaglknagawunagwkwagl", 4));
  }

  List<String> substringWithK(String s, int k){
    Set<String> res = new HashSet<>();
    int i=0, j = 0, n = s.length();
    int[] chars = new int[26];
    while (j < n){
      int c = s.charAt(j)-'a';
      chars[c]++;
      while(chars[c] > 1 || j-i>k){
        chars[s.charAt(i++)-'a']--;
        if(j-i == k){
          res.add(s.substring(i, j));
        }
      }
      j++;
      if(j-i == k){
        res.add(s.substring(i, j));
      }
    }
    return new ArrayList<>(res);
  }
}

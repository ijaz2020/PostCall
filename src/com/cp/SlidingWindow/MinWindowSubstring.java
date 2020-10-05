package com.hotel.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

  public static void main(String[] args) {
    System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
  }

  public String minWindow(String s, String t) {
    String min = s+"a";
    Map<Character, Integer> map = new HashMap<>();
    for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) +1);
    int m = s.length(), st = 0, e =0, count=map.size();
    while(e < m){
      char c = s.charAt(e);
      if(map.computeIfPresent(c, (k, v) -> v-1) != null && map.get(c) == 0)
        count--;
      e++;
      while(count == 0){
        c = s.charAt(st);
        if(map.computeIfPresent(c, (k, v) -> v+1) != null && map.get(c) > 0)
          count++;
        if(e-st < min.length() )
          min = s.substring(st, e);
        st++;
      }
    }
    return min.length() > s.length() ? "" : min;
  }
}

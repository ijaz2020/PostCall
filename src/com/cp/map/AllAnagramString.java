package com.hotel.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramString {
  public static void main(String[] args) {
    System.out.println(new AllAnagramString().findAnagrams("aabcdaabc", "aabc"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int n = s.length(), m = p.length();
    if( m > n) return res;
    Map<Character, Integer> map = new HashMap<>();
    for(char c : p.toCharArray())  map.put(c, map.getOrDefault(c, 0) +1);
    int count = map.size();
    int st = 0, e = 0;
    while(e < n){
      char c = s.charAt(e);
      if(map.containsKey(c)){
        map.put(c, map.get(c) - 1);
        if(map.get(c) == 0)
          count--;
      }
      e++;
      while(count == 0){
        char a = s.charAt(st);
        if(map.containsKey(a)){
          map.put(a, map.get(a) + 1);
          if(map.get(a) > 0)
            count++;
        }
        if(e-st == m){
          res.add(st);
        }
        st++;
      }
    }
    return res;
  }
}

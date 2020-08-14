package com.hotel.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestDupString {
  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>();
    System.out.println(new LongestDupString().longestDupSubstring("banana"));
  }
  public String longestDupSubstring(String s) {
    int l = 1, n = s.length(), r = n;
    long mod = 1000000007L;
    String res = "";
    while( l <= r){
      int m = l + (r - l)/2;
      boolean flag = false;
      HashSet<Long> set = new HashSet<>();
      long hash = 0L;
      for(int i=0; i < m; i++){
        hash += (((s.charAt(i) -'a')+1) * (Math.pow(26, m-i-1) % mod)) % mod;
      }
      set.add(hash);
      for(int i=1; i <= n-m; i++){          // b a n a n a
        int j = ( (s.charAt(i-1) - 'a') + 1);
        hash -= ( j * (Math.pow(26, m -1) % mod)) % mod;
        hash += ((s.charAt(i) - 'a'  + 1) * 26) % mod;
        if(hash < 0){
          hash += mod;
        }
        if(!set.add(hash)){
          flag = true;
          res = s.substring( i-m +1,i +1);
        }
      }
      if(flag){
        l = m +1;
      }
      else{
        r = m-1;
      }
    }
    return res;
  }

  public String longestDupSubstring1(String s) {
    int l = 1, r = s.length();
    long modules = Long.MAX_VALUE / 26;
    String res = "";
    while (l <= r) {
      Set<Long> dup = new HashSet<>();
      int m = l + (r - l) / 2, f = 0;
      long hash = 0, pp = 1;
      for (int i = 0; i < m; i++) {
        hash = (26 * hash + (s.charAt(i) - 'a')) % modules;
        pp = (pp * 26) % modules;
      }
      dup.add(hash);
      for (int i = 0; i + m < s.length(); i++) {
        hash = (hash * 26 + (s.charAt(i + m) - 'a') - ((s.charAt(i) - 'a') * pp)) % modules;
        if (hash < 0) {
          hash += modules;
        }
        if (dup.contains(hash)) {
          f = 1;
          res = s.substring(i + 1, i + m + 1);
          break;
        }
        dup.add(hash);
      }
      if (f == 1) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return res;
  }
}

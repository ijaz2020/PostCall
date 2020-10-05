package com.cp.dfs;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"flower","flow","flight"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
  }

  public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";
    String s = strs[0];
    for(String i : strs){
      if(i.length() < s.length()){
        s = i;
      }
    }
    System.out.println(s);
    for(int i=s.length(); i>0; i--){
      if(dfs(s.substring(0, i), 0, strs)){
        return s.substring(0, i);
      }
    }
    return "";
  }

  boolean dfs(String s, int i, String[] strs){
    if(i == strs.length) return true;
    return strs[i].startsWith(s) && dfs(s, i+1, strs);
  }
}

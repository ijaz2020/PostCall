package com.cp.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CancatenationOfAllwords {
  public static void main(String[] args) {
      //"wordgoodgoodgoodbestword"
      //["word","good","best","good"]
    String[] words = {"a"};
    System.out.println(new CancatenationOfAllwords().findSubstring("a", words));
  }

  public List<Integer> findSubstring(String s, String[] words) {
    HashMap<String, Integer> wordMap = new HashMap<>();
    int l = words[0].length(), n =s.length();
    List<Integer> res = new ArrayList<>();
    for(String w : words){
      wordMap.merge(w, 1, Integer::sum);
    }
    if(n < (l * words.length)) return res;

    for(int i=0; i <=n-l ; i++){
      String curr = s.substring(i, i+l);
      if(wordMap.containsKey(curr) && dfs(new HashMap<>(wordMap), i, s, l)){
        res.add(i);
      }
    }
    return res;
  }

  boolean dfs(HashMap<String, Integer> wordMap, int i, String s, int l){
    if(i >= s.length() || i+l > s.length()){
      return false;
    }
    String curr = s.substring(i, i+l);
    if(!wordMap.containsKey(curr)) return false;
    wordMap.put(curr, wordMap.get(curr) -1);
    if(wordMap.get(curr) == 0){
      wordMap.remove(curr);
    }
    return wordMap.size() == 0 || dfs(wordMap, i+l, s, l);
  }
}

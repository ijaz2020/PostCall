package com.hotel.Trie;

import java.util.*;

public class WordBreak {
  public static void main(String[] args) {
      //"cbca"
      //["bc","ca"]
    /*"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
            ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]*/
    List<String> words = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
    String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
      "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//    List<String> words = Arrays.asList("leet", "code"); String s ="leetcode";
    String s1 = "abc";
    List<String> wordDict = new ArrayList<>(){{
            add("bc");
    }};
    System.out.println(new WordBreak().wordBreak(s1, wordDict));
  }

  public boolean wordBreak(String s, List<String> dict) {
    int n = s.length();
    Set<String> set = new HashSet<>(dict);
    boolean[] f = new boolean[n+1];
    f[0] = true;
    for(int i=1; i <= s.length(); i++){
      for(int j=0; j < i; j++){
        if(f[j] && set.contains(s.substring(j, i))){
          f[i] = true;
          break;
        }
      }
    }
    return f[s.length()];
  }

  public boolean wordBreak3(String s, List<String> wordDict) {
    return dfs(s, new HashSet<>(wordDict));
  }

  boolean dfs(String s, Set<String> dict){
    for(int i=1; i <= s.length(); i++){
      if(dict.contains(s.substring(0, i))){
        if(i+1 > s.length() || dfs(s.substring(i), dict)){
          return true;
        }
      }
    }
    return false;
  }

  TrieNode root = new TrieNode();
  public boolean wordBreak2(String s, List<String> wordDict) {
    buildTrie(wordDict);
    return searchTrie(s, 0);
  }

  boolean ans;
  class Trie{
    HashMap<Character, Trie> hm;
    boolean flag;
    Trie(){
      hm = new HashMap();
      flag = false;
    }
  }
  public boolean wordBreak1(String s, List<String> wordDict) {
    Trie trie = new Trie();
    for(String word: wordDict){
      insert(trie, word);
    }
    ans = false;
    boolean []dp = new boolean[s.length()+1];
    rec(s, trie, 0, dp);
    return ans;
  }

  public void insert(Trie trie, String word){
    Trie tmp = trie;
    for(int i=0;i<word.length();i++){
      if(!tmp.hm.containsKey(word.charAt(i))){
        tmp.hm.put(word.charAt(i), new Trie());
      }
      tmp = tmp.hm.get(word.charAt(i));
    }
    tmp.flag = true;
  }

  public void rec(String s, Trie trie, int i, boolean []dp){
    if(dp[i]){
      return ;
    }
    dp[i] = true;
    if(i == s.length()){
      ans = true;
      return ;
    }
    if(!ans){
      ArrayList<Integer> list = search(s.substring(i), trie);
      for(int j=0;j<list.size();j++){
        rec(s, trie, i+list.get(j), dp);
      }
    }
  }

  public ArrayList<Integer> search(String s, Trie trie){
    Trie tmp = trie;
    ArrayList<Integer> ans = new ArrayList();
    for(int i=0;i<s.length();i++){
      if(!tmp.hm.containsKey(s.charAt(i))){
        break;
      }
      tmp = tmp.hm.get(s.charAt(i));
      if(tmp.flag){
        ans.add(i+1);
      }
    }
    return ans;
  }

  boolean searchTrie(String s, int i){
    if(i == s.length()) return true;
    TrieNode head = root;
    for(int j = i; j<s.length(); j++){
      char c = s.charAt(j);
      TrieNode[] child = head.child;
      if(child[c-'a'] == null) return false;
      if(child[c -'a'].isWord && searchTrie(s, j+1)){
          return true;
      }
      head = child[c -'a'];
    }
    return false;
  }

  void buildTrie(List<String> wordDict){
    for(String s : wordDict){
      TrieNode head = root;
      for(char c : s.toCharArray()){
        if(head.child[c-'a'] == null){
          head.child[c -'a'] = new TrieNode();
        }
        head = head.child[c - 'a'];
      }
      head.isWord = true;
    }
  }

  class TrieNode{
    boolean isWord = false;
    TrieNode[] child = new TrieNode[26];
  }
}

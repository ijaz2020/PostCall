package com.hotel.Trie;

import java.util.Arrays;
import java.util.List;

public class LC1408StringMatchingArray {
  public static void main(String[] args) {
    System.out.println();
  }

  TrieNode root = new TrieNode();
  public List<String> stringMatching(String[] words) {
    Arrays.sort(words, (a , b) -> b.length() - a.length());
    for(String s: words)
      processTrie(s);
    return Arrays.asList(words);
  }

  private void processTrie(String s){
    TrieNode current = root;
    for(char c: s.toCharArray()){
      current.children[c -'a'] = new TrieNode();
      current = current.children[c-'a'];
    }
  }

  class TrieNode{
    TrieNode[] children = new TrieNode[26];
  }
}

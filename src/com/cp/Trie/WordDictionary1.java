package com.cp.Trie;

class WordDictionary1 {
  public static void main(String[] args) {
    WordDictionary1 w = new WordDictionary1();
    w.addWord("bad");
    w.addWord("dad");
    w.addWord("mad");
    System.out.println(w.search("pad"));
    System.out.println(w.search("bad"));
    System.out.println(w.search(".ad"));
    System.out.println(w.search("b.."));
  }

  TrieNode root;
  /** Initialize your data structure here. */
  public WordDictionary1() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode head = this.root;
    for(char c : word.toCharArray()){
      if(head.child[c - 'a'] == null){
        head.child[c - 'a'] = new TrieNode();
      }
      head = head.child[c - 'a'];
    }
    head.isWord = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return search(word, root, 0);
  }

  boolean search(String word, TrieNode head, int i){
    if(word.length() == i){
      return head.isWord;
    }
    char c = word.charAt(i);
    boolean result = false;
    if(c == '.'){
      for(TrieNode trie : head.child){
        if(trie == null) continue;
        result = result || search(word, trie, i+1);
      }
    }else if(head.child[c-'a'] != null){
      result = search(word, head.child[c-'a'], i+1);
    }
    return result;
  }

  class TrieNode{
    boolean isWord;
    TrieNode[] child = new TrieNode[26];
  }
}

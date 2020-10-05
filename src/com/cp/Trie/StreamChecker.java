package com.cp.Trie;

import java.util.ArrayList;
import java.util.List;

public class StreamChecker {
    public static void main(String[] args){
        String[] strings = {"cd","f","kl"};
        StreamChecker streamChecker = new StreamChecker(strings); // init the dictionary.
        streamChecker.query('a');          // return false
        streamChecker.query('b');          // return false
        streamChecker.query('c');          // return false
        streamChecker.query('d');          // return true, because 'cd' is in the wordlist
        streamChecker.query('e');          // return false
        streamChecker.query('f');          // return true, because 'f' is in the wordlist
        streamChecker.query('g');          // return false
        streamChecker.query('h');          // return false
        streamChecker.query('i');          // return false
        streamChecker.query('j');          // return false
        streamChecker.query('k');          // return false
        streamChecker.query('l');          // return true, because 'kl'
        System.out.println();
    }

    Trie root = new Trie(0);
    List<Character> charList = new ArrayList<>();
    class Trie{
        int val;
        Trie[] children = new Trie[26];
        boolean isWord = false;
        Trie(int val){
            this.val = val;
        }
    }
    public StreamChecker(String[] words) {
        for(String s : words)
            buildTrie(s);
    }

    public boolean query(char letter) {
        charList.add(letter);
        return searchTrie(charList);
    }

    boolean searchTrie(List<Character> charList){
        Trie current = root;
        for(int i= charList.size()-1; i>= 0; i--){
            if(current.children[charList.get(i) -'a'] == null)
                return false;
            current = current.children[charList.get(i) -'a'];
            if(current.isWord) return true;
        }
        return false;
    }

    void buildTrie(String word){
        int n = word.length();
        char[] chars = word.toCharArray();
        Trie current = root;
        for(int i = n-1; i >= 0; i--){
            int index = word.charAt(i)- 'a';
            if(current.children[index] == null)
                current.children[index] = new Trie(index);
            current = current.children[index];
        }
        current.isWord = Boolean.TRUE;
    }
}

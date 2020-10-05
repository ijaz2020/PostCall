package com.cp.Trie;

class Trie {
/*    private TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = checkStringPresence(word);
        return current != null && current.isWord;
    }

    *//** Returns if there is any word in the trie that starts with the given prefix. *//*
    public boolean startsWith(String prefix) {
        TrieNode current = checkStringPresence(prefix);
        return current !=null;
    }

    private TrieNode checkStringPresence(String word){
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for(char c: chars){
            if(current.children[c - 'a'] == null) return null;
            current = current.children[c-'a'];
        }
        return  current;
    }*/

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            Node n = curr.children[c-'a'];
            if( n == null ) return false;
            curr = n;
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c: prefix.toCharArray()){
            Node n = curr.children[c-'a'];
            if( n == null ) return false;
            curr = n;
        }
        return true;
    }

    class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    public static void main(String[] args){
        Trie m = new Trie();
        m.insert("app");
        m.insert("apple");
        m.insert("beer");
        m.insert("add");
        m.insert("jam");
        m.insert("rental");
        m.search("apps");
        m.search("app");
        m.search("ad");
        m.search("applepie");
        m.search("rest");
        m.search("jan");
        m.search("rent");
        m.search("beer");
        m.search("jam");
        m.startsWith("apps");
        m.startsWith("app");
        m.startsWith("ad");
        m.startsWith("applepie");
        m.startsWith("rest");
        m.startsWith("jan");
        m.startsWith("rent");
        m.startsWith("beer");
        m.startsWith("jam");
    }
}

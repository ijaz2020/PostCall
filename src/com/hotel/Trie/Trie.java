package com.hotel.Trie;

class Trie {
    private TrieNode root;
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

    /** Returns if there is any word in the trie that starts with the given prefix. */
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
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}

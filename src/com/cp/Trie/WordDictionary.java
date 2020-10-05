package com.cp.Trie;

public class WordDictionary {
    public static void main(String[] args) {

        /*["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]*/
        /*Output:
[null,null,null,null,null,true,false,null,true,true,false,true,true,true]
        Expected:
[null,null,null,null,null,false,false,null,true,true,false,false,true,false]*/

        WordDictionary w =  new WordDictionary();
        w.addWord("at");
        w.addWord("and");
        w.addWord("an");
        w.addWord("and");
        w.addWord("bat");
        System.out.println(w.search("a"));
        System.out.println(w.search("b."));
        System.out.println(w.search("."));
    }

    TrieNode root = null;

    static class TrieNode {
        char c;
        TrieNode[] children = new TrieNode[26];
        String item= "";
        TrieNode(char c) {
            this.c = c;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode('0');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode current = this.root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode(c);
            current = current.children[c - 'a'];
        }
        current.item = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(chars, 0, this.root);
    }

    public boolean search(char[] chars, int index, TrieNode current) {
        if (index == chars.length) return !current.item.equals("");;
        if (chars[index] != '.') {
            if (current.children[chars[index] - 'a'] != null)
                return search(chars, index + 1, current.children[chars[index] - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    if (search(chars, index + 1, current.children[i]))
                        return true;
                }
            }
        }
        return false;
    }
}

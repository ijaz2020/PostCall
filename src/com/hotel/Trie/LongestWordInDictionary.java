package com.hotel.Trie;

public class LongestWordInDictionary {
    public static void main(String[] args){
        String[] w = {"w","wo","wor","worl", "world"};
        System.out.println(new LongestWordInDictionary().longestWord(w));
    }
    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public String longestWord(String[] words) {
        buildTrie(words);
        String result = "";
        dfs(this.root, new StringBuilder(""), result);
        return result;
    }

    void dfs(TrieNode root, StringBuilder current, String result) {
        if (current.length() > result.length())
            result = current.toString()+"";
        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null || root.children[i].word == null) continue;
            current.append((char)(i + 'a'));
            dfs(root.children[i], current, result);
            current.setLength(current.length() - 1);
        }
    }

    void buildTrie(String[] words) {
        for (String s : words) {
            TrieNode current = this.root;
            for (char c : s.toCharArray()) {
                if (current.children[c - 'a'] == null)
                    current.children[c - 'a'] = new TrieNode();
                current = current.children[c - 'a'];
            }
            current.word = s;
        }
    }
}

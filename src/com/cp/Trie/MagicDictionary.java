package com.hotel.Trie;

class MagicDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode(' ');
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict){
            TrieNode word = root;
            char[] chars = s.toCharArray();
            for(char c: chars){
                if(word.children[c-'a'] == null)
                    word.children[c -'a'] = new TrieNode(c);
                word = word.children[c -'a'];
            }
            word.isWord = Boolean.TRUE;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        TrieNode traverseNode = root;
        for(char c: chars){
            if( traverseNode.children[c - 'a'] ==  null || traverseNode.children[c - 'a'].val != c )
                count++;
            traverseNode = traverseNode.children[c - 'a'];
        }
        return count == 1 && traverseNode.isWord == Boolean.TRUE;
    }

    public static void main(String[] args){
        MagicDictionary m = new MagicDictionary();
        String[] sArr = {"hello", "leetcode"};
        m.buildDict(sArr);
//        System.out.println(m.search("hello"));
        System.out.println(m.search("hhllo"));
//        System.out.println(m.search("hell"));
//        System.out.println(m.search("leetcoded"));
//        System.out.println(m.search("helloy"));
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

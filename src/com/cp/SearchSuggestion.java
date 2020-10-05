/*
package com.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class TrieNode {

    TrieNode[] children;
    boolean isTerminating;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        this.isTerminating = false;
        this.count = 0;
    }
}

public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void add(TrieNode root, String word) {

        if (word.length() == 0) {
            root.isTerminating = true;
            root.count++;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode();
            root.children[childIndex] = child;
        }

        add(child, word.substring(1));

    }

    public void add(String word) {
        add(root, word);
    }

    static int c = 0;

    public void getList(TrieNode root, String ans, List<String> l) {

        if (root.isTerminating) {
            for (int j = 0; j < root.count; j++) {
                l.add(ans);
                c++;
                if (c == 3) return;
            }
        }

        for (int j = 0; j < 26; j++) {
            TrieNode child = root.children[j];
            if (child == null) continue;
            getList(child, ans + (char) (97 + j), l);
            if (c == 3) return;
        }

    }

    private List<String> search_helper(TrieNode root, String word, int i, int n) {

        if (i == n) {
            c = 0;
            List<String> l = new ArrayList<>();
            getList(root, word, l);
            return l;
        }

        int child_index = word.charAt(i) - 'a';
        TrieNode child = root.children[child_index];
        if (child == null) return new ArrayList<>();

        return search_helper(root.children[child_index], word, i + 1, n);

    }

    List<String> search(String word) {
        return search_helper(root, word, 0, word.length());
    }
}


class SearchSuggestion {
    public static void main(String[] args) {
        SearchSuggestion sol = new SearchSuggestion();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(sol.suggestedProduct(products, searchWord));
    }

    private List<List<String>> suggestedProducts(String[] products, String searchWord) {

        int m = searchWord.length();
        Trie t = new Trie();

        List<List<String>> ans = new ArrayList<>();

        for (String product : products) t.add(product);

        String prefix = "";

        for (int i = 0; i < m; i++) {
            prefix += searchWord.charAt(i);
            ans.add(t.search(prefix));
        }

        return ans;

    }

    public List<List<String>> suggestedProduct(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
}
*/

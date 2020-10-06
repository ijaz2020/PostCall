package com.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsequence {
    //  s = "abc", t = "ahbgdc"
    // a - 0
    // h - 1
    // b - 2
    // g - 3
    // d - 4
    // c - 5
    public static void main(String[] args){ System.out.println(new Subsequence().isSubsequence("abc" , "bahbgdca"));
       List<Integer> integers = new ArrayList<>();
       integers.add(1);integers.add(2);integers.add(5);
        System.out.println(Collections.binarySearch(integers, 6));
    }

    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        for(int i=0; i < t.length(); i++) {
            charMap.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }
        int k = 0;
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            List<Integer> list = charMap.get(c);
            if(list == null) return false;
            int res = Collections.binarySearch(list, k);
            if (res < 0) res = -res - 1;
            if(res == list.size()) return false;
            k = list.get(res)+1;
        }
        return true;
    }
    public static boolean isSubsequence1(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }



}

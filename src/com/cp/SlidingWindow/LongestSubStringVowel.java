package com.hotel.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubStringVowel {
    public static void main(String[] args){
        /*Input: s = "eleetminicoworoep"
        Output: 13
        Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.*/
        System.out.println(new LongestSubStringVowel().findTheLongestSubstring("eleetminicoworoep"));
    }


    char[] c_m = {1,0,0,0,2,0,0,0,4,0,0,0,0,0,8,0,0,0,0,0,16,0,0,0,0,0};
    public int findTheLongestSubstring(String s) {
        int mask = 0, res = 0;
        int[] m = new int[32];
        Arrays.fill(m, -1);
        for (int i = 0; i < s.length(); ++i) {
            mask ^= c_m[s.charAt(i) - 'a'];
            if (mask != 0 && m[mask] == -1)
                m[mask] = i;

            res = Math.max(res, i - m[mask]);
        }
        return res;
    }

    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
    int[] pow = { 1, 2, 4, 8, 16 };
    public int findTheLongestSubstring3(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, code = 0, ans = 0;
        boolean[] odd = new boolean[5];

        HashMap<Integer, Integer> encoded = new HashMap<>();
        encoded.put(code, -1);
        for(int i=0; i<n; ++i) {
            for(int j=0; j<5; ++j) {
                if(arr[i] == vowels[j]) {
                    code += (odd[j]?-1:1)*pow[j];
                    odd[j] = !odd[j];
                    break;
                }
            }
            if(encoded.containsKey(code))
                ans = Math.max(i-encoded.get(code), ans);
            else encoded.put(code, i);
        }

        return ans;
    }

    HashMap<Character, Integer> vowelToIndex = new HashMap<>() {
        {
            put('a', 0);
            put('e', 1);
            put('i', 2);
            put('o', 3);
            put('u', 4);
        }
    };
    public int findTheLongestSubstring4(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int best = 0, curr = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                int diff = s.charAt(i) - 'a';
                curr ^= (1 << diff);
            }
            map.putIfAbsent(curr, i);
            best = Math.max(best, i - map.get(curr));
        }
        return best;
    }
    public int findTheLongestSubstring2(String s) {
        HashMap<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int state = 0, maxLen = 0;
        for(int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if(vowelToIndex.containsKey(cur)) {
                // flip the digits of the state. 1-> 0 or 0 -> 1
                int digit = vowelToIndex.get(cur); // ideally we can do only one lookup.
                state ^= (1 << digit);
            }

            stateToIndex.putIfAbsent(state, i);
            maxLen = Math.max(maxLen, i - stateToIndex.get(state));
        }

        return maxLen;

    }

    public int findTheLongestSubstring1(String s) {
        if(s.length() < 1) return s.length();
        Set<Character> set = new HashSet<>(){{
            add('a');add('e');add('i');add('0');add('u');
        }};
        char[] chars = s.toCharArray();
        int vowelCount = 0, res = 0, n= chars.length;
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        resultList.add(0);
        for (int i = 0; i < n; i++) {
            vowelCount += set.contains(chars[i]) ? 1 : 0;
            if(set1.add(vowelCount) && vowelCount %2 == 0)
                resultList.add(i);
        }
        for(int i=0; i< resultList.size()-1;i++){
            res = Math.max(res, resultList.get(i+1) - resultList.get(i));
        }
        return res;
    }
}

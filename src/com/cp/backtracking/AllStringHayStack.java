package com.cp.backtracking;

import java.sql.Array;
import java.util.*;

public class AllStringHayStack {
    public static void main(String[] args){
        Set<Character> chars = new HashSet<>(Arrays.asList('a', 'b')) ;
        System.out.println(new AllStringHayStack().substring("cab", chars));
    }

    public int allSubstrings(String s, char[] alphabets) {
        int map[] = new int[128];
        int total = alphabets.length;
        int res = 0, start = 0;
        for(char c : alphabets) {
            map[c]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(map[s.charAt(i)]-- > 0) {
                total--;
            }
            while(total == 0) {
                if(++map[s.charAt(start++)] > 0) {
                    total++;
                }
            }
            res += i-start+1;
        }
        return res;
    }
    int substring(String haystack , Set<Character> alphabet){
        int res = 0;
        int start =0;
        Map<Character,Integer> count = new LinkedHashMap<Character,Integer>();
        for(int i =0 ; i < haystack.length();i++){
            if(alphabet.contains(haystack.charAt(i))){
                count.put(haystack.charAt(i) , i);
                if(count.size() == alphabet.size()){
                    Character c = count.keySet().stream().findFirst().get();
                    start =  count.get(c) + 1;
                    count.remove(c);
                }
            }
            res += i - start +1;
        }
        return res;
    }
}

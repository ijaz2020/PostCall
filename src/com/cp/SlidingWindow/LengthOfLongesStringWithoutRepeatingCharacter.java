package com.hotel.SlidingWindow;

import java.util.HashSet;

public class LengthOfLongesStringWithoutRepeatingCharacter {
    public static void main(String[] args){
        System.out.println(new LengthOfLongesStringWithoutRepeatingCharacter().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, res = 0, n = s.length();
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        while(j < n){
            while(!set.add(chars[j])){
                set.remove(chars[i++]);
            }
            res = Math.max(res, j++ -i+1);
        }
        return res;
    }
}

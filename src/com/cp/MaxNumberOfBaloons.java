package com.cp;

import java.util.*;

public class MaxNumberOfBaloons {

    public static void main(String arg[]){
        int[] nums= {1,2,3,4};
//        Stack<Integer> s = new Stack<>();
        System.out.println(containsDuplicate(nums));
    }
        public int maxNumberOfBalloons(String text) {

            int[] charMap = new int[26];

            for(char c: text.toCharArray()){
                charMap[c - 'a']++;
            }
            charMap[11] = charMap[11]/2; charMap[14] = charMap[14]/2;
            return Math.min(charMap[0], Math.min(charMap[1], Math.min(charMap[11], Math.min(charMap[14], charMap[13]))));
        }

    public static boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        return nums.length != new HashSet<>(Arrays.asList(nums)).stream().count();
    }
}

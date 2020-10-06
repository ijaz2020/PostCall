package com.cp.string;

import java.util.TreeMap;

public class IncreasingDecreasingString {

    public static void main(String[] args){
        System.out.println(new IncreasingDecreasingString().sortString("leetcode"));
    }
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> charMap = new TreeMap<>();
        for(char c: s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) +1);
        }
        boolean odd = true;
        while (true){
            StringBuilder current = new StringBuilder();
            for(Character c : charMap.keySet()){
                if(charMap.get(c) !=0) {
                    current.append(c);
                    charMap.put(c, charMap.getOrDefault(c, 0) - 1);
//                    if (charMap.get(c) == 0) charMap.remove(c);
                }
            }
            if("".equals(current.toString())) break;
            if(odd){
                sb.append(current);
                odd= false;
            }
            else{
                sb.append(current.reverse());
                odd =true;
            }
        }
        return sb.toString();
    }
}

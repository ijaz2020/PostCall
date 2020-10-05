package com.hotel;

import java.util.Arrays;

public class LongPresses {
    public static void main(String[] args){
        int mask=1, num=566;
        while(mask<num){
            mask=(mask<<1)|1;
        }
        System.out.println(num^mask);
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
    }

    private static boolean isLongPressedName(String s, String t) {
        // int t = typed.length(), n =name.length();
        if(t.length()<s.length()) return false;
        int i,j;
        for(i=0,j=0;j<s.length() ;i++, j++){
            if( i>=t.length() ||t.charAt(i) != s.charAt(j)) return false;
            if(j + 1 >= s.length() || s.charAt(j) != s.charAt(j + 1)){
                while(i+1 < t.length() && t.charAt(i) == t.charAt(i+1))i++;
            }
        }
        return i==t.length();
    }
}

package com.cp;

import java.util.Arrays;

public class ShortestDistanceToCharacter {
    public static void main(String[] args){
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }

    public static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (S.charAt(i) == C)  pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }
}

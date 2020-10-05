package com.cp.string;

import java.sql.Array;
import java.util.Arrays;

public class StringCompression {
    public static void main(String args[]){
        char[] c= {'a','a','a','b','b','a','a'};
        System.out.println(compress(c));
    }
        public static int compress(char[] chars) {
            int current = 1, next = -1;
            char letter = chars[0];
            for (int i = 1; i < chars.length; i++) {
                if (letter == chars[i]) {
                    current++;
                } else {
                    if (current > 1) {
                        next = i - current + 1;
                        if (current / 10 > 0) {
                            chars[next++] = String.valueOf(current / 10).toCharArray()[0];
                        }
                        chars[next++] = String.valueOf(current % 10).toCharArray()[0];
                        for (int j = i; j < chars.length; j++)
                            chars[next++] = chars[j];
                        chars = Arrays.copyOf(chars, next);
                        i--;
                    }
                    current = 1;
                }
                letter = chars[i];
            }
            if (current > 1) {
                next = chars.length - current + 1;
                if (current / 10 > 0) {
                    chars[next++] = String.valueOf(current / 10).toCharArray()[0];
                }
                chars[next++] = String.valueOf(current % 10).toCharArray()[0];
                chars = Arrays.copyOf(chars, next);
            }
            return next == -1 ? chars.length : next;
    }
}

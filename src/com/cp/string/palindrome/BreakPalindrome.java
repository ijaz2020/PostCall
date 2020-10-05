package com.hotel.string.palindrome;

public class BreakPalindrome {
    public static void main(String[] args){
        System.out.println(new BreakPalindrome().breakPalindrome("aa"));
    }

    public String breakPalindrome(String palindrome) {
        char[] chars = palindrome.toCharArray();
        boolean isDone = false;
        for(char start = 'a'; start <='z'; start++){
            if(isDone) break;
            for(int i =0; i < chars.length;i++){
                if(start < chars[i]){
                    chars[i] = start;
                    isDone = true;
                    break;
                }
            }
        }
        if(!isDone) {
            int n = chars.length;
            chars[n-1]++;
        }
        return new String(chars);
    }
}

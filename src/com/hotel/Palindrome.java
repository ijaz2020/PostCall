package com.hotel;

public class Palindrome {

    public static void main(String[] args){
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlucpuufxoohdfpgjdmysgvhmvf" +
                "fcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome(String s) {
        int i=0, j = s.length()-1, k =1;
        while( i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++; j--;
            }
            else{
                k--;
                if(k < 0) return false;
                if(i+1 <=j && s.charAt(i+1) == s.charAt(j)) i++;
                else if(i <= j-1 && s.charAt(i) == s.charAt(j-1)) j--;
                else return false;
            }
        }
        return true;
    }
}

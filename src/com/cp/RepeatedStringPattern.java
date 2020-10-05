package com.hotel;

public class RepeatedStringPattern {
    public static void main(String args[]){
        System.out.println(new RepeatedStringPattern().repeatedSubstringPattern("ababab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = n/2; i>0; i--){
            if(n%i == 0 && s.substring(0, i).repeat(n/i).equals(s)){
                return true;
            }
        }
        return false;
    }
}

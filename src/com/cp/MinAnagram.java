package com.cp;

public class MinAnagram {
    public static void main(String arg[]){
        System.out.println(minAnagram("read" , "digy" ));
    }

    static int minAnagram(String s, String t){
        if(s.length() != t.length()) return -1;
        int[] count = new int[26];
        int total = 0;

        for(int i=0; i< s.length();i++){
            count[s.charAt(i) - 'a'] ++;
        }

        for(int i=0; i < t.length();i++){
            count[t.charAt(i) - 'a'] --;
            if(count[t.charAt(i) - 'a'] < 0){
                total ++;
            }
        }

        return total;
    }
}


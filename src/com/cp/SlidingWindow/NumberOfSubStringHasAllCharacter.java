package com.cp.SlidingWindow;

public class NumberOfSubStringHasAllCharacter {
    public static void main(String[] args){
        System.out.println(new NumberOfSubStringHasAllCharacter().numberOfSubstrings1("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0, j=0, i=0, n = chars.length;
        int[] count ={0, 0, 0};
        while(j < n){
            count[chars[j++] - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                count[chars[i++] - 'a']--;
            }
            res += i;
        }
        return res;
    }
    public int numberOfSubstrings1(String s) {
        char[] chars = s.toCharArray();
        int res = 0, j=0, i=0, n = chars.length;
        int[] count ={0, 0, 0};
        while(j < n){
            count[chars[j++] - 'a']++;
            if(count[0] > 0 && count[1] > 0 && count[2] > 0){
                res += n-j+1;
                count[chars[i++] - 'a']--;
            }
        }
        return res;
    }
}

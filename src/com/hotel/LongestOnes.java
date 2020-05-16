package com.hotel;


import java.util.Arrays;

public class LongestOnes {

    private static int longest(int a[], int k){

        int i=0, j=0;
        while(i < a.length){
            if(a[i] == 0)
                k--;
            if(k <0){
                if(a[j] == 0) {
                    k++;
                }
                j++;
            }
            i++;
        }
        return i-j;
    }

    public static int longestOnes(int[] A, int K) {
        if(A.length == 0) return 0;

        int s=0, e=0, max=0, zeros = 0;
        boolean childFlag = false;
        while( e < A.length){
            if(A[e] == 0 && !childFlag){
                zeros++;
            }
            if(zeros <= K){
                e++;
                childFlag= false;
            }
            else{
                if(A[s] == 0){
                    zeros--;
                }
                s++;
                childFlag = true;
            }
            max = Math.max(max, e-s);
        }
        return max;
    }

    public static int firstUniqChar(String s) {
        int n= s.length();
        if(n == 0) return -1;
        if(n == 1) return 0;
        int[] map = new int[26];

        for(int i=0; i<n;i++){
            map[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<n;i++){
            if(map[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static int characterReplacement(String s, int k) {

        int[] map = new int[26];
        if(s.length() == 0 ) return 0;
        int i=0, j=0, maxCount = 0, maxLen = 0;
        while (i < s.length()){
            map[s.charAt(i) - 'A']++;
            maxCount = Math.max(map[s.charAt(i) - 'A'], maxCount);
            while(i-j+1 - maxCount > k){
                map[s.charAt(i) - 'A']--;
                j++;
            }

            maxLen = Math.max(maxLen, i-j+1);
            i++;
        }

        return maxLen;
    }

    public static int[] plusOne(int[] digits) {

        if(digits.length == 0) return null;

        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i] =0;
            }
        }

        int[] d = new int[digits.length+1];
        d[0] = 1;

        return d;
    }

    public static void main(String arg[]){
        int[] a ={1,1,1,0,0,0,1,1,1,1,0};
//        System.out.println(longestOnes(a, 2));
        System.out.println(firstUniqChar("lovbeleetcode"));
//        System.out.println(characterReplacement("AABABBA", 1));
        int[] n = {9,9,9};
//        System.out.println(Arrays.toString(plusOne(n)));
    }
}

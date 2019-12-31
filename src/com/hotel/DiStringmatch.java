package com.hotel;

import java.util.Arrays;
import java.util.TreeSet;

public class DiStringmatch {
    public static void main(String[] args){
        TreeSet<Integer> treeSet =  new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.ceiling(2);
        treeSet.floor(2);
        System.out.println(Arrays.toString(diStringMatch("I")));
    }

    public static int[] diStringMatch(String s) {
        int n = s.length();
        int i=0, j=n, k=0;
        int[] result = new int[n+1];
        for(; k<n;k++){
            if(s.charAt(k) == 'I')
                result[k] = i++;
            else if(s.charAt(k) == 'D')
                result[k] = j--;
        }
        while (i<=j){
            if(s.charAt(n-1) == 'I')
                result[k] = i++;
            else if(s.charAt(n-1) == 'D')
                result[k] = j--;
        }
        return result;
    }
}

package com.hotel.string;

public class MergeString {
    public static void main(String[] args){
        System.out.println(new MergeString().mergeStrings("super", "tower"));
    }

    String mergeStrings(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while(i < c1.length && j < c2.length){
            if(c1[i] < c2[j]) sb.append(c1[i++]);
            else sb.append(c2[j++]);
        }
        while(i < c1.length){
            sb.append(c1[i++]);
        }
        while(j < c2.length){
            sb.append(c2[j++]);
        }
        return sb.toString();
    }
}

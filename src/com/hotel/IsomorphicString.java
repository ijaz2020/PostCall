package com.hotel;

public class IsomorphicString {
    public static void main(String[] args){
        System.out.println(isIsomorphic("agg", "ldd"));
    }

        public static boolean isIsomorphic(String s1, String s2) {
            int[] m = new int[512];
            for (int i = 0; i < s1.length(); i++) {
                if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
                m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
            }
            return true;
        }
}

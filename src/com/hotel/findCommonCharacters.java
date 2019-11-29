package com.hotel;

import java.util.*;
import java.util.Arrays;

public class findCommonCharacters {
    public static void main(String[] args){
        String[] A ={"bella","label","roller"};
        System.out.println(commonChars(A));
    }
    public static List<String> commonChars(String[] A) {
        Set<String> set = new HashSet<>();
//            if(A.length ==1) return new Arrays.asList(A[0]);

        for(int i=0;i<A[0].length();i++) set.add(String.valueOf(A[0].charAt(i)));

        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[i].length();j++){
                if(!set.contains(String.valueOf(A[i].charAt(i)))) set.remove(String.valueOf(A[i].charAt(i)));
            }
        }

        return new ArrayList<>(set);
    }
}

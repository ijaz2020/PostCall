package com.hotel;

import java.util.Set;
import java.util.TreeSet;

public class CandyCrush {
    public static void main(String[] args){
        String candy= "0011001110000011";
        TreeSet<Integer> set = new TreeSet<>(){{
           add(1);
        }};
        //00 110011100 00 011
        System.out.println(new CandyCrush().candyCrush(candy));
    }

    int candyCrush(String s){
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length];
        for(int i=0; i<chars.length;i++){
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        int result =0;

        return result;
    }
}

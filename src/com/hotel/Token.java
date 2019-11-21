package com.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Token {
    public static void main(String[] args){
        StringTokenizer stringTokenizer = new StringTokenizer("He is a very very good boy, isn't he?");
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }

        List<Integer> arr= new ArrayList<>();
        arr.add(13);
        for(Integer a : arr){
            System.out.println(arr.indexOf(a));
        }
    }
}

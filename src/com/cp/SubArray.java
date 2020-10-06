package com.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubArray {

    public static void main(String arg[]){
        int[] arr = {1,2,3};
        List<List<Integer>> results = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        findSubArray(arr, 0, stack, results);
        System.out.println(results);
        System.out.println(twoStrings("hello", "world"));
    }

    private static void findSubArray(int[] arr, int index, Stack<Integer> current, List<List<Integer>> results){
        results.add(new ArrayList<>(current));

        for(int i=index; i < arr.length; i++){
            current.push(arr[i]);
            findSubArray(arr, i+1, current, results);
            current.pop();
        }
    }

    static String twoStrings(String s1, String s2) {
        String[] s1Arr = s1.split("");
        for(String s: s1Arr){
            if(s.contains(s2)){
                return "YES";
            }
        }
        return "NO";
    }

}



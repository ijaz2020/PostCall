package com.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public static void  main(String[] args){
        char[] nums ={'a','b','c', 'd'};
        List<List<Character>> inteerList = subsets(nums);
        System.out.println(inteerList.size());
        System.out.println(inteerList);
    }
    public static List<List<Character>> subsets(char[] nums) {
        List<List<Character>> result = new ArrayList<>();

        recurse(result, nums, new Stack<>(), 0);

        return result;
    }

    private static void recurse(List<List<Character>> result, char[] nums, Stack path, int position) {
//        if(position == nums.length) {
            result.add(new ArrayList<>(path));
//            return;
//        }
        for(int i=position; i< nums.length;i++) {
            path.push(nums[i]);

            recurse(result, nums, path, i + 1);

            path.pop();
        }

//        recurse(result, nums, path, position + 1);
    }
}

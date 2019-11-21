package com.hotel;

import java.util.*;

public class NextGreaterElement {

    public static  void main(String args[]){
        int[] findNums= {4,1,2}, nums = {1,3,4,2};
        Map<String, Integer> count = new HashMap<>();
        Collections.max(count.entrySet(), Map.Entry.comparingByValue());
        System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));
    }
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}

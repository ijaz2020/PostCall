package com.hotel;

import java.util.*;

public class NextGreaterElement {

    public static  void main(String args[]){
       /* int[] findNums= {4,1,2}, nums = {1,3,4,2};
        Map<String, Integer> count = new HashMap<>();
        Collections.max(count.entrySet(), Map.Entry.comparingByValue());
        System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));*/
        int[] A = {5,6,4,3,2,1};
        List<Integer> a = new ArrayList<>();
        System.out.println(Arrays.toString(nextGreaterElementII(A)));
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
    public static int[] nextGreaterElementII(int[] nums) {
        int n = nums.length, next[] = new int[n], max = 0;
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            if(i>n && stack.size() ==1 && nums[stack.peek()] == max) break;
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) {
                stack.push(i);
                max = Math.max(max, nums[i]);
            }

        }
        return next;
    }
}

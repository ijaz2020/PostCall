package com.hotel;

import java.util.Stack;

public class Rangesum {
        private int[] sums;

        public Rangesum(int[] nums) {
            if(nums.length != 0){
                sums = new int[nums.length];

                sums[0] = nums[0];
                for(int i=1; i<nums.length; i++){
                    sums[i] = nums[i] + sums[i-1];
                }
            }
        }

        public int sumRange(int i, int j) {
            return i==0 ? sums[j] : sums[j]-sums[i-1];
        }

        public static void main(String[] arg){

            int[] nums = {-2,0,3,-5,2,-1};
            Rangesum r  = new Rangesum(nums);
            System.out.println(r.sumRange(0,2));
            System.out.println(r.sumRange(2, 5));
            System.out.println(r.sumRange(0,5));
            Stack<Integer> stack = new Stack<>();
        }
}

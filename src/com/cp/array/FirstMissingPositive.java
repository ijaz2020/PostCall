package com.cp.array;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;          //case: nums == null or nums == [], return 1
        for(int i = 0;i < nums.length;i++){                     //use nums array itself, the ideal array should be {1,2,3,4}
            int curr = nums[i];                                 //swap if nums[index] != index + 1;
            while(curr - 1 >= 0 && curr - 1 < nums.length && curr != nums[curr-1]){
                int next = nums[curr-1];
                nums[curr-1] = curr;
                curr = next;
            }
        }
        for(int i = 0;i< nums.length;i++){                      //check if nums[index] == index + 1;
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;                                   //corner case: {1,2,3,4} return 5
    }
}

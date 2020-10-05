package com.hotel.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new FindDuplicates().findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=i+1 && nums[i] != nums[nums[i]-1]){
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1)
                res.add(nums[i]);
        }
        return res;
    }
}

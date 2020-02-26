package com.hotel.binarySearch;

import java.util.Arrays;

public class FindFirstAndLastPosition {
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};int target = 8;
        System.out.println(Arrays.toString(new FindFirstAndLastPosition().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int firstPos = -1, lastPos =-1;
        int left=0, right=nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target) left = mid+1;
            else right=mid;
        }
        if (left == -1) return new int[]{firstPos, lastPos};
        right=nums.length-1;
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target) right = mid-1;
            else if(nums[mid] < target) left = mid+1;
            else left=mid;
        }
        return new int[]{firstPos, right};
    }
}

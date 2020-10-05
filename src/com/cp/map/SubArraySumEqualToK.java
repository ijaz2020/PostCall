package com.cp.map;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {
    public static void main(String[] args){
//        int[] nums = {4, 8, 12, -4, 4};
        int[] nums = {4,8,4,-4};
        int k = 12;
        System.out.println(new SubArraySumEqualToK().subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}

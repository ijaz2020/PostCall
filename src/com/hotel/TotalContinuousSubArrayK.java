package com.hotel;

import java.util.HashMap;
import java.util.Map;

public class TotalContinuousSubArrayK {
        public static void main(String[] arg){
            int[] a = {-4,3,6,-2,1,-1,0,2,-2,3,1};
            System.out.println(subarraySum(a, 5));
        }
    public  static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}

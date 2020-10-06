package com.cp.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode {
    public static void main(String[] args) {
//        int[] nums = {1,4,2,5,3};
//        int[] nums = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
//        System.out.println(new Leetcode().minSubarray(nums, 26));
//        System.out.println(new Leetcode().minSubarray1(nums, 26));
          System.out.println(new Leetcode().reorderSpaces("a    "));
    }

    public String reorderSpaces(String text) {
        String[] words = text.replaceAll("^[\\s]+", "").split("[\\s]+");
        int space = (int)text.chars().filter(c -> c == ' ').count(), n = words.length;
        return n == 1 ? text : String.join(" ".repeat(space/(n-1)), words) + " ".repeat(space % (n-1));
    }

    public int minSubarray(int[] nums, int p) {
        long n=nums.length, sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        if(sum % p == 0) return 0;
        long s = sum % p;
        int res = minSubArrayLen(s, nums);
        return  res == 0 ? -1 : res;
    }

    public int minSubArrayLen(long s, int[] nums) {
        int i=0, j=0, n = nums.length, res = n+1;
        while(j < n){
            s -= nums[j++];
            while(s <=0){
                if( s== 0) {
                    res = Math.min(res, j - i);
                }
                s += nums[i++];
            }
        }
        return res == n+1 ? 0: res;
    }

    public int minSubarray1(int[] nums, int p) {
        long remainder = 0, prefixSum = 0;
        int n = nums.length, minLen = n;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }
        if (remainder == 0) {
            return 0;
        }
        var prefixSumToIndex = new HashMap<Long, Integer>();
        prefixSumToIndex.put(prefixSum, -1);
        for (int i = 0; i < n; ++i) {
            prefixSum = (prefixSum + nums[i]) % p;
            long key = (prefixSum - remainder + p) % p;
            if (prefixSumToIndex.containsKey(key)) {        // {26,19,11,14,18,4,7,1,30,23,19,8, 10, 6, 26, 3}
                                                            //  0  1  2   3 4  5 6 7 8  9  10 11 12  13 14  15
                minLen = Math.min(minLen, i - prefixSumToIndex.get(key));
            }
            prefixSumToIndex.put(prefixSum, i);
        }
        return minLen == n ? -1 : minLen;
    }
}

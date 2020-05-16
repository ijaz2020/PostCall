package com.hotel.array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args){
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(new SingleNumber().singleNumber(nums)));
    }

    public int singleNumber1(int[] nums) {
        return Arrays.stream(nums).reduce(0 , (a,b) -> a^b);
    }

    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}

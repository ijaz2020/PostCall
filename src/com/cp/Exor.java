package com.cp;

import java.math.BigDecimal;
import java.util.Arrays;

public class Exor {
    public static void main(String[] args){
        int[]  a = {2,3,4,5,6,8,9};
        System.out.println(Arrays.toString(findDisappearedNumbers(a)));
        BigDecimal x = new BigDecimal(3).divide(new BigDecimal(5));
        System.out.println(x);
    }

        public static int[] findDisappearedNumbers(int[] nums) {
            int max = nums.length+2;

            int total = 0, arrSum = 0;
            for(int i=1;i<=max;i++){
                total += i;
            }

            for(int i=0;i<nums.length;i++){
                arrSum += nums[i];
            }

            int pivot = (total - arrSum) /2;

            int halfSum = 0, nextSum = 0, leftSum = 0, rightSum=0;
            for(int i=1; i<=pivot;i++){
                halfSum ^= i;
            }
            for(int i=pivot+1; i<=max;i++){
                nextSum ^= i;
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i] <= pivot)
                    leftSum ^= nums[i];
                else
                    rightSum ^= nums[i];
            }

            return new int[]{halfSum ^leftSum, nextSum ^ rightSum};

    }
}

package com.cp;

public class MisingNo {

    public static void main(String args[]){
        int[] a = {8,4,5,6,9,3,1,2,0};
        System.out.println(missingNumber(a));
//        System.out.println(~1099);
    }

    public static int missingNumber(int[] nums) {

        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }
}

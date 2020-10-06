package com.cp;

public class HouseRobber {

    public static void main(String arg[]){
        HouseRobber h = new HouseRobber();
        int[] a = {5,2,3,4};
       System.out.println(h.rob(a));
    }
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}

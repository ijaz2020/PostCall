package com.cp;

public class MinJumpToReachEnd {

    public static void main(String args[]){
        MinJumpToReachEnd m = new MinJumpToReachEnd();
        int[] ar = {1,4,3,7,1,2,6,7,6,10};
        System.out.println(m.jump(ar));
    }

    private int jump1(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;

        for(int i=1;i<nums.length;i++){
            for(int j=0; j<i;j++){
                if(nums[j] >= i-j){
                    if(dp[i] == 0){
                        dp[i] = dp[j] +1;
                    }else{
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[nums.length-1];
    }

    public int jump(int[] A) {
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i=0; i<A.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+A[i]);
            if( i == last_jump_max ) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
}

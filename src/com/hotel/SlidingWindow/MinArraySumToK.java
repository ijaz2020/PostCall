package com.hotel.SlidingWindow;

public class MinArraySumToK {
    public static void main(String[] args){
        int[] nums ={2,3,1,2,4,3};
        System.out.println(new MinArraySumToK().minSubArrayLenN(188, nums));
    }

    public int minSubArrayLen(int s, int[] A) {
        int i = 0, n = A.length, res = n + 1;
        for (int j = 0; j < n; ++j) {
            s -= A[j];
            while (s <= 0) {
                res = Math.min(res, j - i + 1);
                s += A[i++];
            }
        }
        return res % (n + 1);
    }

    public int minSubArrayLenN(int s, int[] nums) {
        int i=0, j=0, n = nums.length, res = n+1;
        while(j < n){
            s -= nums[j++];
            while(s <=0){
                s += nums[i++];
                res = Math.min(res, j-i+1);
            }
        }
        return res == n+1 ? -1: res;
    }

    public int minSubArrayLenI(int s, int[] nums) {
        int i = 0, n= nums.length, result = n+1;
        for(int j=0; j<n ; j++){
            s -= nums[j];
            while(s <= 0){
                result = Math.min(result, j-i+1);
                s +=nums[i++];
            }
        }
        return result == n+1 ? 0 : result;
    }
}

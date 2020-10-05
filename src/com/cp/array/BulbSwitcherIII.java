package com.cp.array;

public class BulbSwitcherIII {
    public static void main(String[] args){
        int[] nums={2,1,3,5,4};
        System.out.println(new BulbSwitcherIII().numTimesAllBlue(nums));
    }
    public int numTimesAllBlue(int[] A) {
        int right = 0, res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, A[i]);
            if (right == i + 1)
                ++res;
        }
        return res;
    }
}

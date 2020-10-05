package com.cp.greedy;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args){
        int[] nums ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(new TrappingRainWater().trap(nums));
    }

    int trap(int A[]) {
        int left=0; int right=A.length-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(A[left]<=A[right]){
                if(A[left]>=maxleft)
                    maxleft=A[left];
                else
                    res+=maxleft-A[left];
                left++;
            }
            else{
                if(A[right]>=maxright)
                    maxright= A[right];
                else
                    res+=maxright-A[right];
                right--;
            }
        }
        return res;
    }
}

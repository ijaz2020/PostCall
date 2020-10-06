package com.cp.array;

import java.util.Arrays;

public class TargetArrayWithMulSum {
    public static void main(String[] args){
        int[] tar ={9,9,9};
        System.out.println(new TargetArrayWithMulSum().isPossible(tar));
    }

    public boolean isPossible(int[] target) {
        int n = target.length;
        int[] start = new int[n];
        Arrays.fill(start, 1);
        Arrays.sort(target);

        int currentSum = n, i = 0, j=0;
        while(i < n){
            if(currentSum > target[i])
                return false;
            if(currentSum == target[i])
                i++;
            int diff = currentSum - start[j%n];
            start[j%n] = currentSum;
            currentSum += diff;
            j++;
        }
        return true;
    }
}

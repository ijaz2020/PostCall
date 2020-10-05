package com.cp.numbers;

import java.util.Arrays;

public class TwoNonZeroInteger {
    public static void main(String args[]){
        TwoNonZeroInteger t = new TwoNonZeroInteger();
        System.out.println(Arrays.toString(t.getNoZeroIntegers(2)));
    }
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        result[0] = 1;
        int second = n - result[0];
        while(hasO(second)){
            result[0]++;
            second = n - result[0];
        }
        result[1] = second;
        return result;
    }
    private boolean hasO(int n){
        while(n>0){
            if(n%10 == 0) return true;
            n = n/10;
        }
        return false;
    }
}

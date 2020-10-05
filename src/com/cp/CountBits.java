package com.hotel;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args){
        System.out.println(Arrays.toString(countBits(5)));
    }
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for(int i = 1; i <= num; i++){
            if((i & 1) == 0){
                res[i] = res[i >> 1];
            }else{
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }
}

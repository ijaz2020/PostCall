package com.hotel.array;

import java.util.Arrays;

public class MutateArray {
    public static void main(String[] args){
//        int[] nums ={4, 0, 1, -2, 3};
        int[] nums ={4};
        System.out.println(Arrays.toString(new MutateArray().mutateTheArray(1, nums)));
    }

    int[] mutateTheArray(int n, int[] a) {
        int prev = -1, next =1;
        int[] b = new int[n];
        for(int i=0; i< n; i++, prev++, next++){
            int prevElem = 0, nextElem =0;
            if(prev >= 0)  prevElem = a[prev];
            if(next < n) nextElem = a[next];
            b[i] = prevElem + a[i] + nextElem;
        }
        return b;
    }
}

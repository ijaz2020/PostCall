package com.cp.array;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args){
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int value : arr)
            if (value == 0) countZero++;
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i]; //copy twice when hit '0'
            }
        }
    }
}

package com.hotel;

import java.util.Arrays;

class SortParity {

    public static void main(String arg[]){
        int[] A = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }
    public static int[] sortArrayByParity(int[] A) {

        if(A.length ==0) return null;
        int left = 0, right = A.length - 1;
        while(left < right){

            if(A[left] % 2 == 1){
                if(A[right] %2 ==0){
                    swap(left, right, A);
                    left ++; right--;
                }else{
                    right --;
                }
            }
            else{
                left ++;
            }

        }
        return A;
    }

    private static void swap(int a, int b, int[] A){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
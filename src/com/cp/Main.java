package com.cp;

import java.math.BigInteger;
import java.util.*;

public class Main {

    static void staircase(int n) {

        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(j == n-1){
                    System.out.println("#");
                }
                else if(j + i +1 >= n){
                    System.out.print("#");
                }
                else{
                    System.out.print(" ");
                }
            }
        }

    }

    static void miniMaxSum(int[] arr) {

        int min = arr[0], max =arr[0], res=arr[0];

        for(int i=1;i<arr.length;i++){
            res += arr[i];
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println( (res - max) +" "+ (res -min));
    }
    public static void main(String arg[]) {

        Scanner s = new Scanner(System.in);
        s.nextBigInteger().isProbablePrime(100);
        BigInteger b = s.nextBigInteger();
        int[][] result = new int[4][9];
        System.out.println(Arrays.toString(result));

    }
}

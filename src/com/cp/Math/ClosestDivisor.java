package com.hotel.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestDivisor {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new ClosestDivisor().closestDivisors(688427155)));
    }
    public int[] closestDivisors(int num) {
        int num1 = num+1, num2 = num +2, closeDiff = Integer.MAX_VALUE;
        int[] res = new int[2];
        List<int[]> result = new ArrayList<>();
        findFactors(num1, result);
        findFactors(num2, result);
        for(int[] i : result){
            if( Math.abs(i[0] - i[1]) < closeDiff){
                res = new int[]{i[0], i[1]};
                closeDiff = Math.abs(i[0] - i[1]);
            }
        }
        return res;
    }

    void findFactors(int num, List<int[]> result){
        for(int i=1; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                result.add(new int[]{i, num/i});
        }
    }
}

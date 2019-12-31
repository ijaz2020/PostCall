package com.hotel;

public class TwoSumWith60Pairs {
    public static void main(String[] args){
        int[] c= {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(c));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}

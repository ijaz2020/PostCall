package com.cp;

public class GCD {
    public static void main(String args[]){
        int a = 7 , b=1000;
        System.out.println(gcd(a, b));
    }

    private static int gcd(int a, int b){
        return b > 0 ? gcd(a, a%b): a;
    }
}

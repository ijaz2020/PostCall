package com.cp.BitManipulation;

public class Complement {
    public static void main(String[] args) {
        System.out.println(findComplement(10));
    }

    public static int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }

}

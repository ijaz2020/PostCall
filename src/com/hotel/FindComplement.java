package com.hotel;

public class FindComplement {
    public static void main(String[] a) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}

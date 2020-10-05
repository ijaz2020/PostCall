package com.cp.BitManipulation;

public class FindComplement {
    public static void main(String[] a) {
        System.out.println(findComplement(5));
        System.out.println(findComplement1(5));
    }

    public static int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    public static int findComplement1(int num) {
        int cp = num;
        int sum = 0;
        while(num > 0){
            sum = (sum << 1) + 1;
            num >>= 1;
        }
        return sum - cp;

    }
}

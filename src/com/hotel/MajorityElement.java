package com.hotel;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {3,4,5,6,2,2,2,2};
        System.out.println(majorityElement(a));
    }

    public static int majorityElement(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
}

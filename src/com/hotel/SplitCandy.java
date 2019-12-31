package com.hotel;

import java.util.Arrays;

public class SplitCandy {
    public static void main(String[] args){
        int[] a = {1,2}, b={1,2,3};
        System.out.println(findContentChildren(a, b));
    }

    private static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int child = 0;
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie ++) {
            if (cookies[cookie] >= children[child]) {
                child ++;
            }
        }

        return child;
    }
}

package com.cp;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class NReapeatedElements {
    public static void main(String[] args){
//        int[] A= {5,1,5,2,5,3,5,4};
        int[] A= {5,1,5,2,5,3,5,4};
        PriorityQueue<Integer> sortedStones = new PriorityQueue<>();
        System.out.println(repeatedNTimes(A));
    }

    private static int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
                return a;
        return -1;
    }
}

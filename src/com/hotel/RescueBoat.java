package com.hotel;

import java.util.Arrays;

public class RescueBoat {
    public static void main(String[] args){
        int[] A= {3,2,2,1};
//        System.out.println(numRescueBoats(A, 8));
        System.out.println(numRescueBoatsII(A, 3));
    }
    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int hi = people.length - 1, lo = 0; hi >= lo; --hi, ++ans) { // high end always moves
            if (people[lo] + people[hi] <= limit) { ++lo; } // low end moves only if it can fit in a boat with high end.
        }
        return ans;
    }

    private static int numRescueBoatsII(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0; int i=0, j=people.length-1;
        while (i <=j){
            int remainingLimit = limit;
            while (i<=j && remainingLimit - people[j] >=0){
                remainingLimit -= people[j];
                j--;
            }
            while (i<=j && remainingLimit - people[j] >=0){
                remainingLimit -= people[i];i++;
            }
            if (remainingLimit != limit) ans++;
        }

        return ans;
    }
}

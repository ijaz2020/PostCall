package com.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarPooling {
    public static void main(String[] args) {
        /*int[][] A = {{2,1,5},{3,3,7}};
        List<Integer> i = new ArrayList<>();
        System.out.println(carPooling(A, 4));*/
        int[][] trips= {{9,3,6},{8,1,7},{6,6,8},{8,4,9},{4,2,9}};
        System.out.println(new CarPooling().carPooling1(trips, 28));
    }

    /// WRONG
    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int curr[] = trips[0], cc = capacity - curr[0];
        if(cc < 0) return false;
        for(int i=1; i< trips.length; i++){
            if(curr[2] <= trips[i][1]){
                curr = trips[i];
                cc = capacity - curr[0];
            }
            else{
                cc -= trips[i][0];
                if(cc < 0 ) return false;
                if(curr[2] < trips[i][2]){
                    cc += curr[0];
                    curr = trips[i];
                }
                else if(curr[2] > trips[i][2]){
                    cc += trips[i][0];
                }
                else{
                    cc += curr[0] + trips[i][0];
                    curr = trips[i++];
                }
            }
        }

        return true;
    }


    private static boolean carPooling(int[][] trips, int capacity) {
        int stops[] = new int[1001];
        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i)
            capacity -= stops[i];
        return capacity >= 0;
    }
}

package com.cp.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AngleClock {
    public static void main(String[] args){
//        System.out.println(new AngleClock().angleClock(8, 7));
        int[] arr = {-2,0,10,-19,4,6,-8};
        System.out.println(new AngleClock().checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i : arr) arrayList.add(i);
        for(int i =0 ; i< arrayList.size(); i++){
            if( arrayList.get(i) % 2 == 0 ) {
                int index = arrayList.lastIndexOf(arrayList.get(i) / 2);
                if ( index != -1 && index != i)
                    return true;
            }
        }
        return false;
    }
    public double angleClock(int hour, int minutes) {
        if(hour == 12 ) hour =0;
        double mins = 6 * minutes;
        double hrs = 30 * (hour+((double)minutes/60));
        return Math.min(Math.abs( mins - hrs), Math.abs(360 -(mins -hrs)));
    }
}

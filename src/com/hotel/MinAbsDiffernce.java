package com.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDiffernce {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> diffList = new ArrayList<>();
        int n= arr.length;
        if(n < 3) return diffList;
        Arrays.sort(arr);
        diffList.add(new ArrayList<Integer>() {
            {
                add(arr[0]);
                add(arr[1]);
            }
        });
        int diff = arr[1] - arr[0];

        for(int i=2; i<n-2;i++){
            if(diff == arr[i] - arr[i-1]){
                int finalI = i;
                diffList.add(new ArrayList<Integer>() {
                    {
                        add(arr[finalI -1]);
                        add(arr[finalI]);
                    }
                });
            }
        }

        return diffList;
    }
}

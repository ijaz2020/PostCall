package com.cp.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPosition {
    public static void main(String[] args){

    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> largeGroupIndex = new ArrayList<>();
        int counter = 1; char prev =s.charAt(0);
        for(int i=1; i<s.length();i++){
            if(prev == s.charAt(i)) counter++;
            else{
                if(counter > 2)
                    largeGroupIndex.add(Arrays.asList(i-counter, i));
                counter =1;
            }
        }
        return largeGroupIndex;
    }
}

package com.cp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountnonUnique {

    public static void main(String arg[]){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(1);
        numbers.add(5);
        numbers.add(6);
        numbers.add(3);
        numbers.add(2);

        System.out.println(countNonUnique(numbers));
    }
    public static int countNonUnique(List<Integer> numbers) {
        // Write your code here

        int count =0;
        if(numbers ==null ||numbers.size() ==0){
            return count;
        }

        Map<Integer, Integer> nums = new HashMap<>();

        for(Integer i: numbers){
            Integer value = nums.get(i);
            if(value == null){
                value = 1;
            }
            else{
                value++;
            }
            nums.put(i, value);
        }

        for (Map.Entry<Integer,Integer> entry : nums.entrySet()){
            if(entry.getValue() > 1){
                count++;
            }
        }

        return count;


    }
}

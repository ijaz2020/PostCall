package com.hotel.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subset {
    public static void main(String[] args){
        Subset s = new Subset();
        int[] nums = {1,2,3};
        int[] nums1 = {1,2,2};
//        System.out.println(s.subsets(nums));
        System.out.println(s.subsetsWithDup(nums1));
    }

    public List<String> subsets(int[] nums) {
        List<String> result = new ArrayList<>();
        result.add("");
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                String subset = result.get(i);
                subset += n;
                result.add(subset);
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        int size = 0;
        for(int i=0; i< nums.length;i++){
            int startIndex = i > 0 && nums[i] == nums[i-1] ? size : 0;
            size = result.size();
            for(int j =startIndex;j< size; j++){
                List<Integer> current = new ArrayList<>(result.get(j));
                current.add(nums[i]);
                result.add(current);
            }
        }
        return result;
    }

}

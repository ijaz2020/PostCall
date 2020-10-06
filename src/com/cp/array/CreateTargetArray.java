package com.cp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CreateTargetArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
        System.out.println(Arrays.toString(new CreateTargetArray().createTargetArray(nums, index)));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> linkedList = new ArrayList<>(nums.length);
        for(int i=0; i< nums.length; i++)
            linkedList.add(index[i], nums[i]);
        int[] res = new int[linkedList.size()];
        for(int i = 0; i< linkedList.size(); i++)
            res[i] = linkedList.get(i);
        return res;
    }
}

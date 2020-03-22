package com.hotel.array;

import java.util.Arrays;
import java.util.LinkedList;

public class CreateTargetArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
        System.out.println(Arrays.toString(new CreateTargetArray().createTargetArray(nums, index)));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int ind = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0; i< nums.length; i++)
            linkedList.add(index[i], nums[i]);
        int[] res = new int[linkedList.size()];
        for(int i : linkedList)
            res[ind++] = i;
        return res;
    }
}

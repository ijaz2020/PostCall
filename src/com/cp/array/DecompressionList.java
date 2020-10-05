package com.cp.array;

import java.util.ArrayList;
import java.util.List;

public class DecompressionList {
    public static void main(String args[]){
        int[] a = {1,2,3,4};
        System.out.println(decompressRLElist(a));
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2)
            for (int j = 0; j < nums[i]; ++j)
                ans.add(nums[i + 1]);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}

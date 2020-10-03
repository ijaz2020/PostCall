package com.hotel;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DominantIndex {
    public static void main(String[] args){
        int[] nums={1,0};
        List<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);
        System.out.println();
        ///resultList.toArray(new Integer[0]);
        //System.out.println(dominantIndex(nums));
    }
        public static int dominantIndex(int[] nums) {
            if(nums.length == 0) return -1;
            int max1 =0, max2 = Integer.MIN_VALUE;

            for(int i=1; i<nums.length;i++){
                if(nums[i] > nums[max1]){
                    max2 = max1;
                    max1= i;
                }
                else if(max2 != Integer.MIN_VALUE && nums[i] > nums[max2]){
                    max2 =i;
                }
            }

            return ( max2 != Integer.MIN_VALUE || (nums[max1] / 2) >= nums[max2] ) ? max1 : -1;

        }
}

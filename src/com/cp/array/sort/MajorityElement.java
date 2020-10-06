package com.cp.array.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
      //  int[] a = {3,4,5,6,2,2,2,2};
      //  System.out.println(majorityElement(a));
        int[] nums = {1,1,1,3,3,2,2,2, 4};
        List<Integer> res = new ArrayList<>(){{
               add(2);
               add(3);
        }};
        System.out.println(Collections.frequency(Arrays.stream(nums).boxed().collect(Collectors.toList()), 2));
        System.out.println(new MajorityElement().majorityElementBy3(nums));
    }

    public List<Integer> majorityElementBy3(int[] nums) {
        Integer major1 = null, major2 = null, cnt1 = 0, cnt2 = 0;
        for (Integer num : nums) {
            if (num.equals(major1)) {
                cnt1++;
            } else if (num.equals(major2)) {
                cnt2++;
            } else if (cnt1 == 0) {
                major1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                major2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for (Integer num : nums) {
            if (num.equals(major1)) cnt1++;
            else if (num.equals(major2)) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        if (cnt1 > nums.length / 3) result.add(major1);
        if (cnt2 > nums.length / 3) result.add(major2);
        return result;
    }
    public static int majorityElement(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }
}

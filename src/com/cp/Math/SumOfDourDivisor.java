package com.cp.Math;

import java.util.HashSet;
import java.util.Set;

public class SumOfDourDivisor {
    public static void main(String[] args) {
        int[] nums=  {21,4,7};
        System.out.println(new SumOfDourDivisor().sumFourDivisors(nums));
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = 0, sum =  0;
            for (int j = 1; j<=Math.sqrt(num); j++) {
                if (num % j == 0) {
                    Set<Integer> curSet = new HashSet<>();
                    curSet.add(j);
                    curSet.add(num/j);
                    count += curSet.size();
                    for(Integer k : curSet){
                        sum += k;
                    }

                }
            }
            if (count == 4)
                res += sum;
        }
        return res;
    }
}

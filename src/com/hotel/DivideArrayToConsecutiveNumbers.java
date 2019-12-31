package com.hotel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DivideArrayToConsecutiveNumbers {
    public static void main(String[] args){
        int[] A = {3,2,1,2,3,4,3,4,5,9,10,11};
        System.out.println(isPossibleDivide(A, 3));
    }
    public static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)return false;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Integer i:map.keySet()){
            if(map.get(i)<=0)continue;
            int l=map.get(i);
            for(int p=1;p<=l;p++){
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(i,map.get(i)-1);
                if(map.get(i)<0)return false;
                for(int j=1;j<=k-1;j++){
                    if(map.get(i+j)!=null && !set.contains(i+j)){
                        set.add(i+j);
                        map.put(i+j,map.get(i+j)-1);
                        if(map.get(i+j)==-1)return false;
                    }else if(map.get(i-j)!=null && !set.contains(i-j)){
                        set.add(i-j);
                        map.put(i-j,map.get(i-j)-1);
                        if(map.get(i-j)==-1)return false;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

package com.hotel.backtracking;

import java.util.*;

public class Permutation {
    public static void main(String args[]){
        int[] n = {10,2};
        Permutation p = new Permutation();
        List<List<Integer>> result = p.permute(n);
        System.out.println(result);
        int[] n1 = {1,2,2};
        //Permute II
        //[[1,2,2],[2,1,2],[2,2,1]]
    }
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for(int n: nums){
            Set<String> cache = new HashSet<>();
            int size =  result.size();
            while(size-- > 0){
                List<Integer> current = result.pollFirst();
                for(int i=0; i <=current.size(); i++){
                    List<Integer> traverse = new ArrayList<>(current);
                    traverse.add(i, n);
                    if(cache.add(traverse.toString()))
                        result.add(new ArrayList<>(traverse));
                }
            }
        }
        return result;
    }

}

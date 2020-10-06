package com.cp.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String args[]){
        int[] n = {10,2};
//        Permutation p = new Permutation();
//        List<List<Integer>> result = p.permute(n);
//        System.out.println(result);
//        System.out.println(new Permutation().getPermutation(3, 3));
//        System.out.println(new Permutation().getPermutation1(3, 3));
        int[] n1 = {1,2,3};
        System.out.println(new Permutation().permute(n1));
        //Permute II
        //[[1,2,2],[2,1,2],[2,2,1]]
    }
    public String getPermutation1(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }
    public String getPermutation(int n, int k) {
        if(n == 1) return n+"";
        int[] fact = new int[n+1];
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =1; i <=n; i++) list.add(i);
        fact[0] = 1;
        for(int i=1; i <= n; i++)
            fact[i] = fact[i-1] * i;
        for(int i = 1; i <= n; i++){
            int j = k / fact[n-i];
            sb.append(String.valueOf(list.get(j)));
            list.remove(j);
            k -= j * fact[n-i];
        }
        return sb.toString();
    }
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permutate(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0);
        return res;
    }

    void permutate(List<Integer> nums, int s){
        if(s == nums.size()-1){
            res.add(new ArrayList<>(nums));
        }
        for(int i=s; i<nums.size(); i++){
            Collections.swap(nums, i, s);
            permutate(nums, s+1);
            Collections.swap(nums, i, s);
        }
    }
    public List<List<Integer>> permute1(int[] nums) {
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

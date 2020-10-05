package com.cp.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer test = Integer.parseInt(scanner.nextLine());
        for (int i=1; i<=test;i++){
            int n = scanner.nextInt(), budget = scanner.nextInt();
            int[] nums = new int[n];
            for (int j=0; j<n;j++)
                nums[j] = scanner.nextInt();
            System.out.println("Case #" + i + ": " + process(n, budget, nums));
        }
    }
/*      3
        4 100
        20 90 40 90
        4 50
        30 30 10 10
        3 300
        999 999 999*/
    private static int process(int n, int budget, int[] nums){
        int res = 0;
        Arrays.sort(nums);
        for(int i=0; i<n;i++){
            if(budget - nums[i] >=0){
                res++;
                budget -= nums[i];
            }
            else{
                break;
            }
        }
        return res;
    }
}

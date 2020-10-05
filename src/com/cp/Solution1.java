package com.hotel;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String args[]){

        int[] arr = {3, 26, 103, 59};
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(3);
        arr1.add(26);
        arr1.add(103);
        arr1.add(59);

        System.out.println(maxProfit(100, 10, arr1));
    }




    static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {

        int longestRod = 0;
        for(Integer rod : lengths){
            longestRod = Math.max(longestRod, rod);
        }



        int maxProfit = 0;

        for (int i = 1; i < longestRod; i++) {

            int totalLength =0, totalCuts =0, totalCutWaste=0;

            for (int length : lengths) {

                totalLength += length;

                if (length % i == 0) {
                    totalCuts += (length/i - 1);
                } else {
                    totalCuts += (length/i);
                }

                totalCutWaste += (length%i);
            }

            maxProfit = Math.max(maxProfit, totalLength*salePrice - totalCuts*costPerCut - totalCutWaste*salePrice);
        }

        return maxProfit;
    }


}
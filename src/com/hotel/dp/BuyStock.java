package com.hotel.dp;

public class BuyStock {
    public static void main(String[] args){
        int[] a= {7,1,5,3,6,4};
        System.out.println(new BuyStock().maxProfit1(a));
    }

    public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0 ;
        }
        int max = 0 ;
        int sofarMin = prices[0] ;
        for (int price : prices) {
            if (price > sofarMin) {
                max = Math.max(max, price - sofarMin);
            } else {
                sofarMin = price;
            }
        }
        return  max ;
    }
}

package com.hotel;

public class BuyStock {
    public static void main(String[] args){
        int[] a= {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
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

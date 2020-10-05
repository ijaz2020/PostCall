package com.cp.dp;

//4
//6 8 3
//10 7 5 12
public class LongDrive {
    public static void main(String[] args){
        int[] distance = {6,8,3};
        int[] fuel = {10,7,5,12};
        System.out.println(new LongDrive().findMinFuel(distance, fuel, fuel.length));
    }

    int findMinFuel(int[] distance, int[] fuel, int n){
        int totalFuelCost = 0, minFuelCost = Integer.MAX_VALUE, minCostIndex  = -1;
        for(int i=0; i< fuel.length; i++) {
            minFuelCost = Math.min(minFuelCost,fuel[i]);
            minCostIndex = i;
        }
        for(int i =0; i<fuel.length;i++){
            if(i+1 < fuel.length && fuel[i+1] > fuel[i]){

            }
        }
        return totalFuelCost;
    }
}

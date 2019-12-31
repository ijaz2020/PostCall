package com.hotel;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args){
        TwoCityScheduling t = new TwoCityScheduling();
        int[][] costs = {{10,20},{30,200},{60,70},{400,50},{30,20}};
        //Saving 10, 170, -350, -10 - Sorted -> -350, -10, 10, 170
        //Sorting version -> {400,50},{30,20},{10,20},{30,200}
        System.out.println(t.twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[1] - a[0])));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0];
        }
        return cost;
    }
}

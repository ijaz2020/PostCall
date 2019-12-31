package com.hotel;

import java.util.HashMap;
import java.util.Map;

public class RabbitInforest {
    public static void main(String[] args){
//        int[] A = {1, 1, 2};
//        int[] A = {1,2,3};
        int[] A = {1,0,0,1,0};
        System.out.println(numRabbits(A));
    }

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : answers)
            m.put(i, m.getOrDefault(i, 0) + 1);
        int res = 0;
        for (int i : m.keySet())
            res += (m.get(i) + i) / (i + 1) * (i + 1);
        return res;
    }
}

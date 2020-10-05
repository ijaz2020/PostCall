package com.hotel.BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class NumberOfFamilies {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        System.out.println(new NumberOfFamilies().maxNumberOfFamilies(8, nums));
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int res =0;
        Map<Integer, Integer> map = new HashMap<>();
        processInput(reservedSeats, map);
        res = 2 * n - 2 * map.size();
        for(Integer key : map.keySet()){
            int count;
            count = chkWhetherFree((1 << 2) + (1<< 3) + (1<< 4) + (1<< 5) , map.get(key)) +
                    chkWhetherFree((1 << 6) + (1<< 7) + (1<< 8) + (1<< 9) , map.get(key));
            if(count == 0)
                count = chkWhetherFree((1 << 4) + (1<< 5) + (1<< 6) + (1<< 7) , map.get(key));
            res += count;
        }
        return res;
    }

    private int chkWhetherFree(Integer i, Integer val){
        if( (val & i) == 0)
            return 1;
        return 0;
    }

    private void processInput(int[][] reservedSeats, Map<Integer, Integer> map){
        for (int[] reservedSeat : reservedSeats) {
            map.put(reservedSeat[0], map.getOrDefault(reservedSeat[0], 0) | 1 << reservedSeat[1]);
        }
    }
}

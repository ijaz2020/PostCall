package com.hotel.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {
    public static void main(String[] args) {
        int[][] reservedSeats = {{4,3},{1,4},{4,6},{1,7}};
//        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
//        int[][] reservedSeats = {{2,1},{1,8},{2,6}};
        System.out.println(new CinemaSeatAllocation().maxNumberOfFamilies(4, reservedSeats));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int res =0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        processInput(reservedSeats, map);
        for(int i=0; i<n; i++){
            Set<Integer> current = map.get(i);
            if(current !=null){
                int[] l = {1,2,3,4}, r = {5,6,7,8} ,m ={3,4,5,6};
                int c = chkScore(l, current) +chkScore(r, current);
                if( c ==0)
                    c = chkScore(m, current);
                res += c;
            }
            else res += 2;
        }
        return res;
    }

    private int chkScore(int[] l, Set<Integer> set){
        if(!set.contains(l[0]) && !set.contains(l[1]) && !set.contains(l[2]) && !set.contains(l[3]) ) return 1;
        return 0;
    }


    private void processInput(int[][] reservedSeats, Map<Integer, Set<Integer>> map){
        for(int i=0; i<reservedSeats.length;i++){
            Set<Integer> col = map.getOrDefault(reservedSeats[i][0]-1, new HashSet<>());
            col.add(reservedSeats[i][1]-1);
            map.put(reservedSeats[i][0]-1, col);
        }
    }
}

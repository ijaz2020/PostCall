package com.cp.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyNumber {
    public static void main(String[] args){
        // 3  7   8
        // 9  11  13
        // 15 16  17
        int[][] mat = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(new LuckyNumber().luckyNumbers(mat));
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        // 3  7   8
        // 9  11  13
        // 15 16  17
        /*[[1, 10, 4, 2],
           [9, 3, 8, 7],
           [15,16,17,12]]*/
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> row = new HashMap<>();

        for(int i=0; i < m; i++){
            int min = Integer.MAX_VALUE;
            int col = -1;
            for(int j=0; j < n; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    col = j;
                }
            }
            row.put(min, col);
        }

        for(Map.Entry<Integer, Integer> entry : row.entrySet()){
            int min = entry.getKey();
            int col = entry.getValue();
            int max = Integer.MIN_VALUE;
            for(int i=0; i< m; i++){
                max =  Math.max(max, matrix[i][col]);
            }
            if(min == max) res.add(min);
        }

        return res;
    }
}

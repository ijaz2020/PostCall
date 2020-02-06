package com.hotel.matrix;

import java.util.HashSet;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] nums = {
                        {1, 2, 3, 4},
                        {5, 1, 2, 3},
                        {9, 5, 1, 2}};
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(nums));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        HashSet<String> toe = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0)
                    toe.add(i + "" + j + "" + matrix[i][j]);
                else {
                    if (j > i){
                        if(toe.add(0 + "" + (j - i) + "" + matrix[i][j])) return false;
                    }
                    else if (toe.add((i - j) + "" + 0 + "" + matrix[i][j]))
                            return false;
                }
            }
        }
        return true;
    }
}

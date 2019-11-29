package com.hotel;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
//        System.out.println(searchMatrix(matrix, 3));
//        System.out.println(searchMatrix2(matrix, 20));
        System.out.println(Math.sqrt(16));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int l = 0, r = matrix[0].length - 1;

        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (matrix[left][mid] == target) return true;
            else if (matrix[left][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

}

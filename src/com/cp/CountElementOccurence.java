package com.cp;

public class CountElementOccurence {

    public static void main(String[] args){
        int[] a = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10};
        System.out.println(findCount(a, 1));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int findCount(final int[] A, int B) {

        int left = 0, right = A.length - 1;
        int i = -1, j = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == B) {
                if( mid -1 >=0 && A[mid -1] == B){
                    right = mid -1;
                }else {
                    i = mid;
                    break;
                }
            } else if (A[mid] > B) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (i == -1)
            return i;

        left = 0;
        right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == B) {
                if (mid+1 < A.length && A[mid +1] == B){
                   left = mid+1;
                }
                else {
                    j = mid;
                    break;
                }
            } else if (A[mid] > B) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return j - i + 1;
    }
}


package com.cp;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args){
        int[] nums1 = {1,0,0,0};int m = 1;
        int[] nums2 = {2,5,6};int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i >=0 && j >= 0)
            A[k--] = (A[i]>B[j]) ? A[i--] : B[j--];
        while (j >=0)
            A[k--]=B[j--];
    }
}

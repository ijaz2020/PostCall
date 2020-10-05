package com.cp;

public class FindInRotatedSortedII {
    public static void main(String args[]){
        int[] a = {2,2,2,0,1};
        System.out.println(findMin(a));
    }
    static int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }
}

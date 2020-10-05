package com.cp;

public class MountainIndex {

    public static void main(String arg[]){
        MountainIndex mountainIndex = new MountainIndex();
        int[] A = {18,29,38,59,98,100,99,98,90};
        mountainIndex.peakIndexInMountainArray(A);
    }

    private int peakIndexInMountainArray(int[] A) {

        if(A.length < 3) return -1;
        int left =0;
        int right = A.length -1;

        while(left <= right){

            int mid= left + (right-left) /2;

            if(A[mid] > A[mid-1] && A[mid] > A[mid +1]){
                return mid;
            }
            else if(A[mid] > A[mid -1] && A[mid] < A[mid +1] ){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }

        return -1;

    }
}

package com.cp;

class ElementThatAppearsOnceInSortedArray {

    public static void main(String[] args) {
        new ElementThatAppearsOnceInSortedArray();
    }

    public ElementThatAppearsOnceInSortedArray() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int value = getElementAppearedOnce(arr, 0, arr.length-1);
        if(value==-1){
            System.out.println("There is no element that appeared once in given sorted array.");
        }else{
            System.out.println("Element that appeared once in given sorted array is :"+value);
        }
    }

    private int getElementAppearedOnce(int[] arr, int start, int end) {

        if(start>end){
            return -1;
        }

        //This case is will appear when input is {1, 1, 2}
        if(start==end){
            return arr[start];
        }

        int mid = (start + end)/2;

        if(mid%2==0){
            //EVEN
            if(arr[mid] == arr[mid+1]){
                return getElementAppearedOnce(arr, mid+2, end);
            }else{
                return getElementAppearedOnce(arr, start, mid);
            }

        }else{
            //ODD
            if(arr[mid] == arr[mid-1]){
                return getElementAppearedOnce(arr, mid+1, end);
            }else{
                return getElementAppearedOnce(arr, start, mid);
            }
        }
    }

}
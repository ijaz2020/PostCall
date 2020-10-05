package com.hotel.array;

public class MaxRepeatingElement {
    public static void main(String[] args){
        int [] arrA = {4,4,3,1,2};
        new MaxRepeatingElement().MaxRepeatingElementInPlace(arrA);
    }

    public void MaxRepeatingElementInPlace(int [] arrA){
        int size = arrA.length;
        int maxCount=0;
        int maxIndex=0;
        for (int i = 0; i <size ; i++) {
            //get the index to be updated
            int index = arrA[i]% size;
            arrA[index] = arrA[index] + size;
        }
        for (int i = 0; i <size ; i++) {
            if(arrA[i]/size>maxCount){
                maxCount=arrA[i]/size;
                maxIndex=i;
            }
        }
        System.out.println("Element repeating maximum no of times: " + maxIndex + ", maximum count: " + maxCount);
    }
}

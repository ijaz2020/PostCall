package com.cp.priorityQueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class ProductOfNumbers {
    public static void main(String[] args){
        /*["ProductOfNumbers","add","add","add","add","add","getProduct","add","getProduct","add"]
[[],[3],[0],[0],[8],[3], [1],[7],[5],[3]]*/
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(0);        // [3,0,2]
        productOfNumbers.add(8);        // [3,0,2,5]
        productOfNumbers.add(3);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(1)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        productOfNumbers.add(7);        //
        System.out.println(productOfNumbers.getProduct(5)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        productOfNumbers.add(3);        //
//        productOfNumbers.add(8);        // [3,0,2,5,4,8]
//        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }

    PriorityQueue<Integer> pq;
    public ProductOfNumbers() {
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void add(int num) {
        pq.offer(num);
    }

    public int getProduct(int k) {
        if(pq.size() == 0) return 0;
        int total = 1;
        Iterator<Integer> value = pq.iterator();
        while (value.hasNext() && k-- > 0) {
            total = total * value.next();
        }
        return total;
    }
}

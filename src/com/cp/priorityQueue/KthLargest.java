package com.cp.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args){
        KthLargest k = new KthLargest();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(k.findKthLargest(nums, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums) pq.offer(i);
        int result =-1;
        while(k-- > 0) result = pq.poll();
        return result;
    }
}

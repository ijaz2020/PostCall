package com.cp.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedian {

    public static void main(String[] args) {
        FindMedian f = new FindMedian();
        f.addNum(7);
        f.addNum(7);
        System.out.println(f.findMedian());
        f.addNum(1);
        f.addNum(100);
        System.out.println(f.findMedian());
        f.addNum(2);
        f.addNum(55);
        System.out.println(f.findMedian());
        f.addNum(32);
        f.addNum(9);
        System.out.println(f.findMedian());
        f.addNum(12);
        f.addNum(19);
        System.out.println(f.findMedian());
        f.addNum(22);
        f.addNum(1);
        System.out.println(f.findMedian());
        f.addNum(4);
        f.addNum(87);
        System.out.println(f.findMedian());
        f.addNum(78);
        f.addNum(64);
        System.out.println(f.findMedian());
        f.addNum(55);
        f.addNum(44);
        System.out.println(f.findMedian());
        f.addNum(91);
        f.addNum(12);
        System.out.println(f.findMedian());
    }

    private Queue<Integer> large = new PriorityQueue<>(), small = new PriorityQueue<>((a, b) -> b - a);


    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() + small.peek()) / 2.0;
    }
}

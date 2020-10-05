package com.hotel.queue;

public class MyCircularQueue {
    public static void main(String[] args){
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the queue is full
        circularQueue.Rear();  // return 3
        circularQueue.isFull();  // return true
        circularQueue.deQueue();  // return true
        circularQueue.enQueue(4);  // return true
        circularQueue.Rear();  // return 4
    }

    int size, slow, fast, C;
    int data [];
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        slow = 0; fast = -1; size = 0; C = k;
        data = new int [k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        fast = (fast + 1) % C;
        data[fast] = value;
        size ++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0) return false;
        slow = (slow + 1) % C;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return data[slow];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        return data[fast];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == C;
    }
}

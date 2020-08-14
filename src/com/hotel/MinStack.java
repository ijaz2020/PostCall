package com.hotel;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

class MinStack {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    ArrayDeque<int[]> aq = null;
    /** initialize your data structure here. */
    public MinStack() {
        aq = new ArrayDeque<>();
    }

    public void push(int x) {
        if(aq.isEmpty()){
            aq.push(new int[]{x, x});
        }else{
            aq.push(new int[]{x, Math.min(x,  aq.getLast()[1])});
        }
        System.out.println(Arrays.toString(aq.toArray()));
    }

    public void pop() {
        aq.pollLast();
    }

    public int top() {
        return aq.getLast()[0];
    }

    public int getMin() {
        return aq.getLast()[1];
    }
}

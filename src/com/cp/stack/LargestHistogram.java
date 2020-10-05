package com.hotel.stack;

import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int[] nums = {5,4,3,3,1};
        System.out.println(new LargestHistogram().largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] h) {
        int n = h.length, i = 0, max = 0;

        Stack<Integer> s = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max,
                        h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
            }
            // put current bar's index to the stack
            s.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!s.isEmpty()) {
            max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
        }

        return max;
    }
}

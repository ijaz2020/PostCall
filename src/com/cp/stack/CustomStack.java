package com.hotel.stack;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    int maxSize;
    List<Integer> arr = null;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new ArrayList<>();
    }

    public void push(int x) {
        if(arr.size() == maxSize) return;
        arr.add(x);
    }

    public int pop() {
        if(arr.size() == 0) return -1;
        return arr.remove(arr.size()-1);
    }

    public void increment(int k, int val) {
        for(int i = 0; i< Math.min(k,arr.size()); i++){
            arr.set(i, arr.get(i) + val);
        }
    }
}

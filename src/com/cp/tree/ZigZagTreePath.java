package com.hotel.tree;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTreePath {
    public static void main(String[] args) {
        System.out.println(new ZigZagTreePath().pathInZigZagTree(14));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        while (label != 0) {
            res.add(0, label);
            label /= 2;
        }
        for (int i = res.size() - 2; i >= 0; i -= 2) {
            res.set(i, (1 << i) + (1 << (i + 1)) - 1 - res.get(i));
        }
        return res;
    }
}

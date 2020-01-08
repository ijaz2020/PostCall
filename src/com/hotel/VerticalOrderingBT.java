package com.hotel;


import com.hotel.tree.TreeNode;

import java.util.*;

public class VerticalOrderingBT {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> orderList = new ArrayList<>();

        if(root == null) return orderList;

        Map<Integer, List<Integer>> hd = new TreeMap<>();

        hd = verticalDistance(root, hd, 0);

        for(Map.Entry<Integer, List<Integer>> entry: hd.entrySet()){
            Collections.sort(entry.getValue());
            orderList.add(entry.getValue());
        }

        return orderList;
    }

    private Map verticalDistance(TreeNode t, Map<Integer, List<Integer>> hd, int distance){

        if(t == null){
            return hd;
        }

        List<Integer> list = hd.getOrDefault(distance, new LinkedList<Integer>());

        list.add(t.val);

        hd.put(distance, list);


        if(t.left != null){
            verticalDistance(t.left, hd, distance - 1);
        }
        if(t.right !=null){
            verticalDistance(t.right, hd, distance + 1);
        }
        return hd;
    }
}
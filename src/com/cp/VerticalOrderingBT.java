package com.hotel;


import com.hotel.tree.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class VerticalOrderingBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(new VerticalOrderingBT().verticalTraversal(root));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            Integer prevLevel = null;
            while(size-- > 0){
                Pair<TreeNode, Integer> curr = q.poll();
                Integer currLevel = curr.getValue();
                int val = curr.getKey().val;
                map.computeIfAbsent(currLevel, k -> new ArrayList<>());
                List<Integer> verList = map.get(currLevel);
                if(prevLevel != null && prevLevel.equals(currLevel)
                                     && verList.get(verList.size() -1) > val){
                    Integer last = verList.remove(verList.size() - 1);
                    verList.add(val);
                    verList.add(last);
                }
                else{
                    map.get(currLevel).add(val);
                }
                if(curr.getKey().left !=null)
                    q.offer(new Pair<>(curr.getKey().left, curr.getValue()-1));
                if(curr.getKey().right !=null)
                    q.offer(new Pair<>(curr.getKey().right, curr.getValue()+1));
                prevLevel =currLevel;
            }
        }
        List<List<Integer>> orderList = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            orderList.add(entry.getValue());
        }
        return orderList;
    }

    public List<List<Integer>> verticalTraversal1(TreeNode root) {

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

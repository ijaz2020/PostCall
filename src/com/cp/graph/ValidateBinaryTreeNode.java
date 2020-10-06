package com.cp.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateBinaryTreeNode {
    public static void main(String[] args){
        int n = 6;
//        int[] leftChild = {1,-1,3,-1}, rightChild = {2,-1,-1,-1};
//        int[] leftChild = {1,-1,3,-1}, rightChild = {2,3,-1,-1};
        int[] leftChild = {1,-1,-1,4,-1,-1}, rightChild = {2,-1,-1,5,-1,-1};
        System.out.println(new ValidateBinaryTreeNode().validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    int findParent(Map<Integer, Integer> parentMap, Integer child){
        if(parentMap.get(child).equals(child)) return child;
        parentMap.put(child, findParent(parentMap, parentMap.get(child)));
        return parentMap.get(child);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        for(int i=0; i< n; i++)
            parentMap.put(i, i);

        if(!findAndUpdateParent(parentMap, leftChild)) return false;
        if(!findAndUpdateParent(parentMap, rightChild)) return false;
        int components =1;
        for(Integer key: parentMap.keySet()){
            if(key.equals(parentMap.get(key)))
                components--;
            if(components <0) return false;
        }

        return true;
    }

    boolean findAndUpdateParent(Map<Integer, Integer> parentMap, int[] children){
        for(int i =0; i<children.length; i++){
            if(children[i] == -1) continue;
            int p1 = findParent(parentMap, i);
            int p2 = findParent(parentMap, children[i]);
            if(p1 == p2) return false;
            else {
                parentMap.put(p2, p1);
            }
        }
        return true;
    }
}

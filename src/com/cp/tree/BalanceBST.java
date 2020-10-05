package com.cp.tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.right =new TreeNode(2);
        node.right.right =new TreeNode(3);
        node.right.right.right =new TreeNode(4);
        System.out.println(new BalanceBST().balanceBST(node));
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedArr = new ArrayList<>();
        addBST(root, sortedArr);
        return sortedArrayToBST(sortedArr);
    }

    void addBST(TreeNode node, List<Integer> sortedArr){
        if (node == null) return;
        addBST(node.left, sortedArr);
        sortedArr.add(node.val);
        addBST(node.right, sortedArr);
    }

    public TreeNode sortedArrayToBST(List<Integer> num) {
        if (num.size() == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.size() - 1);
        return head;
    }

    public TreeNode helper(List<Integer> num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num.get(mid));
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}

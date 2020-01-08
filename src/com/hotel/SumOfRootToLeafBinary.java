package com.hotel;

import com.hotel.tree.TreeNode;

public class SumOfRootToLeafBinary {
    public static void main(String[] args){
        SumOfRootToLeafBinary s = new SumOfRootToLeafBinary();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(s.sumRootToLeaf(root));
    }
    private int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        int left,right;
         if(root.left == root.right) {
             return val;
         }
         else{
             left = dfs(root.left, val);
             right = dfs(root.right, val);
         }

         return left+right;
    }
}

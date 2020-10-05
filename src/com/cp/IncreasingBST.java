package com.cp;

import com.cp.tree.TreeNode;

public class IncreasingBST {
    public static void main(String[] args){
        IncreasingBST i = new IncreasingBST();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.right = new TreeNode(6);
        treeNode.right.right =new TreeNode(8);
        treeNode.right.right.left = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(9);
        TreeNode result = i.increasingBST(treeNode);
        System.out.println(result);
    }

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}

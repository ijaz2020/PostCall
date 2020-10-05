package com.cp.tree;

public class DistributeCoins {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(0);
        TreeVisualizer.print(treeNode);
        System.out.println(new DistributeCoins().distributeCoins(treeNode));
    }
    int moves;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        int left, right;
        left = distributeCoins(root.left);
        right = distributeCoins(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return root.val +left + right -1;
    }
}

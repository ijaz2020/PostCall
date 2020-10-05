package com.cp.tree;

public class DeleteLeavesWithGivenValue {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        TreeVisualizer.print(root);
        System.out.println(new DeleteLeavesWithGivenValue().removeLeafNodes(root, 2));
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null || (root.left ==null && root.right == null && root.val == target))
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root;
    }
}

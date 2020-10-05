package com.cp.tree;

import java.util.ArrayList;
import java.util.List;

public class RemovesLeaves {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        TreeVisualizer.print(treeNode);
        System.out.println();
        TreeVisualizer.print(new RemovesLeaves().removeLeafNodes(treeNode, 2));
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root.left !=null)
            root.left = removeLeafNodes(root.left, target);
        if(root.right !=null)
            root.right = removeLeafNodes(root.right, target);
        return (root.left == root.right && root.val == target) ? null : root;
    }

}

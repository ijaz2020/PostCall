package com.hotel.tree;

public class LCABST {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        TreeNode p = new TreeNode(6);
        treeNode.left.left = p;
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        treeNode.left.right.right = q;
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        TreeVisualizer.print(treeNode);
        System.out.println(new LCABST().lowestCommonAncestor(treeNode, p, q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val > root.val ? root.left : root.right;
        return root;
    }
}

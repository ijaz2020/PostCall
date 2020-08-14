package com.hotel.tree;

public class IOSFirst {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        TreeVisualizer.print(tree);
        tree.insert(30);
        TreeVisualizer.print(tree);
        tree.insert(20);
        TreeVisualizer.print(tree);
        tree.insert(40);
        TreeVisualizer.print(tree);
        tree.insert(70);
        TreeVisualizer.print(tree);
        tree.insert(60);
        TreeVisualizer.print(tree);
        tree.insert(80);
        TreeVisualizer.print(tree);
        System.out.println(new IOSFirst().inorderSuccessor(tree.root ,tree.root.left.right));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;

        TreeNode next = null;
        TreeNode c = root;
        while(c!=null && c.val!=p.val){
            if(c.val > p.val){
                next = c;
                c = c.left;
            }else{
                c= c.right;
            }
        }

        if(c==null)
            return null;

        if(c.right==null)
            return next;

        c = c.right;
        while(c.left!=null)
            c = c.left;

        return c;
    }
}

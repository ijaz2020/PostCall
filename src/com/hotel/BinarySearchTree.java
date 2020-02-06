package com.hotel;

import com.hotel.tree.TreeNode;
import com.hotel.tree.TreeVisualizer;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree implements TreeVisualizer.Visualized {

    @Override
    public TreeVisualizer.Visualized getLeft() {
        return this.root.left;
    }

    @Override
    public TreeVisualizer.Visualized getRight() {
        return this.root.right;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.root.val);
    }
    public TreeNode root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        return magicRec(root, L, R, 0);
    }

    private int magicRec(TreeNode root, int L, int R, int count){

        if(root == null)
         return count;
        if(root.val >= L && root.val <= R){
            count+= root.val;
        }
        magicRec(root.left, L, R, count);
        magicRec(root.right, L, R, count);
        return count;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
//        10,5,15,3,7,null,18
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(tree.rangeSumBST(tree.root, 30, 60 ));

    }
}

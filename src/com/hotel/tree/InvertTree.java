package com.hotel.tree;

import com.hotel.Utils.PrintUtils;

public class InvertTree {
  public static void main(String[] args) {
  /*       4
      /   \
    2     7
      / \   / \
    1   3 6   9*/

    TreeNode t = new TreeNode(4);
    t.left =  new TreeNode(2);
    t.right = new TreeNode(7);
    t.left.left = new TreeNode(1);
    t.left.right = new TreeNode(3);
    t.right.left = new TreeNode(6);
    t.right.right = new TreeNode(9);
    TreeVisualizer.print(t);
    TreeVisualizer.print(new InvertTree().invertTree(t));
  }

  public TreeNode invertTree(TreeNode root) {
    dfs(root);
    return root;
  }

  void dfs(TreeNode root){
    if(root == null) return;
    swap(root);
    dfs(root.left);
    dfs(root.right);
  }

  void swap(TreeNode root){
    TreeNode t = root.left;
    root.left = root.right;
    root.right = t;
  }
}

package com.cp.tree;

public class KthSmallest {
  public static void main(String[] args) {
    TreeNode r = new TreeNode(5);
    r.left = new TreeNode(3);
    r.right = new TreeNode(6);
    r.left.right = new TreeNode(4);
    r.left.left = new TreeNode(2);
    r.left.left.left = new TreeNode(1);
    System.out.println(new KthSmallest().kthSmallest(r,3));
  }

  int res = -1;
  Integer l;
  public int kthSmallest(TreeNode root, int k) {
    l = k;
    return dfs(root, l);
  }

  private int dfs(TreeNode root, Integer l) {
    if(root == null) return -1;
    dfs(root.left, l);
    l = l - 1;
    if(l ==0 && res == -1)res = root.val;
    dfs(root.right, l);
    return res;
  }



}

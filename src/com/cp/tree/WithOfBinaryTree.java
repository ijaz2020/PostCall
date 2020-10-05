package com.cp.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WithOfBinaryTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(2);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(1);
    root.left.left.left = new TreeNode(5);
    root.left.left.right = new TreeNode(1);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(-1);
    root.right.left.right = new TreeNode(6);
    root.right.right.right = new TreeNode(8);

//    System.out.println(new WithOfBinaryTree().widthOfBinaryTree(root));
    System.out.println(new WithOfBinaryTree().widthOfBinaryTree1(root));
  }


  public int widthOfBinaryTree1(TreeNode root) {
    Deque<TreeNode> deque = new LinkedList<>(); // initialize deque
    LinkedList<Integer> a = new LinkedList<>();
    deque.add(root); // add root node in deque
    int maxWidth = 0;
    while (!deque.isEmpty()) {
      int size = deque.size(); // size of current level
      maxWidth = Math.max(maxWidth, size);
      while (size-- > 0) {
        TreeNode node = deque.poll();
        if (node == null) { // node was null then to maintain add both left and right as null
          deque.add(null);
          deque.add(null);
        } else {
          deque.add(node.left);
          deque.add(node.right);
        }
      }
      while (!deque.isEmpty() && deque.peekFirst() == null)
        deque.pollFirst(); // remove all the null from the start until encounter first last non null node of level
      while (!deque.isEmpty() && deque.peekLast() == null)
        deque.pollLast(); // remove all the null from the last until encounter last non null node of level
    }
    return maxWidth;
  }

  public int widthOfBinaryTree(TreeNode root) {
    int res = 0;
    if(root == null) return res;
    Deque<TreeNode> aq = new LinkedList<>();
    aq.offer(root);
    while (!aq.isEmpty()){
      int size = aq.size();
      res = Math.max(res, size);
      while (size-- > 0){
        TreeNode curr = aq.poll();
        if(curr == null ){
          aq.offer(null);
          aq.offer(null);
        }
        else{
          aq.offer(curr.left);
          aq.offer(curr.right);
        }
      }
      removeUnwantedNullNode(aq);
    }
    return res;
  }

  private void removeUnwantedNullNode(Deque<TreeNode> level) {
    while (!level.isEmpty() && level.peekFirst() ==null){
      level.pollFirst();
    }
    while (!level.isEmpty() && level.peekLast() ==null){
      level.pollLast();
    }
  }
}

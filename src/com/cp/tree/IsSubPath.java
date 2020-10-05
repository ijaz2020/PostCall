package com.cp.tree;

import com.cp.LinkedList.ListNode;

public class IsSubPath {
    public static void main(String[] args){
        /*[4,2,8]
[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]*/
        ListNode head = null/*new ListNode(1)*/;
/*        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);*/
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left  = new TreeNode(1);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.left.left  = new TreeNode(6);
        treeNode.right.left.right = new TreeNode(8);
        treeNode.right.left.right.left = new TreeNode(1);
        treeNode.right.left.right.right = new TreeNode(3);
        System.out.println(new IsSubPath().isSubPath(head, treeNode));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        ListNode dummy = head;
        boolean left = false, right = false;
        if(checkSubPath(dummy, root))
            return true;
        left = isSubPath(head, root.left);
        right = isSubPath(head, root.right);
        return left || right;
    }

    boolean checkSubPath(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return false;
        boolean left = false, right =false;
        if(root.val == head.val){
            ListNode next = head.next;
            left = checkSubPath(next, root.left);
            right = checkSubPath(next, root.right);
        }
        return left || right;
    }
}

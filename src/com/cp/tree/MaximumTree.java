package com.cp.tree;
import com.cp.VerticalOrderingBT;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumTree {
    public static void main(String[] args){
        int[] nums  = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(nums).val);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}

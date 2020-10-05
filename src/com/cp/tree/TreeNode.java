package com.cp.tree;


public class TreeNode implements TreeVisualizer.Visualized {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }


        @Override
        public TreeVisualizer.Visualized getLeft() {
                return this.left;
        }

        @Override
        public TreeVisualizer.Visualized getRight() {
                return this.right;
        }

        @Override
        public String getValue() {
                return String.valueOf(this.val);
        }

        @Override
        public String toString() {
                return getValue();
        }
}

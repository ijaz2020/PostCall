package com.hotel;

public class Smallestfromleaf {
    public static void main(String[] args){
        Smallestfromleaf s = new Smallestfromleaf();
        TreeNode treeNode = new TreeNode(25);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(2);
        System.out.println(s.smallestFromLeaf(treeNode));
    }
    String result="";
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return result;
        StringBuilder sb =new StringBuilder();
        sb.append(((char) (root.val+'a')));
        findLeafOfAllPaths(root, sb);
        return result;
    }

    private StringBuilder findLeafOfAllPaths(TreeNode root, StringBuilder current){
        if(root.left == null && root.right == null) {
            String leaf = current.reverse().toString();
            if (result.equals("") || leaf.compareTo(result) < 0)
                result = leaf;
            current.reverse();
        }
        if(root.left != null)
            current = findLeafOfAllPaths(root.left, current.append((char) (root.left.val + 'a') ));

        if(root.right != null)
            current =findLeafOfAllPaths(root.right, current.append((char) (root.right.val + 'a') ));

        current.setLength(current.length() -1);
        return current;
    }
}

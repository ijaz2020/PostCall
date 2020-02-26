package com.hotel.tree;

public class TreeCamera {
    public static void main(String[] args){

        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(0);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.left.left = new TreeNode(0);
        treeNode.left.left.left.right = new TreeNode(0);
        System.out.println(new TreeCamera().minCameraCover(treeNode));
    }

    public enum Status {NOT_NEEDED, NO_CAMERA, HAS_CAMERA}
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root) == Status.NO_CAMERA)
            cameras++;
        return cameras;
    }

    Status dfs(TreeNode node){
        if(node == null) return Status.NOT_NEEDED;
        Status left = dfs(node.left);
        Status right = dfs(node.right);
        TreeVisualizer.print(node);
        if(left ==Status.NO_CAMERA || right == Status.NO_CAMERA){
            cameras++;
            return Status.HAS_CAMERA;
        }
        else if( left == Status.HAS_CAMERA || right == Status.HAS_CAMERA){
            return Status.NOT_NEEDED;
        }
        else{
            return Status.NO_CAMERA;
        }
    }



/*    private int NOT_MONITORED = 0;
    private int MONITORED_NOCAM = 1;
    private int MONITORED_WITHCAM = 2;
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        int top = dfs(root);
        return cameras + (top == NOT_MONITORED ? 1 : 0);
    }

    private int dfs(TreeNode root) {
        if (root == null) return MONITORED_NOCAM;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
            return NOT_MONITORED;
        } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITHCAM;
        } else {
            return MONITORED_NOCAM;
        }
    }*/
}


package com.anuragkapur.ds.tree;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int payload;

    public TreeNode(int payload) {
        this.payload = payload;
        left = null;
        right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }
}

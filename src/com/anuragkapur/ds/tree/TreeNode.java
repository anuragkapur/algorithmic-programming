package com.anuragkapur.ds.tree;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private int key;

    public TreeNode(int payload) {
        this.key = payload;
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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (key != treeNode.key) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return key;
    }
}

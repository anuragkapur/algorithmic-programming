package com.anuragkapur.leetcode;

/**
 * Problem #226 https://leetcode.com/problems/invert-binary-tree/
 *
 * @author anuragkapur
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

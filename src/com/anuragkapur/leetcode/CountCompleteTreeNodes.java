package com.anuragkapur.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null)  {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            int height = 0;
            for (int i=0; i<=leftHeight; i++) {
                height += Math.pow(2, i);
            }
            return height;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int leftHeight(TreeNode root) {
        int height = -1;
        while (root != null) {
            height ++;
            root = root.left;
        }
        return height;
    }

    private int rightHeight(TreeNode root) {
        int height = -1;
        while (root != null) {
            height ++;
            root = root.right;
        }
        return height;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
package com.anuragkapur.leetcode.fb2021;

public class BinaryTreeMaxPathSum_124 {
    int maxSum = Integer.MIN_VALUE;

    /**
     * RTC: O(n)
     * where,
     *  n = number of nodes in tree
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int newPathCost = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPathCost);

        return node.val + Math.max(leftGain, rightGain);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }
}

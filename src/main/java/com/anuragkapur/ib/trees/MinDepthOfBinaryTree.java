package com.anuragkapur.ib.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinDepthOfBinaryTree {

    Deque<TreeNode> q = new ArrayDeque<>();

    /**
     * Best RTC: O(1)
     * Average: ...
     * Worst RTC: O(n)
     */
    public int minDepth(TreeNode A) {
        q.add(A);
        int depth = 0;

        while (!q.isEmpty()) {
            Deque<TreeNode> nextLevelQ = new ArrayDeque<>();
            depth ++;
            while(!q.isEmpty()) {
                TreeNode node = q.remove();

                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null)
                    nextLevelQ.add(node.left);

                if (node.right != null)
                    nextLevelQ.add(node.right);
            }
            q = nextLevelQ;
        }

        // this isn't possible
        return -1;
    }

    /**
     * RTC: O(n)
     *   where n = number of nodes in tree
     *   Depth-first traversal
     * Best, average, worst case RTC is the same
     */
    public int minDepth1(TreeNode A) {
        return minDepth(A, 1);
    }

    private int minDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return currentDepth - 1;
        }

        if (node.left == null && node.right == null) {
            return currentDepth;
        }

        int leftDepth = Integer.MAX_VALUE;
        if (node.left != null) {
            leftDepth = minDepth(node.left, currentDepth + 1);
        }

        int rightDepth = Integer.MAX_VALUE;
        if (node.right != null) {
            rightDepth = minDepth(node.right, currentDepth + 1);
        }

        return Math.min(leftDepth, rightDepth);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}

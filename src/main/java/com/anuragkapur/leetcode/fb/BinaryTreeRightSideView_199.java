package com.anuragkapur.leetcode.fb;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {

    /**
     * RTC: O(n)
     * where,
     *  n = number of nodes in tree
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> levelQ = new ArrayDeque<>();
            TreeNode node = null;
            while (!q.isEmpty()) {
                node = q.poll();
                if (node.left != null) {
                    levelQ.add(node.left);
                }
                if (node.right != null) {
                    levelQ.add(node.right);
                }
            }
            if (node != null)
                answer.add(node.val);
            q = levelQ;
        }

        return answer;
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

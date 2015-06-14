package com.anuragkapur.leetcode;

import java.util.Deque;
import java.util.LinkedList;

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

        if(root == null) {
            return -1;
        }

        // compute height
        TreeNode current = root;
        int height = -1;
        while(current != null) {
            height ++;
            current = current.left;
        }

        // count leaves
        int leaves = countLeaves(root, height);

        // compute node count
        int count = 0;
        for(int i=0; i<height; i++) {
            count += Math.pow(2, i);
        }
        count += leaves;

        return count;
    }

    private int countLeaves(TreeNode root, int height) {

        int leaves = 0;
        Deque<TreeNodeWithLevel> stack = new LinkedList<>();
        stack.push(new TreeNodeWithLevel(root, 0));
        boolean incompleteBranchFound = false;

        while(!stack.isEmpty()) {

            if (incompleteBranchFound) {
                break;
            }

            TreeNodeWithLevel current = stack.pop();

            if (current.level == height) {
                leaves ++;
            } else {
                if (current.treeNode.right == null) {
                    incompleteBranchFound = true;
                }
                if (current.treeNode.left != null) {
                    leaves ++;
                }
            }

            if (current.treeNode.right != null) {
                stack.push(new TreeNodeWithLevel(current.treeNode.right, current.level+1));
            }
            if (current.treeNode.left != null) {
                stack.push(new TreeNodeWithLevel(current.treeNode.left, current.level+1));
            }
        }

        return leaves;
    }

    private class TreeNodeWithLevel {
        TreeNode treeNode;
        int level;
        TreeNodeWithLevel(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
package com.anuragkapur.ib.trees;

import java.util.Stack;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);

        while(!stack.isEmpty()){
            Stack<TreeNode> newStack = new Stack();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    newStack.add(node.left);
                }
                if (node.right != null) {
                    newStack.add(node.right);
                }

                TreeNode left = node.left;
                TreeNode right = node.right;

                node.left = right;
                node.right = left;
            }
            stack = newStack;
        }

        return A;
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

package com.anuragkapur.ib.trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);
        boolean zig = false;

        while (!stack.isEmpty()) {
            Stack<TreeNode> newStack = new Stack<>();
            ArrayList<Integer> values = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                values.add(node.val);
                if (zig) {
                    if (node.right != null) {
                        newStack.add(node.right);
                    }
                    if (node.left != null) {
                        newStack.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        newStack.add(node.left);
                    }
                    if (node.right != null) {
                        newStack.add(node.right);
                    }
                }
            }
            stack = newStack;
            answer.add(values);
            zig = !zig;
        }

        return answer;
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

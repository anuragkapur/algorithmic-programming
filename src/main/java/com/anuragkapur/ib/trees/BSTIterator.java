package com.anuragkapur.ib.trees;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addAllLeftNodes(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            addAllLeftNodes(top.right);
        }
        return top.val;
    }

    private void addAllLeftNodes(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

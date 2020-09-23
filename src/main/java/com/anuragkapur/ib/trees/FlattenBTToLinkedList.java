package com.anuragkapur.ib.trees;

public class FlattenBTToLinkedList {
    public TreeNode flatten(TreeNode a) {
        flattenRecursively(a);
        return a;
    }

    private void flattenRecursively(TreeNode node) {

        if (node == null) {
            return;
        }

        if (!isFlat(node)) {
            moveNodeToRigthMostPath(node.left, node.right);
            node.right = node.left;
            node.left = null;
        }

        flattenRecursively(node.right);
    }

    private boolean isFlat(TreeNode node) {
        // check no left branch
        return node.left == null;
    }

    private void moveNodeToRigthMostPath(TreeNode root, TreeNode node) {
        // add to rightmost position
        if (node != null) {
            while(root.right != null) {
                root = root.right;
            }
            root.right = node;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
  }
}

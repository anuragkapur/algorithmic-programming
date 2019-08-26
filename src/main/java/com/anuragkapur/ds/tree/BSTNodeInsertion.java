package com.anuragkapur.ds.tree;

/**
 * @author anuragkapur
 */
public class BSTNodeInsertion {

    public static TreeNode insert(TreeNode root, TreeNode nodeToInsert) {

        TreeNode predecessor = null;
        TreeNode current = root;
        while (current != null) {
            predecessor = current;
            if (nodeToInsert.getKey() <= current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (predecessor == null) {
            // empty tree
            root = nodeToInsert;
        } else {
            if (nodeToInsert.getKey() <= predecessor.getKey()) {
                predecessor.setLeft(nodeToInsert);
            } else {
                predecessor.setRight(nodeToInsert);
            }
        }

        return root;
    }
}

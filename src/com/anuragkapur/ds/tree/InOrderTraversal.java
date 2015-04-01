package com.anuragkapur.ds.tree;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class InOrderTraversal {

    public static void inOrder(TreeNode startingNode) {

        if (startingNode != null) {
            inOrder(startingNode.getLeft());
            System.out.println(startingNode.getKey());
            inOrder(startingNode.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode = TreeFactory.getBalancedBinaryTree();
        inOrder(rootNode);
    }
}

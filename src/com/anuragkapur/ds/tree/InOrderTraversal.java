package com.anuragkapur.ds.tree;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class InOrderTraversal {

    private static void inOrder(TreeNode startingNode) {

        if (startingNode != null) {
            inOrder(startingNode.getLeft());
            System.out.println(startingNode.getPayload());
            inOrder(startingNode.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode = BalancedTreeFactory.getBalancedBinaryTree();
        inOrder(rootNode);
    }
}

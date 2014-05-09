package com.anuragkapur.ds.tree;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class PreOrderTraversal {

    private static void preOrder(TreeNode startingNode) {

        if (startingNode != null) {
            System.out.println(startingNode.getPayload());
            preOrder(startingNode.getLeft());
            preOrder(startingNode.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode = TreeFactory.getBalancedBinaryTree();
        preOrder(rootNode);
    }

}

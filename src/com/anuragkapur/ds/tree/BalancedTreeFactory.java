package com.anuragkapur.ds.tree;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class BalancedTreeFactory {

    /**
     * @return Root node of a balanced binary tree. The tree may/may not be 'complete'.
     */
    public static TreeNode getBalancedBinaryTree() {

        /*
                       4
                 1           3
              2     4     5     7
                  2          6
         */

        TreeNode rootNode = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(6);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        node4.setLeft(node7);

        node6.setLeft(node8);

        return rootNode;
    }
}

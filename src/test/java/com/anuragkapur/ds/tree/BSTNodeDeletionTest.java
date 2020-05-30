package com.anuragkapur.ds.tree;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BSTNodeDeletionTest {

    // TODO: Complete implementation and test
    @Ignore
    @Test
    public void testDeleteNode() throws Exception {

        /*
                       6
                 3           9
              1     5     7     10
                2 4         8
         */

        TreeNode rootNode = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(8);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setParent(rootNode);
        node2.setParent(rootNode);

        node1.setLeft(node3);
        node1.setRight(node4);
        node3.setParent(node1);
        node4.setParent(node1);

        node2.setLeft(node5);
        node2.setRight(node6);
        node5.setParent(node2);
        node6.setParent(node2);

        node3.setRight(node7);
        node7.setParent(node3);

        node4.setLeft(node8);
        node8.setParent(node4);

        node5.setRight(node9);
        node9.setParent(node5);

        BSTNodeDeletion nodeDeletion = new BSTNodeDeletion();
        TreeNode newRootNode = nodeDeletion.deleteNode(rootNode, node1);

        //InOrderTraversal.inOrder(newRootNode);

    }
}
package com.anuragkapur.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BSTSuccessorTest {

    @Test
    public void testGetSuccessor() throws Exception {
        /*
                       6
                 3           8
              2     5     7     10
                  4           9
         */

        TreeNode rootNode = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(9);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);
        node1.setParent(rootNode);

        node2.setLeft(node5);
        node2.setRight(node6);
        node2.setParent(rootNode);

        node3.setParent(node1);

        node4.setLeft(node7);
        node4.setParent(node1);

        node5.setParent(node2);

        node6.setLeft(node8);
        node6.setParent(node2);

        node7.setParent(node4);

        node8.setParent(node6);

        BSTSuccessorAndPredecessor bstSuccessorAndPredecessor = new BSTSuccessorAndPredecessor();
        assertEquals(node7.getKey(), bstSuccessorAndPredecessor.getSuccessor(node1).getKey());
        assertEquals(node8.getKey(), bstSuccessorAndPredecessor.getSuccessor(node2).getKey());
        assertEquals(node1.getKey(), bstSuccessorAndPredecessor.getSuccessor(node3).getKey());
        assertEquals(rootNode.getKey(), bstSuccessorAndPredecessor.getSuccessor(node4).getKey());
        assertEquals(node2.getKey(), bstSuccessorAndPredecessor.getSuccessor(node5).getKey());
        assertEquals(null, bstSuccessorAndPredecessor.getSuccessor(node6));
        assertEquals(node4.getKey(), bstSuccessorAndPredecessor.getSuccessor(node7).getKey());
        assertEquals(node6.getKey(), bstSuccessorAndPredecessor.getSuccessor(node8).getKey());

    }

    @Test
    public void testGetPredecessor() throws Exception {
        /*
                       6
                 3           8
              2     5     7     10
                  4           9
         */

        TreeNode rootNode = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(9);

        rootNode.setLeft(node1);
        rootNode.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);
        node1.setParent(rootNode);

        node2.setLeft(node5);
        node2.setRight(node6);
        node2.setParent(rootNode);

        node3.setParent(node1);

        node4.setLeft(node7);
        node4.setParent(node1);

        node5.setParent(node2);

        node6.setLeft(node8);
        node6.setParent(node2);

        node7.setParent(node4);

        node8.setParent(node6);

        BSTSuccessorAndPredecessor bstSuccessorAndPredecessor = new BSTSuccessorAndPredecessor();
        assertEquals(node3.getKey(), bstSuccessorAndPredecessor.getPredecessor(node1).getKey());
        assertEquals(node5.getKey(), bstSuccessorAndPredecessor.getPredecessor(node2).getKey());
        assertEquals(null, bstSuccessorAndPredecessor.getPredecessor(node3));
        assertEquals(node7.getKey(), bstSuccessorAndPredecessor.getPredecessor(node4).getKey());
        assertEquals(rootNode.getKey(), bstSuccessorAndPredecessor.getPredecessor(node5).getKey());
        assertEquals(node8.getKey(), bstSuccessorAndPredecessor.getPredecessor(node6).getKey());
        assertEquals(node1.getKey(), bstSuccessorAndPredecessor.getPredecessor(node7).getKey());
        assertEquals(node2.getKey(), bstSuccessorAndPredecessor.getPredecessor(node8).getKey());

    }
}
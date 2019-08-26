package com.anuragkapur.ds.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BSTNodeInsertionTest {

    @Test
    public void testInsert1() throws Exception {
        TreeNode root = TreeFactory.getBinarySearchTree();
        root = BSTNodeInsertion.insert(root, new TreeNode(11));

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrder(root);
        assertEquals("[2, 3, 4, 5, 6, 7, 8, 9, 10, 11]", inOrderTraversal.getResult().toString());
    }

    @Test
    public void testInsert2() throws Exception {
        TreeNode root = TreeFactory.getBinarySearchTreeForInsertionTest1();
        root = BSTNodeInsertion.insert(root, new TreeNode(3));

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrder(root);
        assertEquals("[2, 3, 4, 5, 6, 7, 8, 9, 10]", inOrderTraversal.getResult().toString());
    }
}
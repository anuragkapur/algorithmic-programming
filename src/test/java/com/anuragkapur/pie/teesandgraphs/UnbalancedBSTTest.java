package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class UnbalancedBSTTest {

    UnbalancedBST unbalancedBST = new UnbalancedBST();
    Inorder inorder = new Inorder();

    @Test
    public void testBalance1() throws Exception {

        assertNull(unbalancedBST.balance(null));
    }

    @Test
    public void testBalance2() throws Exception {

        Node<Integer> root = new Node<>(5);
        Node<Integer> balancedRoot = unbalancedBST.balance(root);
        assertEquals("[5]", inorder.inorder(balancedRoot).toString());
    }

    @Test
    public void testBalance3() throws Exception {

        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);

        node6.setLeft(node4);
        node6.setRight(node7);
        node4.setLeft(node2);
        node4.setRight(node5);
        node2.setLeft(node1);
        node2.setRight(node3);

        Node<Integer> balancedRoot = unbalancedBST.balance(node6);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", inorder.inorder(balancedRoot).toString());
    }
}
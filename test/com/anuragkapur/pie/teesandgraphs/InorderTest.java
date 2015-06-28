package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class InorderTest {

    private Inorder inorder = new Inorder();

    @Test
    public void testInorder1() throws Exception {

        assertNull(inorder.inorder(null));
    }

    @Test
    public void testInorder2() throws Exception {

        Node<Integer> root = new Node<>(10);
        assertEquals("[10]", inorder.inorder(root).toString());
    }

    @Test
    public void testInorder3() throws Exception {

        Node<Integer> root = new Node<>(4);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node7 = new Node<>(7);

        root.setLeft(node2);
        root.setRight(node6);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setLeft(node5);
        node6.setRight(node7);

        assertEquals("[1, 2, 3, 4, 5, 6, 7]", inorder.inorder(root).toString());
    }

    @Test
    public void testInorder4() throws Exception {

        Node<Integer> root = new Node<>(4);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node3 = new Node<>(3);

        root.setLeft(node2);
        node2.setLeft(node1);
        node2.setRight(node3);

        assertEquals("[1, 2, 3, 4]", inorder.inorder(root).toString());
    }
}
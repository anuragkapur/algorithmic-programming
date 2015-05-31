package com.anuragkapur.pie.teesandgraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BinaryTreeToHeapTest {

    BinaryTreeToHeap binaryTreeToHeap = new BinaryTreeToHeap();
    Inorder inorder = new Inorder();

    @Test
    public void testConvert() throws Exception {

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);

        node4.setLeft(node2);
        node4.setRight(node6);

        node2.setLeft(node1);
        node2.setRight(node3);

        node6.setLeft(node5);
        node6.setRight(node7);

        Node<Integer> heapRoot = binaryTreeToHeap.convert(node4);

        assertEquals("[4, 6, 3, 7, 2, 5, 1]", inorder.inorder(heapRoot).toString());
    }
}
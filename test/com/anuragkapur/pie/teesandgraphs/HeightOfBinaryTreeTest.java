package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class HeightOfBinaryTreeTest {

    HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();

    @Test
    public void testGetHeight1() throws Exception {
        assertEquals(0, heightOfBinaryTree.getHeight(null));
    }

    @Test
    public void testGetHeight2() throws Exception {
        Node<Integer> node = new Node<>();
        assertEquals(0, heightOfBinaryTree.getHeight(node));
    }

    @Test
    public void testGetHeight3() throws Exception {
        Node<Integer> node = new Node<>();
        Node<Integer> node1 = new Node<>();
        Node<Integer> node2 = new Node<>();
        node.setLeft(node1);
        node.setRight(node2);
        assertEquals(1, heightOfBinaryTree.getHeight(node));
    }

    @Test
    public void testGetHeight4() throws Exception {
        Node<Integer> node = new Node<>();
        Node<Integer> node1 = new Node<>();
        Node<Integer> node2 = new Node<>();
        Node<Integer> node3 = new Node<>();
        node.setRight(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        assertEquals(2, heightOfBinaryTree.getHeight(node));
    }
}
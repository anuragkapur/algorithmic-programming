package com.anuragkapur.ctci.treeandgraphs;

import com.anuragkapur.ds.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class Prob4_9_AllPathsTotalToxTest {

    Prob4_9_AllPathsTotalTox allPathsTotalTox = new Prob4_9_AllPathsTotalTox();

    @Test
    public void testAllPaths() throws Exception {
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> nodeMinus2 = new Node<>(-2);

        node4.setLeft(node3);
        node4.setRight(node5);
        node3.setLeft(node2);
        node3.setRight(node1);
        node5.setLeft(node6);
        node5.setRight(nodeMinus2);

        assertEquals("", allPathsTotalTox.allPaths(node4, 7).toString());

    }
}
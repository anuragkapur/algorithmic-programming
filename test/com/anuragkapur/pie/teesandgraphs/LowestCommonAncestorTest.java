package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class LowestCommonAncestorTest {

    LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
    Node<Integer> root;

    @Before
    public void setup() {
        root = new Node<>(20);
        Node<Integer> node8 = new Node<>(8);
        Node<Integer> node22 = new Node<>(22);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node12 = new Node<>(12);
        Node<Integer> node10 = new Node<>(10);
        Node<Integer> node14 = new Node<>(14);
        Node<Integer> node30 = new Node<>(30);

        root.setLeft(node8);
        root.setRight(node22);

        node8.setLeft(node4);
        node8.setRight(node12);

        node12.setLeft(node10);
        node12.setRight(node14);

        node22.setRight(node30);

    }

    @Test
    public void testLca1() throws Exception {
        assertEquals(20, lowestCommonAncestor.lca(root, 8, 22).getData().longValue());
    }

    @Test
    public void testLca2() throws Exception {
        assertEquals(8, lowestCommonAncestor.lca(root, 4, 14).getData().longValue());
    }

    @Test
    public void testLca3() throws Exception {
        assertEquals(20, lowestCommonAncestor.lca(root, 10, 30).getData().longValue());
    }
}
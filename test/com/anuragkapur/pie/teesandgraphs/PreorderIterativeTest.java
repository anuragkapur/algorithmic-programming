package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class PreorderIterativeTest {

    PreorderIterative preorderIterative = new PreorderIterative();

    @Test
    public void testPreorder1() throws Exception {
        assertEquals("[]", preorderIterative.preorder(null).toString());
    }

    @Test
    public void testPreorder2() throws Exception {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.setLeft(node2);
        Node<Integer> node3 = new Node<>(3);
        node2.setLeft(node3);
        Node<Integer> node4 = new Node<>(4);
        node2.setRight(node4);
        assertEquals("[1, 2, 3, 4]", preorderIterative.preorder(node1).toString());
    }

    @Test
    public void testPreorder3() throws Exception {
        Node<Integer> node100 = new Node<>(100);
        Node<Integer> node50 = new Node<>(50);
        Node<Integer> node150 = new Node<>(150);
        Node<Integer> node25 = new Node<>(25);
        Node<Integer> node75 = new Node<>(75);
        Node<Integer> node125 = new Node<>(125);
        Node<Integer> node175 = new Node<>(175);
        Node<Integer> node110 = new Node<>(110);

        node100.setLeft(node50);
        node100.setRight(node150);
        node50.setLeft(node25);
        node50.setRight(node75);
        node150.setLeft(node125);
        node150.setRight(node175);
        node125.setLeft(node110);

        assertEquals("[100, 50, 25, 75, 150, 125, 110, 175]", preorderIterative.preorder(node100).toString());
    }
}
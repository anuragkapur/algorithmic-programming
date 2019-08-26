package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class Prob2_5_SumInOrderListsTest {

    @Test
    public void testAddLists1() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(1);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(2);
        node1.setNext(node2);
        node2.setNext(node3);

        LinkedListNode<Integer> node4 = new LinkedListNode<>(8);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(4);
        node4.setNext(node5);
        node5.setNext(node6);

        LinkedListNode result = new Prob2_5_SumInOrderLists().addLists(node1, node4);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getData());
            result = result.getNext();
        }

        Assert.assertEquals("1166", stringBuilder.toString());
    }

    @Test
    public void testAddLists2() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(7);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(8);
        node1.setNext(node2);
        node2.setNext(node3);

        LinkedListNode<Integer> node4 = new LinkedListNode<>(6);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(8);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(4);
        node4.setNext(node5);
        node5.setNext(node6);

        LinkedListNode result = new Prob2_5_SumInOrderLists().addLists(node1, node4);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getData());
            result = result.getNext();
        }

        Assert.assertEquals("1062", stringBuilder.toString());
    }
}
package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;
import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class Prob2_5_SumListsTest {

    @Test
    public void testAddNumberLists1() throws Exception {
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

        LinkedListNode result = Prob2_5_SumLists.addDigits(node1, node4);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getData());
            result = result.getNext();
        }

        Assert.assertEquals("176", stringBuilder.toString());
    }

    @Test
    public void testAddNumberLists2() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(6);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(7);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(8);
        node1.setNext(node2);
        node2.setNext(node3);

        LinkedListNode<Integer> node4 = new LinkedListNode<>(4);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(5);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(9);
        node4.setNext(node5);
        node5.setNext(node6);

        LinkedListNode result = Prob2_5_SumLists.addDigits(node1, node4);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getData());
            result = result.getNext();
        }

        Assert.assertEquals("0381", stringBuilder.toString());
    }

    @Test
    public void testAddNumberLists3() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(7);
        node1.setNext(node2);

        LinkedListNode<Integer> node3 = new LinkedListNode<>(4);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(5);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(6);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(2);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        LinkedListNode result = Prob2_5_SumLists.addDigits(node1, node3);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getData());
            result = result.getNext();
        }

        Assert.assertEquals("7272", stringBuilder.toString());
    }
}
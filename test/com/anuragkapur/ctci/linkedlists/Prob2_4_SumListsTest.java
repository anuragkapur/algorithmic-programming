package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class Prob2_4_SumListsTest {

    @Test
    public void testAddNumberLists1() throws Exception {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode("3");
        SinglyLinkedListNode node2 = new SinglyLinkedListNode("1");
        SinglyLinkedListNode node3 = new SinglyLinkedListNode("2");
        node1.setNext(node2);
        node2.setNext(node3);

        SinglyLinkedListNode node4 = new SinglyLinkedListNode("8");
        SinglyLinkedListNode node5 = new SinglyLinkedListNode("5");
        SinglyLinkedListNode node6 = new SinglyLinkedListNode("4");
        node4.setNext(node5);
        node5.setNext(node6);

        SinglyLinkedListNode result = Prob2_4_SumLists.addNumberLists(node1, node4);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getPayload());
            result = result.getNext();
        }

        Assert.assertEquals("176", stringBuilder.toString());
    }

    @Test
    public void testAddNumberLists2() throws Exception {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode("6");
        SinglyLinkedListNode node2 = new SinglyLinkedListNode("7");
        SinglyLinkedListNode node3 = new SinglyLinkedListNode("8");
        node1.setNext(node2);
        node2.setNext(node3);

        SinglyLinkedListNode node4 = new SinglyLinkedListNode("4");
        SinglyLinkedListNode node5 = new SinglyLinkedListNode("5");
        SinglyLinkedListNode node6 = new SinglyLinkedListNode("9");
        node4.setNext(node5);
        node5.setNext(node6);

        SinglyLinkedListNode result = Prob2_4_SumLists.addNumberLists(node1, node4);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.getPayload());
            result = result.getNext();
        }

        Assert.assertEquals("0381", stringBuilder.toString());
    }
}
package com.anuragkapur.ds.linkedlist;

/**
 * @author: anuragkapur
 * @since: 09/06/14
 */

public class SinglyLinkedList {

    public static SinglyLinkedListNode getSinglyLinkedListWithDuplicates() {

        SinglyLinkedListNode node1 = new SinglyLinkedListNode("F");
        SinglyLinkedListNode node2 = new SinglyLinkedListNode("O");
        SinglyLinkedListNode node3 = new SinglyLinkedListNode("L");
        SinglyLinkedListNode node4 = new SinglyLinkedListNode("L");
        SinglyLinkedListNode node5 = new SinglyLinkedListNode("O");
        SinglyLinkedListNode node6 = new SinglyLinkedListNode("W");
        SinglyLinkedListNode node7 = new SinglyLinkedListNode(" ");
        SinglyLinkedListNode node8 = new SinglyLinkedListNode("U");
        SinglyLinkedListNode node9 = new SinglyLinkedListNode("P");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);

        return node1;
    }
}

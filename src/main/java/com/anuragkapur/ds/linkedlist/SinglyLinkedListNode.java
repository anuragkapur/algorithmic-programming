package com.anuragkapur.ds.linkedlist;

/**
 * @author: anuragkapur
 * @since: 09/06/14
 */

public class SinglyLinkedListNode {

    String payload;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode (String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }
}

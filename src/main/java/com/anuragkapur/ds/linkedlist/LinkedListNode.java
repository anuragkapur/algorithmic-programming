package com.anuragkapur.ds.linkedlist;

/**
 * @author anuragkapur
 */
public class LinkedListNode<T> {

    T data;
    LinkedListNode next;
    LinkedListNode previous;

    public LinkedListNode() {

    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<Integer> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<Integer> next) {
        this.next = next;
    }

    public LinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }
}

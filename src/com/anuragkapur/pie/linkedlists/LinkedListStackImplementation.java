package com.anuragkapur.pie.linkedlists;

/**
 * @author anuragkapur
 */
public class LinkedListStackImplementation<E> implements StackImplementation<E> {

    private Node head;
    private int size;

    @Override
    public void push(E element) {
        Node node = new Node();
        node.data = element;
        node.next = head;
        head = node;
        size ++;
    }

    @Override
    public E pop() {
        if (head == null) {
            return null;
        }
        E popped = head.data;
        head = head.next;
        size --;
        return popped;
    }

    @Override
    public E peek() {
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = head;
        if (current != null) {
            builder.append(current.data);
        }
        current = current.next;
        while (current != null) {
            builder.append(",");
            builder.append(current.data);
            current = current.next;
        }
        return builder.toString();
    }

    private class Node {
        E data;
        Node next;
    }
}

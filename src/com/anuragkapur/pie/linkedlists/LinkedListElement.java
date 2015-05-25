package com.anuragkapur.pie.linkedlists;

/**
 * @author anuragkapur
 */
public class LinkedListElement<E> {

    private E data;
    private LinkedListElement<E> next;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public LinkedListElement<E> getNext() {
        return next;
    }

    public void setNext(LinkedListElement<E> next) {
        this.next = next;
    }
}

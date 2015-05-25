package com.anuragkapur.pie.linkedlists;

/**
 * @author anuragkapur
 */
public class DoublyLinkedListWithChildElement<E> {

    private E data;
    private DoublyLinkedListWithChildElement<E> next;
    private DoublyLinkedListWithChildElement<E> previous;
    private DoublyLinkedListWithChildElement<E> child;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DoublyLinkedListWithChildElement<E> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListWithChildElement<E> next) {
        this.next = next;
    }

    public DoublyLinkedListWithChildElement<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListWithChildElement<E> previous) {
        this.previous = previous;
    }

    public DoublyLinkedListWithChildElement<E> getChild() {
        return child;
    }

    public void setChild(DoublyLinkedListWithChildElement<E> child) {
        this.child = child;
    }
}

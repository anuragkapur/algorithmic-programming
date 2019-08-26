package com.anuragkapur.pie.linkedlists;

/**
 * @author anuragkapur
 */
public class MthFromLastInLinkedList<E> {

    public E getElement(LinkedListElement<E> head, int m) {

        LinkedListElement<E> trailer = head;
        LinkedListElement<E> leader = head;

        // move leader forward by m positions
        for (int i = 0; i < m; i++) {
            if (leader == null) {
                return null;
            }
            leader = leader.getNext();
        }

        if (leader == null) {
            return null;
        }

        while (leader.getNext() != null) {
            leader = leader.getNext();
            trailer = trailer.getNext();
        }

        return trailer.getData();
    }

}

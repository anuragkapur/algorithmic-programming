package com.anuragkapur.pie.linkedlists;

/**
 * Status: Untested
 * @author anuragkapur
 */
public class ListFlattening {

    public void flatten(DoublyLinkedListWithChildElement<Integer> head,
                        DoublyLinkedListWithChildElement<Integer> tail) {

        DoublyLinkedListWithChildElement<Integer> current = head;
        while (current != null) {
            if (current.getChild() == null) {
                current = current.getNext();
            } else {
                DoublyLinkedListWithChildElement<Integer> child = current.getChild();
                DoublyLinkedListWithChildElement<Integer> tailOfChildSubList = flattenAndGetTail(child);

                tailOfChildSubList.setNext(current.getNext());
                current.setNext(child);
            }
        }
    }

    private DoublyLinkedListWithChildElement<Integer> flattenAndGetTail(DoublyLinkedListWithChildElement<Integer> child) {

        DoublyLinkedListWithChildElement<Integer> current = child;
        DoublyLinkedListWithChildElement<Integer> tail = child;

        while (current != null) {

            tail = current;

            if (current.getChild() == null) {
                current = current.getNext();
            } else {

                // TODO: possible null conditions / corner cases when last node of has children
                DoublyLinkedListWithChildElement<Integer> subTail = flattenAndGetTail(current.getChild());
                subTail.setNext(current.getNext());
                current.setNext(current.getChild());
                current = subTail.getNext();
            }
        }

        return tail;
    }
}

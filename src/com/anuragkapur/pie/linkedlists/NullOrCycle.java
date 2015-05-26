package com.anuragkapur.pie.linkedlists;

/**
 * @author anuragkapur
 */
public class NullOrCycle {

    public static boolean containsCycle(LinkedListElement<Integer> head) {

        LinkedListElement<Integer> trailingPointer = head;
        LinkedListElement<Integer> leadingPointer = head;

        while (trailingPointer != null && leadingPointer != null) {
            trailingPointer = trailingPointer.getNext();
            leadingPointer = leadingPointer.getNext();
            if (leadingPointer != null) {
                leadingPointer = leadingPointer.getNext();
            } else {
                return false;
            }
            if (trailingPointer == leadingPointer) {
                return true;
            }
        }

        return false;
    }
}

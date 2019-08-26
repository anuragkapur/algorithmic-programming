package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;

/**
 * @author: anuragkapur
 * @since: 10/06/14
 */

public class Prob2_1_1_UnsortedLinkedList {

    /**
     * Running time = O(n^2)
     *
     * @param singlyLinkedListNode
     * @return
     */
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode singlyLinkedListNode) {

        System.out.println("will remove duplicates");

        SinglyLinkedListNode dedupedListNode = singlyLinkedListNode;
        SinglyLinkedListNode currentNode;

        while (dedupedListNode != null) {
            currentNode = dedupedListNode;
            while (currentNode != null && currentNode.getNext() != null) {
                if (currentNode.getNext().getPayload().equals(dedupedListNode.getPayload())) {
                    currentNode.setNext(currentNode.getNext().getNext());
                }
                currentNode = currentNode.getNext();
            }
            dedupedListNode = dedupedListNode.getNext();
        }

        return singlyLinkedListNode;
    }
}

package com.anuragkapur.ctci;

import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;



import java.util.HashSet;
import java.util.Set;

/**
 * @author: anuragkapur
 * @since: 09/06/14
 */

public class Prob2_1_UnsortedLinkedList {

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode singlyLinkedListNode) {

        SinglyLinkedListNode dedupedListNode = singlyLinkedListNode;
        SinglyLinkedListNode currentNode = singlyLinkedListNode;

        Set<String> duplicateDetectionSet = new HashSet<>();
        duplicateDetectionSet.add(dedupedListNode.getPayload());
        currentNode = currentNode.getNext();

        while (currentNode != null) {
            if (duplicateDetectionSet.add(currentNode.getPayload())) {
                dedupedListNode.setNext(currentNode);
                dedupedListNode = dedupedListNode.getNext();
            }
            currentNode = currentNode.getNext();
        }

        return singlyLinkedListNode;
    }
}

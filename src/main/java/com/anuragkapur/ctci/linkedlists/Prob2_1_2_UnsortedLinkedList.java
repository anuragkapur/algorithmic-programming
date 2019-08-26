package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author anuragkapur
 */
public class Prob2_1_2_UnsortedLinkedList {

    /**
     * Remove duplicates, variation using LinkedListNode. Approach same as that used in Prob2_1_UnsortedLinkedList
     * Running time complexity: O(n)
     * Space complexity: O(n)
     * @param head
     * @return
     */
    public static LinkedListNode removeDuplicates(LinkedListNode<Integer> head) {

        // print input linked list
        LinkedListNode<Integer> iterator = head;
        System.out.println("<Input>");
        while (iterator != null) {
            System.out.println(iterator.getData());
            iterator = iterator.getNext();
        }
        System.out.println("</Input>");

        // processing starts here
        if (head == null) {
            return null;
        }

        Set<Integer> duplicateDetector = new HashSet<>();
        duplicateDetector.add(head.getData());

        LinkedListNode<Integer> previous = head;
        LinkedListNode<Integer> current = head.getNext();
        while (current != null) {
            if (duplicateDetector.add(current.getData())) {
                previous = current;
                current = current.getNext();
            } else {
                previous.setNext(current.getNext());
                current = current.getNext();
            }
        }

        return head;
    }
}

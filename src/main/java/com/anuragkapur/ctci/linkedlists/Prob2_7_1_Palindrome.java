package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

/**
 * @author anuragkapur
 */
public class Prob2_7_1_Palindrome {

    /**
     * Checks if list is palindrome by comparing against the reversed list.
     *
     * Run time complexity: O(n), one iteration to obtain reversed list and one iteration to compare
     * Space complexity: O(n)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> reversedHead = reverseList(head).head;

        while (reversedHead != null) {
            if (reversedHead.getData() == head.getData()) {
                reversedHead = reversedHead.getNext();
                head = head.getNext();
            } else {
                return false;
            }
        }

        if(head != null) {
            return false;
        }

        return true;
    }

    /**
     * Reverses a list using recursion
     *
     * @param node
     * @return
     */
    private HeadAndTail reverseList(LinkedListNode<Integer> node) {
        if (node.getNext() == null) {
            HeadAndTail headAndTail = new HeadAndTail();
            headAndTail.head = new LinkedListNode<>(node.getData());
            headAndTail.tail = headAndTail.head;
            return headAndTail;
        } else {
            HeadAndTail headAndTail = reverseList(node.getNext());
            headAndTail.tail.setNext(new LinkedListNode<>(node.getData()));
            headAndTail.tail = headAndTail.tail.getNext();
            return headAndTail;
        }
    }

    private class HeadAndTail {
        private LinkedListNode<Integer> head;
        private LinkedListNode<Integer> tail;
    }
}

package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

import java.util.Stack;

/**
 * @author anuragkapur
 */
public class Prob2_7_Palindrome {

    /**
     * Check is list is palindrome
     *
     * Run time complexity: O(n), 2 iterations of the list - one to determine size and other to check if palindrome
     * using a stack
     * Space complexity: O(n/2) = O(n), a stack with capacity of half the list is used.
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> current = head;
        int size = 0;
        while (current != null) {
            size ++;
            current = current.getNext();
        }

        current = head;
        Stack<Integer> stack = new Stack<>();
        int halfWayPoint = (size / 2);

        for (int i=0; i<halfWayPoint; i++) {
            stack.push(current.getData());
            current = current.getNext();
        }

        if (size % 2 == 0) {

        } else {
            current = current.getNext();
            halfWayPoint ++;
        }

        for (int i=halfWayPoint; i<size; i++) {
            if (stack.pop() == current.getData()) {
                current = current.getNext();
            } else {
                return false;
            }
        }

        return true;
    }
}

package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

import java.util.Stack;

/**
 * @author anuragkapur
 */
public class Prob2_7_Palindrome {

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

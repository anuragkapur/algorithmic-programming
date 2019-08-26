package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

/**
 * @author: anuragkapur
 * @since: 14/06/14
 */

public class Prob2_5_SumLists {

    /**
     * Iterative approach - iterating over both lists at the same time and adding digits.
     * Run time complexity: O(n), where n is the number of nodes in the larger list
     * Space complexity: O(1), no new DS used that vary with input size.
     *
     * @param head1
     * @param head2
     * @return
     */
    public static LinkedListNode addDigits(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        LinkedListNode<Integer> current1 = head1;
        LinkedListNode<Integer> current2 = head2;

        LinkedListNode<Integer> head3 = new LinkedListNode<>();
        LinkedListNode current3 = head3;

        int carry = 0;
        while(current1 != null || current2 != null) {
            int sum = carry;
            if (current1 != null) {
                sum += current1.getData();
                current1 = current1.getNext();
            }
            if (current2 != null) {
                sum += current2.getData();
                current2 = current2.getNext();
            }

            int digit = sum % 10;
            carry = sum / 10;
            LinkedListNode<Integer> node = new LinkedListNode<>(digit);
            current3.setNext(node);
            current3 = current3.getNext();
        }

        if (carry > 0) {
            current3.setNext(new LinkedListNode<>(carry));
        }

        head3 = head3.getNext();
        return head3;
    }
}

package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

/**
 * @author anuragkapur
 */
public class Prob2_5_SumInOrderLists {

    /**
     * Adds 2 linked lists. Example: 3->7->8 + 6->8->4 = (1->0->6->2). Note, the most significant digit is the head of
     * the list.
     *
     * This solution assumes input strings are of same length. If this is not the case, extra protection code is
     * required to pad 0s to the beginning of the shorter list.
     *
     * Run time complexity:O(n); single iteration over lists
     * Space Complexity:O(n); new linked list is generated
     *
     * @param head1
     * @param head2
     * @return
     */
    public LinkedListNode addLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        ReturnValue returnValue = add(head1, head2);
        if (returnValue.carry != 0) {
            LinkedListNode<Integer> node = new LinkedListNode<>(returnValue.carry);
            node.setNext(returnValue.node);
            return node;
        } else {
            return  returnValue.node;
        }
    }

    private ReturnValue add(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        int sum = 0;
        sum += head1.getData();
        sum += head2.getData();
        ReturnValue returnValue = null;

        if(head1.getNext() == null && head2.getNext() == null) {
            returnValue = new ReturnValue();
            returnValue.carry = sum / 10;
            returnValue.node = new LinkedListNode<>(sum % 10);
            return returnValue;
        } else {
            returnValue = add(head1.getNext(), head2.getNext());
            sum += returnValue.carry;
            returnValue.carry = sum / 10;
            LinkedListNode<Integer> node = new LinkedListNode<>(sum % 10);
            node.setNext(returnValue.node);
            returnValue.node = node;
            return returnValue;
        }
    }

    private class ReturnValue {
        private int carry;
        private LinkedListNode<Integer> node;
    }
}

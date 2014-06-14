package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;

/**
 * @author: anuragkapur
 * @since: 14/06/14
 */

public class Prob2_4_SumLists {

    public static SinglyLinkedListNode addNumberLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        int carry = 0;
        SinglyLinkedListNode resultList = null;
        SinglyLinkedListNode resultListHead = null;

        if (head1 == null && head2 == null) {
            return null;
        }

        while(head1 != null && head2 != null) {
            int sumOfDigits = Integer.valueOf(head1.getPayload()) + Integer.valueOf(head2.getPayload());
            sumOfDigits += carry;
            carry = sumOfDigits / 10;
            if(resultList == null) {
                resultList = new SinglyLinkedListNode(Integer.toString(sumOfDigits % 10));
                resultListHead = resultList;
            } else {
                resultList.setNext(new SinglyLinkedListNode(Integer.toString(sumOfDigits % 10)));
                resultList = resultList.getNext();
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        if(head1 != null) {
            resultList.setNext(head1);
        } else if(head2 != null) {
            resultList.setNext(head2);
        }

        if (carry != 0) {
            resultList.setNext(new SinglyLinkedListNode(Integer.toString(carry)));
        }

        return resultListHead;
    }
}

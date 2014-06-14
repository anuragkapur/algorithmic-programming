package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;

/**
 * @author: anuragkapur
 * @since: 14/06/14
 */

public class Prob2_4_1_SumLists {

    public SinglyLinkedListNode addList(SinglyLinkedListNode node1, SinglyLinkedListNode node2, int carry) {

        int sum = 0;

        if(node1 == null && node2 == null)  {
            if(carry > 0) {
                return new SinglyLinkedListNode(Integer.toString(carry));
            } else {
                return null;
            }
        }

        if(node1 != null) {
            sum += Integer.valueOf(node1.getPayload());
            node1 = node1.getNext();
        }

        if(node2 != null) {
            sum += Integer.valueOf(node2.getPayload());
            node2 = node2.getNext();
        }

        if(carry > 0) {
            sum += carry;
        }

        SinglyLinkedListNode result = new SinglyLinkedListNode(Integer.toString(sum % 10));
        result.setNext(addList(node1, node2, sum / 10));
        return result;
    }
}

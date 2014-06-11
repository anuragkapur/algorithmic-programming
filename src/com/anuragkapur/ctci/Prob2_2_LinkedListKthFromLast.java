package com.anuragkapur.ctci;

import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;

/**
 * @author: anuragkapur
 * @since: 11/06/14
 */

public class Prob2_2_LinkedListKthFromLast {

    private static int backwardsCounter = 0;

    /**
     * Kth from last element in a singly linked list.
     *
     * @param node
     * @param k
     * @return
     */
    public static String getKthElement(SinglyLinkedListNode node, int k) {

        String payload;

        if(node.getNext() != null) {

            payload = getKthElement(node.getNext(), k);

            if(backwardsCounter == k)
                return payload;
            else {
                backwardsCounter ++;
                if (backwardsCounter == k) {
                    return node.getPayload();
                } else {
                    return "Not Found";
                }
            }
        } else {

            backwardsCounter = 1;
            return node.getPayload();
        }
    }
}

package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;

/**
 * @author anuragkapur
 */
public class Prob2_2_1_LinkedListKthFromLast {

    static LinkedListNode answer;

    public static LinkedListNode kthToLast(LinkedListNode head, int k) {
        computeKthFromLast(head, k);
        return answer;
    }

    private static int computeKthFromLast(LinkedListNode node, int k) {

        if(node.getNext() == null) {
            if(k == 1) {
                System.out.println(node.getData());
                answer = node;
            }
            return 1;
        } else {
            int level = computeKthFromLast(node.getNext(), k) + 1;
            if(level == k) {
                System.out.println(node.getData());
                answer = node;
            }
            return level;
        }
    }
}

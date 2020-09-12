package com.anuragkapur.ib.heapsnmaps;

import com.anuragkapur.leetcode.ListNode;

import java.util.ArrayList;

public class MergeKSortedLists {

    /**
     * RTC:
     * O(K * (K*N))
     * K lists, N average length of list
     */
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        ListNode head = null;
        ListNode current = null;

        while (true) {
            boolean nodesLeft = false;
            for (ListNode node : a) {
                if (node != null) {
                    nodesLeft = true;
                }
            }

            if (!nodesLeft) {
                break;
            }

            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) != null) {
                    int nodeVal = a.get(i).val;
                    if (nodeVal < min) {
                        min = nodeVal;
                        index = i;
                    }
                }
            }

            ListNode node = a.get(index);
            a.set(index, node.next);

            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }
        }

        return head;
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

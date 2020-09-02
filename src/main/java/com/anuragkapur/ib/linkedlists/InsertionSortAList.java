package com.anuragkapur.ib.linkedlists;

public class InsertionSortAList {
    public ListNode insertionSortList(ListNode A) {

        if (A.next == null) {
            // List of size 1 is already sorted
            return A;
        }

        ListNode sortedStart = A;
        ListNode sortedEnd = A;
        ListNode node = sortedEnd.next;

        while (node != null) {
            ListNode next = node.next;
            if (node.val <= sortedStart.val) {
                // insert at beginning
                node.next = sortedStart;
                sortedStart = node;
                sortedEnd.next = next;
            } else if (node.val >= sortedEnd.val) {
                // insert at end
                sortedEnd = node;
            } else {
                // insert somewhere in between
                ListNode curr = sortedStart;
                ListNode prev = curr;

                while (curr != sortedEnd) {
                    if (curr.val < node.val) {
                        prev = curr;
                        curr = curr.next;
                    } else {
                        break;
                    }
                }

                node.next = curr;
                prev.next = node;
                sortedEnd.next = next;
            }
            node = next;
        }

        return sortedStart;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

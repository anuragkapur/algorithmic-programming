package com.anuragkapur.ib.linkedlists;

public class ReverseListBetweenBounds {
    public ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode start = A;
        if (start.next == null) {
            return start;
        }

        int count = 1;
        ListNode left = null;
        while (count < B) {
            count ++;
            left = start;
            start = start.next;
        }


        ListNode end = start;
        ListNode current = start;
        ListNode previous = null;
        while (current.next != null && count < C) {
            count ++;
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode right = current.next;
        current.next = previous;
        start = current;
        if (left != null) {
            left.next = start;
        }

        end.next = right;

        if (left == null) {
            return start;
        } else {
            return A;
        }
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

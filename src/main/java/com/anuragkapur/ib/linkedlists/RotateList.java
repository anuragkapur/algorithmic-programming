package com.anuragkapur.ib.linkedlists;

public class RotateList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Correct Answer
     * RTC: O(n)
     *
     * @param A
     * @param B
     * @return
     */
    public ListNode rotateRight(ListNode A, int B) {

        ListNode start = A;
        ListNode pointer = A;
        ListNode previous = A;

        if (A.next == null) {
            return A;
        }

        // compute length of list
        int length = 0;
        while (pointer != null) {
            length ++;
            if (pointer.next == null) {
                pointer.next = start;
                pointer = null;
            } else {
                pointer = pointer.next;
            }
        }


        // find new start and break circularity
        int k = B % length;
        int count = 0;
        pointer = start;
        previous = pointer;
        while (count != (length-k)) {
            previous = pointer;
            pointer = pointer.next;
            count ++;
        }
        previous.next = null;
        start = pointer;

        return start;
    }

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * RTC: O(nB)
     *
     * @param A
     * @param B
     * @return
     */
    public ListNode rotateRight1(ListNode A, int B) {

        ListNode start = A;
        ListNode pointer = A;
        ListNode previous = A;

        if (A.next == null) {
            return A;
        }

        for (int i = 0; i < B; i++) {
            while (pointer.next != null) {
                previous = pointer;
                pointer = pointer.next;
            }
            previous.next = null;
            pointer.next = start;
            start = pointer;
        }
        return start;
    }
}

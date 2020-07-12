package com.anuragkapur.ib.linkedlists;

public class MergeTwoSortedLists {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode merged = new ListNode(-1);
        ListNode mPointer = merged;
        while (A != null && B != null) {
            if (A.val < B.val) {
                mPointer.next = A;
                A = A.next;
            } else {
                mPointer.next = B;
                B = B.next;
            }
            mPointer = mPointer.next;
        }
        while (A != null) {
            mPointer.next = A;
            A = A.next;
            mPointer = mPointer.next;
        }
        while (B != null) {
            mPointer.next = B;
            B = B.next;
            mPointer = mPointer.next;
        }
        return merged.next;
    }
}

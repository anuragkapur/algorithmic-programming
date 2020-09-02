package com.anuragkapur.ib.linkedlists;

public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode currentA = A;
        ListNode currentB = B;

        ListNode root = null;

        int carry = 0;
        ListNode current = null;

        while (currentA != null || currentB != null) {
            int sum = carry;
            if (currentA != null) {
                sum += currentA.val;
                currentA = currentA.next;
            }
            if (currentB != null) {
                sum += currentB.val;
                currentB = currentB.next;
            }

            if (sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(sum % 10);
            if (root == null) {
                root = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return root;
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

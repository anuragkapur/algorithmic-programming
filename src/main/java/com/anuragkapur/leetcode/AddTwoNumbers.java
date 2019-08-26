package com.anuragkapur.leetcode;

/**
 * @author anuragkapur
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = null;
        ListNode current = null;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int operand1 = (l1 != null) ? l1.val : 0;
            int operand2 = (l2 != null) ? l2.val : 0;
            int sum = operand1 + operand2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            ListNode node = new ListNode(digit);

            if(root == null) {
                root = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return root;
    }
}

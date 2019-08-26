package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class AddTwoNumbersTest {

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    @Test
    public void testAddTwoNumbers1() throws Exception {
        ListNode root1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        root1.next = node1;
        node1.next = node2;

        ListNode root2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        root2.next = node3;
        node3.next = node4;

        ListNode result = addTwoNumbers.addTwoNumbers(root1, root2);

        assertEquals("7->0->8", getListRep(result));
    }

    @Test
    public void testAddTwoNumbers2() throws Exception {
        ListNode root1 = new ListNode(7);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(7);
        root1.next = node1;
        node1.next = node2;

        ListNode root2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        root2.next = node3;

        ListNode result = addTwoNumbers.addTwoNumbers(root1, root2);

        assertEquals("2->1->8", getListRep(result));
    }

    private String getListRep(ListNode result) {
        StringBuilder builder = new StringBuilder();
        while(result != null) {
            builder.append(result.val);
            builder.append("->");
            result = result.next;
        }
        builder.setLength(builder.length()-2);
        return builder.toString();
    }
}
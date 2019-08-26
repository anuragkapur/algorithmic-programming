package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Prob2_7_1_PalindromeTest {

    @Test
    public void testIsPalindrome1() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        assertEquals(true, new Prob2_7_1_Palindrome().isPalindrome(node1));
    }

    @Test
    public void testIsPalindrome2() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        assertEquals(true, new Prob2_7_1_Palindrome().isPalindrome(node1));
    }

    @Test
    public void testIsPalindrome3() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node6 = new LinkedListNode<>(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        assertEquals(false, new Prob2_7_1_Palindrome().isPalindrome(node1));
    }

    @Test
    public void testIsPalindrome4() throws Exception {
        LinkedListNode<Integer> node1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(4);
        LinkedListNode<Integer> node5 = new LinkedListNode<>(2);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        assertEquals(false, new Prob2_7_1_Palindrome().isPalindrome(node1));
    }
}
package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Prob2_1_2_UnsortedLinkedListTest {

    @Test
    public void testRemoveDuplicates1() throws Exception {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> current = head;
        for (int i=0; i<3; i++) {
            LinkedListNode<Integer> node = new LinkedListNode<>(1);
            current.setNext(node);
            current = current.getNext();
        }

        LinkedListNode<Integer> solution = Prob2_1_2_UnsortedLinkedList.removeDuplicates(head);
        int count = 0;
        while (solution != null) {
            System.out.println(solution.getData());
            solution = solution.getNext();
            count ++;
        }

        Assert.assertEquals(1, count);
    }

    @Test
    public void testRemoveDuplicates2() throws Exception {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> current = head;
        for (int i=0; i<3; i++) {
            LinkedListNode<Integer> node = new LinkedListNode<>(i);
            current.setNext(node);
            current = current.getNext();
        }

        LinkedListNode<Integer> solution = Prob2_1_2_UnsortedLinkedList.removeDuplicates(head);
        int count = 0;
        while (solution != null) {
            System.out.println(solution.getData());
            solution = solution.getNext();
            count ++;
        }

        Assert.assertEquals(3, count);
    }

    @Test
    public void testRemoveDuplicates3() throws Exception {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> solution = Prob2_1_2_UnsortedLinkedList.removeDuplicates(head);
        int count = 0;
        while (solution != null) {
            System.out.println(solution.getData());
            solution = solution.getNext();
            count ++;
        }

        Assert.assertEquals(1, count);
    }
}
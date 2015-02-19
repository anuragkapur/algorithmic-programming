package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Prob2_2_1_LinkedListKthFromLastTest {

    @Test
    public void testKthToLast1() throws Exception {

        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> current = head;
        for (int i=0; i<3; i++) {
            LinkedListNode<Integer> node = new LinkedListNode<>(i);
            current.setNext(node);
            current = current.getNext();
        }

        LinkedListNode node = Prob2_2_1_LinkedListKthFromLast.kthToLast(head, 1);
        assertEquals(2, node.getData());

        node = Prob2_2_1_LinkedListKthFromLast.kthToLast(head, 2);
        assertEquals(1, node.getData());

        node = Prob2_2_1_LinkedListKthFromLast.kthToLast(head, 3);
        assertEquals(0, node.getData());

        node = Prob2_2_1_LinkedListKthFromLast.kthToLast(head, 4);
        assertEquals(1, node.getData());
    }
}
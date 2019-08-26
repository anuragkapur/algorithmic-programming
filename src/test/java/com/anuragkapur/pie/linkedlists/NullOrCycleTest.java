package com.anuragkapur.pie.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class NullOrCycleTest {

    LinkedListElement<Integer> head = new LinkedListElement<>(1);
    LinkedListElement<Integer> node2 = new LinkedListElement<>(2);
    LinkedListElement<Integer> node3 = new LinkedListElement<>(1);
    LinkedListElement<Integer> node4 = new LinkedListElement<>(1);
    LinkedListElement<Integer> node5 = new LinkedListElement<>(1);

    @Test
    public void testContainsCycle1() throws Exception {

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node2);

        assertEquals(true, NullOrCycle.containsCycle(head));
    }

    @Test
    public void testContainsCycle2() throws Exception {

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        assertEquals(false, NullOrCycle.containsCycle(head));
    }

    @Test
    public void testContainsCycle3() throws Exception {

        assertEquals(false, NullOrCycle.containsCycle(head));
    }

    @Test
    public void testContainsCycle4() throws Exception {

        assertEquals(false, NullOrCycle.containsCycle(null));
    }
}
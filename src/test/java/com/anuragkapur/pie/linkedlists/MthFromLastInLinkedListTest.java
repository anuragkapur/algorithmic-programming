package com.anuragkapur.pie.linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class MthFromLastInLinkedListTest {

    MthFromLastInLinkedList<Integer> mthFromLastInLinkedList = new MthFromLastInLinkedList<>();

    @Test
    public void testGetElement1() throws Exception {
        LinkedListElement<Integer> head = null;
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 0));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 1));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 5));
    }

    @Test
    public void testGetElement2() throws Exception {
        LinkedListElement<Integer> head = new LinkedListElement<>();
        head.setData(1);
        assertEquals(Integer.valueOf(1), mthFromLastInLinkedList.getElement(head, 0));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 1));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 5));
    }

    @Test
    public void testGetElement3() throws Exception {
        LinkedListElement<Integer> head = new LinkedListElement<>();
        head.setData(1);
        LinkedListElement<Integer> e1 = new LinkedListElement<>();
        e1.setData(2);
        head.setNext(e1);

        assertEquals(Integer.valueOf(2), mthFromLastInLinkedList.getElement(head, 0));
        assertEquals(Integer.valueOf(1), mthFromLastInLinkedList.getElement(head, 1));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 2));
    }

    @Test
    public void testGetElement4() throws Exception {
        LinkedListElement<Integer> head = new LinkedListElement<>();
        head.setData(1);
        LinkedListElement<Integer> e1 = new LinkedListElement<>();
        e1.setData(2);
        LinkedListElement<Integer> e2 = new LinkedListElement<>();
        e2.setData(3);
        head.setNext(e1);
        e1.setNext(e2);

        assertEquals(Integer.valueOf(3), mthFromLastInLinkedList.getElement(head, 0));
        assertEquals(Integer.valueOf(2), mthFromLastInLinkedList.getElement(head, 1));
        assertEquals(Integer.valueOf(1), mthFromLastInLinkedList.getElement(head, 2));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 3));
        assertEquals(null, mthFromLastInLinkedList.getElement(head, 11));
    }
}
package com.anuragkapur.ctci;

import com.anuragkapur.ds.linkedlist.SinglyLinkedList;
import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class Prob2_2_LinkedListKthFromLastTest {

    @Test
    public void testGetKthElement1() throws Exception {
        SinglyLinkedListNode rootNode = SinglyLinkedList.getSinglyLinkedListWithDuplicates();
        Assert.assertEquals("W", Prob2_2_LinkedListKthFromLast.getKthElement(rootNode, 4));
    }

    @Test
    public void testGetKthElement2() throws Exception {
        SinglyLinkedListNode rootNode = SinglyLinkedList.getSinglyLinkedListWithDuplicates();
        Assert.assertEquals("P", Prob2_2_LinkedListKthFromLast.getKthElement(rootNode, 1));
    }

    @Test @Ignore
    public void testGetKthElement3() throws Exception {
        SinglyLinkedListNode rootNode = SinglyLinkedList.getSinglyLinkedListWithDuplicates();
        Assert.assertEquals("Not Found", Prob2_2_LinkedListKthFromLast.getKthElement(rootNode, 20));
    }
}
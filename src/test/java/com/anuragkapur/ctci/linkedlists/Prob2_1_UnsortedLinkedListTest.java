package com.anuragkapur.ctci.linkedlists;

import com.anuragkapur.ds.linkedlist.SinglyLinkedList;
import com.anuragkapur.ds.linkedlist.SinglyLinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class Prob2_1_UnsortedLinkedListTest {

    @Test
    public void testRemoveDuplicates() throws Exception {
        SinglyLinkedListNode rootNode = SinglyLinkedList.getSinglyLinkedListWithDuplicates();
        SinglyLinkedListNode afterDuplicateRemoval = Prob2_1_UnsortedLinkedList.removeDuplicates(rootNode);
        StringBuilder stringBuilder = new StringBuilder();
        while (afterDuplicateRemoval != null) {
            stringBuilder.append(afterDuplicateRemoval.getPayload());
            afterDuplicateRemoval = afterDuplicateRemoval.getNext();
        }
        Assert.assertEquals("FOLW UP", stringBuilder.toString());
    }
}
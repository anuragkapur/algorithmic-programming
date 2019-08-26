package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class KthLargestTest {

    KthLargest kthLargest = new KthLargest();

    @Test
    public void testFindKthLargest1() throws Exception {
        assertEquals(3, kthLargest.findKthLargest(new int[]{1,2,3}, 1));
        assertEquals(1, kthLargest.findKthLargest(new int[]{3,2,1}, 3));
    }

    @Test
    public void testFindKthLargest2() throws Exception {
        assertEquals(3, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 4));
    }

    @Test
    public void testFindKthLargest3() throws Exception {
        assertEquals(8, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 1));
        assertEquals(6, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 2));
        assertEquals(4, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 3));
        assertEquals(3, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 4));
        assertEquals(2, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 5));
        assertEquals(1, kthLargest.findKthLargest(new int[]{4,2,1,6,8,3}, 6));
    }
}
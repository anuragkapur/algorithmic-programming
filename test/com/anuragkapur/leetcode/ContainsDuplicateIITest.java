package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class ContainsDuplicateIITest {

    ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();

    @Test
    public void testContainsNearbyDuplicate1() throws Exception {
        assertEquals(false, containsDuplicateII.containsNearbyDuplicate(null, 0));
        assertEquals(false, containsDuplicateII.containsNearbyDuplicate(null, 2));
        assertEquals(false, containsDuplicateII.containsNearbyDuplicate(new int[0], 2));
        assertEquals(false, containsDuplicateII.containsNearbyDuplicate(new int[1], 2));
        assertEquals(true, containsDuplicateII.containsNearbyDuplicate(new int[2], 2));
    }

    @Test
    public void testContainsNearbyDuplicate2() throws Exception {
        assertEquals(false, containsDuplicateII.containsNearbyDuplicate(new int[] {1,4,2,5,3,8,2}, 0));
        assertEquals(true, containsDuplicateII.containsNearbyDuplicate(new int[] {1,4,2,5,3,8,2}, 4));
    }
}
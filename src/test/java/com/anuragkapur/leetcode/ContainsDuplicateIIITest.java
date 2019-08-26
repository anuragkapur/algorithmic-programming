package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class ContainsDuplicateIIITest {

    ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();

    @Test
    public void testContainsNearbyAlmostDuplicate0() throws Exception {
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(null, 2, 2));
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(new int[1], 3, 2));
    }

    @Test
    public void testContainsNearbyAlmostDuplicate1() throws Exception {
        int a[] = {3,2,7,6,9,1};
        assertEquals(true, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 2, 2));
        assertEquals(true, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 2, 1));
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 2, 0));
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 0, 2));
    }

    @Test
    public void testContainsNearbyAlmostDuplicate2() throws Exception {
        int a[] = {3,12,21,8,15,23};
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 2, 2));
        assertEquals(true, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 3, 2));
    }

    @Test
    public void testContainsNearbyAlmostDuplicate3() throws Exception {
        int a[] = {-1, -1};
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 1, -1));
    }

    @Test
    public void testContainsNearbyAlmostDuplicate4() throws Exception {
        int a[] = {-1,2147483647};
        assertEquals(false, containsDuplicateIII.containsNearbyAlmostDuplicate(a, 1, 2147483647));
    }
}
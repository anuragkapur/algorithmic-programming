package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class ContainsDuplicateTest {

    ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    @Test
    public void testContainsDuplicate() throws Exception {
        assertEquals(true, containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4, 5, 3}));
        assertEquals(true, containsDuplicate.containtDuplicateAlternate(new int[]{1, 2, 3, 4, 5, 3}));
        assertEquals(true, containsDuplicate.containtDuplicateAlternate2(new int[]{1, 2, 3, 4, 5, 3}));

        assertEquals(true, containsDuplicate.containsDuplicate(new int[]{5, 3, 1, 4, 3, 2}));
        assertEquals(true, containsDuplicate.containtDuplicateAlternate(new int[]{5, 3, 1, 4, 3, 2}));
        assertEquals(true, containsDuplicate.containtDuplicateAlternate2(new int[]{5, 3, 1, 4, 3, 2}));
    }

    @Test
    public void testContainsDuplicate2() throws Exception {
        assertEquals(false, containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4, 5}));
        assertEquals(false, containsDuplicate.containtDuplicateAlternate(new int[]{1,2,3,4,5}));
        assertEquals(true, containsDuplicate.containtDuplicateAlternate2(new int[]{5, 3, 1, 4, 3, 2}));
    }
}
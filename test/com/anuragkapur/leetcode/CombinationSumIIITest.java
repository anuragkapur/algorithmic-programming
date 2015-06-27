package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class CombinationSumIIITest {

    CombinationSumIII combinationSum = new CombinationSumIII();

    @Test
    public void testCombinationSum1() throws Exception {
        assertNull(combinationSum.combinationSum3(0, 0));
        assertNull(combinationSum.combinationSum3(0, 4));
        assertNull(combinationSum.combinationSum3(4, 0));
    }

    @Test
    public void testCombinationSum2() throws Exception {
        assertEquals("[[1, 2, 4]]", combinationSum.combinationSum3(3, 7).toString());
    }

    @Test
    public void testCombinationSum3() throws Exception {
        assertEquals("[[1, 2, 6], [1, 3, 5], [2, 3, 4]]", combinationSum.combinationSum3(3, 9).toString());
    }
}
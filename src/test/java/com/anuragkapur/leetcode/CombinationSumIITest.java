package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class CombinationSumIITest {

    CombinationSumII combinationSum = new CombinationSumII();

    @Test
    public void testCombinationSum1() throws Exception {
        assertEquals(null, combinationSum.combinationSum2(new int[]{}, 7));
        assertEquals(null, combinationSum.combinationSum2(null, 7));
    }

    @Test
    public void testCombinationSum2() throws Exception {
        assertEquals("[[1, 2, 5], [1, 1, 6], [2, 6], [1, 7]]", combinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).toString());
    }
}
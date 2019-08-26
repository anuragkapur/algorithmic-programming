package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class CombinationSumTest {

    CombinationSum combinationSum = new CombinationSum();

    @Test
    public void testCombinationSum1() throws Exception {
        assertEquals(null, combinationSum.combinationSum(new int[]{}, 7));
        assertEquals(null, combinationSum.combinationSum(null, 7));
    }


    @Test
    public void testCombinationSum2() throws Exception {
        assertEquals("[[2, 2, 3], [7]]", combinationSum.combinationSum(new int[]{3, 6, 2, 7}, 7).toString());
    }

    @Test
    public void testCombinationSum3() throws Exception {
        assertEquals("[[1, 1, 1]]", combinationSum.combinationSum(new int[]{1}, 3).toString());
    }

    @Test
    public void testCombinationSum4() throws Exception {
        assertEquals("[]", combinationSum.combinationSum(new int[]{3,3,3}, 1).toString());
    }
}
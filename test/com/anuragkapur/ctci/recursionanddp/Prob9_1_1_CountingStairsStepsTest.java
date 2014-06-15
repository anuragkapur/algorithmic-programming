package com.anuragkapur.ctci.recursionanddp;

import org.junit.Assert;
import org.junit.Test;

public class Prob9_1_1_CountingStairsStepsTest {

    @Test
    public void testCount() throws Exception {
        Prob9_1_1_CountingStairsSteps solution = new Prob9_1_1_CountingStairsSteps();
        Assert.assertEquals(1, solution.count(1));
        Assert.assertEquals(2, solution.count(2));
        Assert.assertEquals(4, solution.count(3));
        Assert.assertEquals(7, solution.count(4));
        Assert.assertEquals(13, solution.count(5));
        Assert.assertEquals(24, solution.count(6));
        Assert.assertEquals(44, solution.count(7));
        Assert.assertEquals(81, solution.count(8));
        Assert.assertEquals(149, solution.count(9));
        Assert.assertEquals(274, solution.count(10));
    }
}
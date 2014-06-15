package com.anuragkapur.ctci.recursionanddp;

import org.junit.Assert;
import org.junit.Test;

public class Prob9_1_CountingStairsStepsTest {

    @Test
    public void testCount() throws Exception {
        Prob9_1_CountingStairsSteps solution = new Prob9_1_CountingStairsSteps();
        Assert.assertEquals(1, solution.count(1));
        Assert.assertEquals(2, solution.count(2));
        Assert.assertEquals(3, solution.count(3));
        Assert.assertEquals(7, solution.count(4));
    }
}
package com.anuragkapur.ctci.recursionanddp;

import org.junit.Assert;
import org.junit.Test;

public class Prob9_2_RobotInGridTest {

    @Test
    public void testCountPaths() throws Exception {
        Prob9_2_RobotInGrid solution = new Prob9_2_RobotInGrid();
        Assert.assertEquals(6, solution.countPaths(2, 2));
    }
}
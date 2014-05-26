package com.anuragkapur.misc;

import org.junit.Assert;
import org.junit.Test;

public class ComputeNthFibonacciTest {

    @Test
    public void testCompute1() throws Exception {
        Assert.assertEquals(3, ComputeNthFibonacci.compute(5));
    }

    @Test
    public void testCompute2() throws Exception {
        Assert.assertEquals(0, ComputeNthFibonacci.compute(1));
    }

    @Test
    public void testCompute3() throws Exception {
        Assert.assertEquals(63245986, ComputeNthFibonacci.compute(40));
    }
}

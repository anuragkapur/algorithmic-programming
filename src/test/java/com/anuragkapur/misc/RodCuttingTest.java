package com.anuragkapur.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class RodCuttingTest {

    @Test
    public void testCutRodToMaximisePrice1() throws Exception {
        int p[] = {1, 5, 8, 9, 10, 17, 20, 24, 30};
        assertEquals(10, new RodCutting().cutRodToMaximisePrice1(p, 4));
        assertEquals(10, new RodCutting().cutRodToMaximisePrice2(p, 4, null));
    }
}
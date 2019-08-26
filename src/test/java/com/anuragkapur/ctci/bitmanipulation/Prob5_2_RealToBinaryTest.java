package com.anuragkapur.ctci.bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class Prob5_2_RealToBinaryTest {

    @Test
    public void testConvert() throws Exception {
        assertEquals("0.1", Prob5_2_RealToBinary.convert(0.5));
        assertEquals("0.11", Prob5_2_RealToBinary.convert(0.75));
        assertEquals("0.01", Prob5_2_RealToBinary.convert(0.25));
        assertEquals("ERROR", Prob5_2_RealToBinary.convert(0.72));
    }
}
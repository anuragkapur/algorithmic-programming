package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class ZigZagConversionTest {

    ZigZagConversion zigZagConversion = new ZigZagConversion();

    @Test
    public void testConvert0() throws Exception {
        assertEquals("PAYPALISHIRING", zigZagConversion.convert("PAYPALISHIRING", 1));
        assertEquals("", zigZagConversion.convert("", 4));
        assertEquals(null, zigZagConversion.convert(null, 4));
    }

    @Test
    public void testConvert1() throws Exception {
        assertEquals("PAHNAPLSIIGYIR", zigZagConversion.convert("PAYPALISHIRING", 3));
    }
}
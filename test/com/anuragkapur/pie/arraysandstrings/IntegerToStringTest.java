package com.anuragkapur.pie.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class IntegerToStringTest {

    @Test
    public void testConvert1() throws Exception {
        assertEquals("1", IntegerToString.convert(1));
    }

    @Test
    public void testConvert2() throws Exception {
        assertEquals("-1", IntegerToString.convert(-1));
    }

    @Test
    public void testConvert3() throws Exception {
        assertEquals("0", IntegerToString.convert(0));
    }

    @Test
    public void testConvert4() throws Exception {
        assertEquals("123", IntegerToString.convert(123));
    }

    @Test
    public void testConvert5() throws Exception {
        assertEquals("-123", IntegerToString.convert(-123));
    }
}
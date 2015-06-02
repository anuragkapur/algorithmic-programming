package com.anuragkapur.pie.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class StringToIntegerTest {

    @Test
    public void testConvert1() throws Exception {
        String str = null;
        boolean exceptionThrown = false;

        try {
            StringToInteger.convert(str);
        } catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    @Test
    public void testConvert2() throws Exception {
        String str = "1";
        assertEquals(1, StringToInteger.convert(str));
    }

    @Test
    public void testConvert3() throws Exception {
        String str = "-1";
        assertEquals(-1, StringToInteger.convert(str));
    }

    @Test
    public void testConvert4() throws Exception {
        String str = "1234";
        assertEquals(1234, StringToInteger.convert(str));
    }

    @Test
    public void testConvert5() throws Exception {
        String str = "-1234";
        assertEquals(-1234, StringToInteger.convert(str));
    }
}
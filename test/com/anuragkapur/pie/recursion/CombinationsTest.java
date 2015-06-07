package com.anuragkapur.pie.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class CombinationsTest {

    Combinations combinations = new Combinations();

    @Test
    public void testCombine1() throws Exception {
        assertNull(combinations.combine(null));
    }

    @Test
    public void testCombine2() throws Exception {
        assertEquals("[]", combinations.combine("").toString());
    }

    @Test
    public void testCombine3() throws Exception {
        assertEquals("[, a]", combinations.combine("a").toString());
    }

    @Test
    public void testCombine4() throws Exception {
        assertEquals("[a, ab, , b]", combinations.combine("ab").toString());
    }

    @Test
    public void testCombine5() throws Exception {
        assertEquals("[ab, abc, a, ac, b, bc, , c]", combinations.combine("abc").toString());
    }
}
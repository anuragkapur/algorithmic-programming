package com.anuragkapur.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class Prob1_2_ReverseCharsInStringTest {

    Prob1_2_ReverseCharsInString reverseCharsInString = new Prob1_2_ReverseCharsInString();

    @Test
    public void testReverse1() throws Exception {
        assertNull(reverseCharsInString.reverse(null));
    }

    @Test
    public void testReverse2() throws Exception {
        assertEquals("a", reverseCharsInString.reverse("a"));
    }

    @Test
    public void testReverse3() throws Exception {
        assertEquals("ba", reverseCharsInString.reverse("ab"));
    }

    @Test
    public void testReverse4() throws Exception {
        assertEquals("cba", reverseCharsInString.reverse("abc"));
    }

    @Test
    public void testReverse5() throws Exception {
        assertEquals("c*b a", reverseCharsInString.reverse("a b*c"));
        assertEquals("@c*b a", reverseCharsInString.reverse("a b*c@"));
    }
}
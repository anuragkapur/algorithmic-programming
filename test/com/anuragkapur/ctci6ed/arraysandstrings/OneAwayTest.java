package com.anuragkapur.ctci6ed.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class OneAwayTest {

    OneAway oneAway = new OneAway();

    @Test
    public void testAreOneAway0() throws Exception {
        assertEquals(false, oneAway.areOneAway("bale", null));
        assertEquals(false, oneAway.areOneAway(null, "bale"));
        assertEquals(false, oneAway.areOneAway(null, null));
    }

    @Test
    public void testAreOneAway1() throws Exception {
        assertEquals(true, oneAway.areOneAway("pale", "ple"));
    }

    @Test
    public void testAreOneAway2() throws Exception {
        assertEquals(true, oneAway.areOneAway("pales", "pale"));
    }

    @Test
    public void testAreOneAway3() throws Exception {
        assertEquals(true, oneAway.areOneAway("bale", "pale"));
    }

    @Test
    public void testAreOneAway4() throws Exception {
        assertEquals(false, oneAway.areOneAway("bake", "pale"));
    }

    @Test
    public void testAreOneAway5() throws Exception {
        assertEquals(false, oneAway.areOneAway("aba", "baa"));
    }

    @Test
    public void testAreOneAway6() throws Exception {
        assertEquals(true, oneAway.areOneAway("abc", "abcd"));
    }
}
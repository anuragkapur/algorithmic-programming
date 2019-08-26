package com.anuragkapur.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseMultiplesOf3Test {

    @Test
    public void testReversMultiplesOf3Test1() throws Exception {
        String expected = "aabb86yy9a3";
        assertEquals(expected, new ReverseMultiplesOf3().reverse("aabb83yy9a6"));
        assertEquals(expected, new ReverseMultiplesOf3().reverse1("aabb83yy9a6"));
    }

    @Test
    public void testReversMultiplesOf3Test2() throws Exception {
        String expected = "abcd";
        assertEquals(expected, new ReverseMultiplesOf3().reverse("abcd"));
        assertEquals(expected, new ReverseMultiplesOf3().reverse1("abcd"));
    }

    @Test
    public void testReversMultiplesOf3Test3() throws Exception {
        String expected = "3963";
        assertEquals(expected, new ReverseMultiplesOf3().reverse("3693"));
        assertEquals(expected, new ReverseMultiplesOf3().reverse1("3693"));
    }
}
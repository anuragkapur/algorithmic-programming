package com.anuragkapur.pie.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class PermutationsTest {

    Permutations permutations = new Permutations();

    @Test
    public void testGetPermutations1() throws Exception {
        assertNull(permutations.getPermutations(null));
    }

    @Test
    public void testGetPermutations2() throws Exception {
        assertEquals("[]", permutations.getPermutations("").toString());
    }

    @Test
    public void testGetPermutations3() throws Exception {
        assertEquals("[a]", permutations.getPermutations("a").toString());
    }

    @Test
    public void testGetPermutations4() throws Exception {
        assertEquals("[abc, acb, bac, bca, cab, cba]", permutations.getPermutations("abc").toString());
    }

    @Test
    public void testGetPermutations5() throws Exception {
        assertEquals("[aaa, aaa, aaa, aaa, aaa, aaa]", permutations.getPermutations("aaa").toString());
    }
}
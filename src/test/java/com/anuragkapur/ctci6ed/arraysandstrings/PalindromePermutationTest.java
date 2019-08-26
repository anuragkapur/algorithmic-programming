package com.anuragkapur.ctci6ed.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class PalindromePermutationTest {

    PalindromePermutation palindromePermutation = new PalindromePermutation();

    @Test
    public void testIsPalindromePermutation1() throws Exception {
        assertEquals(false, palindromePermutation.isPalindromePermutation(null));
    }

    @Test
    public void testIsPalindromePermutation2() throws Exception {
        assertEquals(true, palindromePermutation.isPalindromePermutation("a"));
    }

    @Test
    public void testIsPalindromePermutation3() throws Exception {
        assertEquals(false, palindromePermutation.isPalindromePermutation("ab"));
    }

    @Test
    public void testIsPalindromePermutation4() throws Exception {
        assertEquals(true, palindromePermutation.isPalindromePermutation("aab"));
    }

    @Test
    public void testIsPalindromePermutation5() throws Exception {
        assertEquals(true, palindromePermutation.isPalindromePermutation("Tact Coa"));
    }
}
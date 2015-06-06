package com.anuragkapur.pie.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BinarySearchTest {

    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void testBinarySearch1() throws Exception {
        int a[] = null;
        assertEquals(-1, binarySearch.binarySearch(a, 1));
    }

    @Test
    public void testBinarySearch2() throws Exception {
        int a[] = {3};
        assertEquals(-1, binarySearch.binarySearch(a, 2));
        assertEquals(0, binarySearch.binarySearch(a, 3));
        assertEquals(-1, binarySearch.binarySearch(a, 5));
    }

    @Test
    public void testBinarySearch3() throws Exception {
        int a[] = {1,2,3,4};
        assertEquals(1, binarySearch.binarySearch(a, 2));
        assertEquals(3, binarySearch.binarySearch(a, 4));
        assertEquals(-1, binarySearch.binarySearch(a, 7));
        assertEquals(-1, binarySearch.binarySearch(a, 0));
    }

    @Test
    public void testBinarySearch4() throws Exception {
        int a[] = {1,2,3,4,5};
        assertEquals(1, binarySearch.binarySearch(a, 2));
        assertEquals(3, binarySearch.binarySearch(a, 4));
        assertEquals(-1, binarySearch.binarySearch(a, 7));
        assertEquals(-1, binarySearch.binarySearch(a, 0));
    }
}
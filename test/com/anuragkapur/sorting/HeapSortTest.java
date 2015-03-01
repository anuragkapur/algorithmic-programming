package com.anuragkapur.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void testSort1() throws Exception {
        int a[] = {4,1,2,6,7,3,9,8};
        new HeapSort().sort(a);
        assertEquals("[1, 2, 3, 4, 6, 7, 8, 9]", Arrays.toString(a));
    }

    @Test
    public void testSort2() throws Exception {
        int a[] = {4,1,2,6,7,3,9,8,5};
        new HeapSort().sort(a);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(a));
    }
}
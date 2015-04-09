package com.anuragkapur.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class QuickSortTest {

    @Test
    public void testSort1() throws Exception {
        QuickSort quickSort = new QuickSort();
        int a[] = {2,3,8,7,1,5,6,4};
        quickSort.sort(a, 0, a.length - 1);
        assertEquals("1,2,3,4,5,6,7,8", arrayToString(a));
    }

    @Test
    public void testSort2() throws Exception {
        QuickSort quickSort = new QuickSort();
        int a[] = {7,11,72,1,100,21,6};
        quickSort.sort(a, 0, a.length - 1);
        assertEquals("1,6,7,11,21,72,100", arrayToString(a));
    }

    private String arrayToString(int a[]) {
        String str = ""+a[0];
        for (int i=1; i<a.length; i++) {
            str += ",";
            str += a[i];
        }
        return str;
    }
}
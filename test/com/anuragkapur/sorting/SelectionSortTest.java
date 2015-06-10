package com.anuragkapur.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class SelectionSortTest {

    SelectionSort selectionSort = new SelectionSort();

    @Test
    public void testRecursiveSort1() throws Exception {

        int a[] = null;
        selectionSort.recursiveSort(a);
        assertNull(a);
    }

    @Test
    public void testRecursiveSort2() throws Exception {

        int a[] = new int[0];
        selectionSort.recursiveSort(a);
        assertEquals("[]", arrayAsString(a));
    }

    @Test
    public void testRecursiveSort3() throws Exception {

        int a[] = new int[5];
        selectionSort.recursiveSort(a);
        assertEquals("[0,0,0,0,0]", arrayAsString(a));
    }

    @Test
    public void testRecursiveSort4() throws Exception {

        int a[] = {1,5,2,7,3};
        selectionSort.recursiveSort(a);
        assertEquals("[1,2,3,5,7]", arrayAsString(a));
    }

    private String arrayAsString(int a[]) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int element : a) {
            builder.append(element);
            builder.append(",");
        }

        if(builder.length() > 1)
            builder.setLength(builder.length()-1);

        builder.append("]");
        return builder.toString();
    }

}
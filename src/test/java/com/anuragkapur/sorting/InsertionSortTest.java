package com.anuragkapur.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class InsertionSortTest {

    InsertionSort insertionSort = new InsertionSort();

    @Test
    public void testSort1() throws Exception {

        int a[] = null;
        insertionSort.sort(a);
        assertNull(a);
    }

    @Test
    public void testSort2() throws Exception {

        int a[] = new int[0];
        insertionSort.sort(a);
        assertEquals("[]", ArrayHelper.arrayAsString(a));
    }

    @Test
    public void testSort3() throws Exception {

        int a[] = new int[5];
        insertionSort.sort(a);
        assertEquals("[0,0,0,0,0]", ArrayHelper.arrayAsString(a));
    }

    @Test
    public void testSort4() throws Exception {

        int a[] = {1, 5, 2, 7, 3};
        insertionSort.sort(a);
        assertEquals("[1,2,3,5,7]", ArrayHelper.arrayAsString(a));
    }

    @Test
    public void testSort5() throws Exception {

        int a[] = {1};
        insertionSort.sort(a);
        assertEquals("[1]", ArrayHelper.arrayAsString(a));
    }

    @Test
    public void testSort6() throws Exception {

        int a[] = {1,2};
        insertionSort.sort(a);
        assertEquals("[1,2]", ArrayHelper.arrayAsString(a));
    }

    @Test
    public void testSort7() throws Exception {

        int a[] = {2,1};
        insertionSort.sort(a);
        assertEquals("[1,2]", ArrayHelper.arrayAsString(a));
    }

    @Test
    public void testSort8() throws Exception {

        int a[] = {5,1,4,3,8,6,9,10,7,2};
        insertionSort.sort(a);
        assertEquals("[1,2,3,4,5,6,7,8,9,10]", ArrayHelper.arrayAsString(a));
    }
}
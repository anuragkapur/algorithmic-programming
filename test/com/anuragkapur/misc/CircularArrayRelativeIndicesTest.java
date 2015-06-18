package com.anuragkapur.misc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class CircularArrayRelativeIndicesTest {

    CircularArrayRelativeIndices circularArrayRelativeIndices = new CircularArrayRelativeIndices();

    @Test
    public void testHasCycle1() throws Exception {
        assertEquals(false, circularArrayRelativeIndices.hasCycle(null));
    }

    @Test
    public void testHasCycle2() throws Exception {
        assertEquals(true, circularArrayRelativeIndices.hasCycle(new int[0]));
        assertEquals(true, circularArrayRelativeIndices.hasCycle(new int[1]));
    }

    @Test
    public void testHasCycle3() throws Exception {
        assertEquals(true, circularArrayRelativeIndices.hasCycle(new int[]{2, 2, -1}));
    }

    @Test
    public void testHasCycle4() throws Exception {
        assertEquals(true, circularArrayRelativeIndices.hasCycle(new int[]{-1, -1, -1}));
    }

    @Test
    public void testHasCycle5() throws Exception {
        assertEquals(true, circularArrayRelativeIndices.hasCycle(new int[]{-2, 1, -2}));
    }

    @Test
    public void testHasCycle6() throws Exception {
        assertEquals(false, circularArrayRelativeIndices.hasCycle(new int[]{-1, 3, -2}));
    }
}
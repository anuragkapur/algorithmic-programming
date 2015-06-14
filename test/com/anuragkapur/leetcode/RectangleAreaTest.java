package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class RectangleAreaTest {

    RectangleArea rectangleArea = new RectangleArea();

    @Test
    public void testComputeArea1() throws Exception {
        assertEquals(45, rectangleArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    @Test
    public void testComputeArea2() throws Exception {
        assertEquals(17,rectangleArea.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }

    @Test
    public void testComputeArea3() throws Exception {
        assertEquals(17, rectangleArea.computeArea(-2, -2, 2, 2, -4, 3, -3, 4));
    }
}
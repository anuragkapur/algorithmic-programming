package com.anuragkapur.ctci.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author anuragkapur
 */
public class Prob1_6_RotateMatrixTest {

    Prob1_6_RotateMatrix rotateMatrix = new Prob1_6_RotateMatrix();

    @Test
    public void testRotate1() throws Exception {

        int a[][] = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
        };

        int expectedOutput[][] = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };

        assertArrayEquals(expectedOutput, rotateMatrix.rotate(a));
    }

    @Test
    public void testRotate2() throws Exception {

        int a[][] = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };

        int expectedOutput[][] = {
                {9, 5, 1},
                {10, 6, 2},
                {11, 7, 3}
        };

        assertArrayEquals(expectedOutput, rotateMatrix.rotate(a));
    }
}
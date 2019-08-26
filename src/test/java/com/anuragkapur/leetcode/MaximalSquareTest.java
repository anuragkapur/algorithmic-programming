package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class MaximalSquareTest {

    MaximalSquare maximalSquare = new MaximalSquare();

    @Test
    public void testMaximalSquare1() throws Exception {
        assertEquals(0, maximalSquare.maximalSquare(null));
        assertEquals(0, maximalSquare.maximalSquare(new char[4][0]));
        assertEquals(0, maximalSquare.maximalSquare(new char[0][4]));
    }

    @Test
    public void testMaximalSquare2() throws Exception {
        char matrix[][] = new char[4][5];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};

        assertEquals(4, maximalSquare.maximalSquare(matrix));
    }

    @Test
    public void testMaximalSquare3() throws Exception {
        char matrix[][] = new char[4][4];
        matrix[0] = new char[]{'1', '1', '1', '1'};
        matrix[1] = new char[]{'1', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '1', '1', '1'};

        assertEquals(16, maximalSquare.maximalSquare(matrix));
    }

    @Test
    public void testMaximalSquare4() throws Exception {
        char matrix[][] = new char[4][4];
        matrix[0] = new char[]{'1', '1', '1', '1'};
        matrix[1] = new char[]{'1', '1', '1', '1'};
        matrix[2] = new char[]{'1', '0', '1', '1'};
        matrix[3] = new char[]{'1', '1', '1', '1'};

        assertEquals(4, maximalSquare.maximalSquare(matrix));
    }
}
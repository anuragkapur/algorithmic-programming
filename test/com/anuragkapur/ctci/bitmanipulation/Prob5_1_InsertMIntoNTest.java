package com.anuragkapur.ctci.bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class Prob5_1_InsertMIntoNTest {

    Prob5_1_InsertMIntoN prob5_1_insertMIntoN = new Prob5_1_InsertMIntoN();

    @Test
    public void testInsert1() throws Exception {
        assertEquals(1100, prob5_1_insertMIntoN.insert(1024, 19, 6, 2));
    }

    @Test
    public void testInsert2() throws Exception {
        assertEquals(121, prob5_1_insertMIntoN.insert(109, 12, 4, 1));
    }
}
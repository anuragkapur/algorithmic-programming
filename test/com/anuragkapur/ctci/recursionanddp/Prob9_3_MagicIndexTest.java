package com.anuragkapur.ctci.recursionanddp;

import org.junit.Test;

import static org.junit.Assert.*;

public class Prob9_3_MagicIndexTest {

    @Test
    public void testFindMagicIndex1() throws Exception {
        int a[] = {1,2,3};
        assertEquals(-1, new Prob9_3_MagicIndex().findMagicIndex(a, 0, a.length-1));
    }

    @Test
    public void testFindMagicIndex2() throws Exception {
        int a[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
        assertEquals(7, new Prob9_3_MagicIndex().findMagicIndex(a, 0, a.length-1));
    }

}
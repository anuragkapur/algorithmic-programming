package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class LargestNumberTest {

    LargestNumber largestNumber = new LargestNumber();

    @Test
    public void testLargestNumber0() throws Exception {
        assertEquals("303030930", largestNumber.largestNumber(new int[]{30, 3030309}));
    }

    @Test
    public void testLargestNumber1() throws Exception {
        assertNull(largestNumber.largestNumber(null));
    }

    @Test
    public void testLargestNumber2() throws Exception {
        assertEquals("9534330", largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void testLargestNumber3() throws Exception {
        assertEquals("0", largestNumber.largestNumber(new int[]{0, 0, 0}));
    }

    @Test
    public void testLargestNumber4() throws Exception {
        assertEquals("1", largestNumber.largestNumber(new int[]{1}));
    }

    @Test
    public void testLargestNumber5() throws Exception {
        assertEquals("9609938824824769735703560743981399", largestNumber.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
    }

    @Test
    public void testLargestNumber6() throws Exception {
        assertEquals("12812", largestNumber.largestNumber(new int[]{128, 12}));
    }

    @Test
    public void testLargestNumber7() throws Exception {
        assertEquals("12121", largestNumber.largestNumber(new int[]{121, 12}));
    }

    @Test
    public void testLargestNumber8() throws Exception {
        String expected = "98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048";
        assertEquals(expected, largestNumber.largestNumber(new int[]{4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398}));
    }
}
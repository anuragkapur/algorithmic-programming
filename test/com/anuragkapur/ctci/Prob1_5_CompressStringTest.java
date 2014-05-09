package com.anuragkapur.ctci;

import org.junit.Assert;
import org.junit.Test;

public class Prob1_5_CompressStringTest {

    @Test
    public void testCompressedString1() throws Exception {

        String str = "aaabbcccd";
        Assert.assertEquals("a3b2c3d1", Prob1_5_CompressString.compressedString(str));
    }

    @Test
    public void testCompressedString2() throws Exception {

        String str = "";
        Assert.assertEquals("", Prob1_5_CompressString.compressedString(str));
    }

    @Test
    public void testCompressedString3() throws Exception {

        String str = "aabbcc";
        Assert.assertEquals("aabbcc", Prob1_5_CompressString.compressedString(str));
    }
}
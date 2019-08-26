package com.anuragkapur.misc;

import org.junit.Assert;
import org.junit.Test;

public class StringReverseTest {

    @Test
    public void testReverse1() throws Exception {
        Assert.assertEquals("dcba", StringReverse.reverse("abcd"));
    }

    @Test
    public void testReverse2() throws Exception {
        Assert.assertEquals("edcba", StringReverse.reverse("abcde"));
    }

    @Test
    public void testReverse3() throws Exception {
        Assert.assertEquals("Hello World!", StringReverse.reverse("!dlroW olleH"));
    }
}
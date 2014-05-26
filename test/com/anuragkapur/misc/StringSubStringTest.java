package com.anuragkapur.misc;

import org.junit.Assert;
import org.junit.Test;

public class StringSubStringTest {

    @Test
    public void testIsSubString1() throws Exception {
        String parent = "abc";
        String find = "bc";

        Assert.assertEquals(true, StringSubString.isSubString(find.toCharArray(), parent.toCharArray()));
    }

    @Test
    public void testIsSubString2() throws Exception {
        String parent = "abc";
        String find = "ba";

        Assert.assertEquals(false, StringSubString.isSubString(find.toCharArray(), parent.toCharArray()));
    }

    @Test
    public void testIsSubString3() throws Exception {
        String parent = "abc";
        String find = "ac";

        Assert.assertEquals(false, StringSubString.isSubString(find.toCharArray(), parent.toCharArray()));
    }

    @Test
    public void testIsSubString4() throws Exception {
        String parent = "aaabc";
        String find = "aabc";

        Assert.assertEquals(true, StringSubString.isSubString(find.toCharArray(), parent.toCharArray()));
    }
}
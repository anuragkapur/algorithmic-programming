package com.anuragkapur.ctci.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Prob1_1_2_AreAllCharsUniqueInStringTest {

    @Test
    public void testAllCharsUnique() throws Exception {
        Assert.assertEquals(true, Prob1_1_2_AreAllCharsUniqueInString.allCharsUnique("qwertyuiop"));
        Assert.assertEquals(false, Prob1_1_2_AreAllCharsUniqueInString.allCharsUnique("qwerteyuiop"));
        Assert.assertEquals(true, Prob1_1_2_AreAllCharsUniqueInString.allCharsUnique("qwertyuQiop"));
        Assert.assertEquals(true, Prob1_1_2_AreAllCharsUniqueInString.allCharsUnique("qw@er%tyuio&p"));
        Assert.assertEquals(false, Prob1_1_2_AreAllCharsUniqueInString.allCharsUnique("qw@er%@tyuio&p"));
    }
}
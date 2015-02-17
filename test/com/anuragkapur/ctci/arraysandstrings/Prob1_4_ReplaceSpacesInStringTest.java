package com.anuragkapur.ctci.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Prob1_4_ReplaceSpacesInStringTest {

    @Test
    public void testReplaceSpaces() throws Exception {
        String answer = Prob1_4_ReplaceSpacesInString.replaceSpaces("Mr John Smith    ");
        Assert.assertEquals(answer, "Mr%20John%20Smith");
    }
}
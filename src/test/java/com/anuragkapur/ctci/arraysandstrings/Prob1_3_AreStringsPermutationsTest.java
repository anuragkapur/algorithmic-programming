package com.anuragkapur.ctci.arraysandstrings;

import com.anuragkapur.ctci.arraysandstrings.Prob1_3_1_AreStringsPermutations;
import com.anuragkapur.ctci.arraysandstrings.Prob1_3_AreStringsPermutations;
import org.junit.Assert;
import org.junit.Test;

public class Prob1_3_AreStringsPermutationsTest {

    @Test
    public void testCheckIfPermutations1() throws Exception {

        String str1 = "abcd" + '\u0000' + '\u0000';
        String str2 = '\u0000' + "debca";

        Assert.assertEquals(false, Prob1_3_AreStringsPermutations.checkIfPermutations(str1, str2));
        Assert.assertEquals(false, Prob1_3_1_AreStringsPermutations.checkIfPermutations(str1, str2));
    }

    @Test
    public void testCheckIfPermutations2() throws Exception {
        String str1 = "abcd";
        String str2 = "bcda";
        Assert.assertEquals(true, Prob1_3_AreStringsPermutations.checkIfPermutations(str1, str2));
        Assert.assertEquals(true, Prob1_3_1_AreStringsPermutations.checkIfPermutations(str1, str2));
    }

    @Test
    public void testCheckIfPermutations3() throws Exception {
        String str1 = "abc d";
        String str2 = "b cda";
        Assert.assertEquals(true, Prob1_3_AreStringsPermutations.checkIfPermutations(str1, str2));
        Assert.assertEquals(true, Prob1_3_1_AreStringsPermutations.checkIfPermutations(str1, str2));
    }

    @Test
    public void testCheckIfPermutations4() throws Exception {
        String str1 = "abc d";
        String str2 = "becda";
        Assert.assertEquals(false, Prob1_3_AreStringsPermutations.checkIfPermutations(str1, str2));
        Assert.assertEquals(false, Prob1_3_1_AreStringsPermutations.checkIfPermutations(str1, str2));
    }
}
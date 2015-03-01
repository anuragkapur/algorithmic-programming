package com.anuragkapur.ctci.recursionanddp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Prob9_5_StringPermutationsTest {

    @Test
    public void testGetPermutations1() throws Exception {
        List<String> permutations = new Prob9_5_StringPermutations().getPermutations("abcd");
        int count = permutations.size();
        assertEquals(24, count);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
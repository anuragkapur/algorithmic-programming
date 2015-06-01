package com.anuragkapur.pie.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class RemoveSpecifiedCharsTest {

    @Test
    public void testRemove() throws Exception {

        String input = "Battle of the Vowels: Hawaii vs. Grozny";
        String remove = "aeiou";

        String output = "Bttl f th Vwls: Hw vs. Grzny";

        assertEquals(output, RemoveSpecifiedChars.remove(input, remove));
    }
}
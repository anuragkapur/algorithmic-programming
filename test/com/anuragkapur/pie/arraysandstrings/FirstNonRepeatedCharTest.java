package com.anuragkapur.pie.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class FirstNonRepeatedCharTest {

    @Test
    public void testFind1() throws Exception {
        String str = "abc@£$abc£$";

        FirstNonRepeatedChar firstNonRepeatedChar = new FirstNonRepeatedChar();
        assertEquals("@", firstNonRepeatedChar.find(str));
    }

    @Test
    public void testFind2() throws Exception {
        String str = "\uD862\uDF4Eabcdabcdabcd\uD842\uDF20\uD862\uDF4E";
        System.out.println("\uD842\uDF20");
        FirstNonRepeatedChar firstNonRepeatedChar = new FirstNonRepeatedChar();
        assertEquals("\uD842\uDF20", firstNonRepeatedChar.find(str));
    }
}
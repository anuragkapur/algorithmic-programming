package com.anuragkapur.pie.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class ReverseWordsTest {

    ReverseWords reverseWords = new ReverseWords();

    @Test
    public void testReverse1() throws Exception {

        String input = "test this";
        assertEquals("this test", reverseWords.reverse(input));
    }

    @Test
    public void testReverse2() throws Exception {

        String input = "test  this";
        assertEquals("this  test", reverseWords.reverse(input));
    }

    @Test
    public void testReverse3() throws Exception {

        String input = "";
        assertEquals("", reverseWords.reverse(input));
    }

    @Test
    public void testReverse4() throws Exception {

        String input = " ";
        assertEquals(" ", reverseWords.reverse(input));
    }

    @Test
    public void testReverse54() throws Exception {

        String input = "a  ";
        assertEquals("  a", reverseWords.reverse(input));
    }
}
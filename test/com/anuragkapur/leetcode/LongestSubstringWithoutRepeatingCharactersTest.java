package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    LongestSubstringWithoutRepeatingCharacters longestSubstring = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void testLengthOfLongestSubstring1() throws Exception {
        assertEquals(0, longestSubstring.lengthOfLongestSubstring(null));
    }

    @Test
    public void testLengthOfLongestSubstring2() throws Exception {
        assertEquals(1, longestSubstring.lengthOfLongestSubstring("aaaaaaaaa"));
    }

    @Test
    public void testLengthOfLongestSubstring3() throws Exception {
        assertEquals(3, longestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testLengthOfLongestSubstring4() throws Exception {
        assertEquals(3, longestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testLengthOfLongestSubstring5() throws Exception {
        assertEquals(3, longestSubstring.lengthOfLongestSubstring("abac"));
    }

    @Test
    public void testLengthOfLongestSubstring6() throws Exception {
        assertEquals(5, longestSubstring.lengthOfLongestSubstring("tmmzuxt"));
    }
}
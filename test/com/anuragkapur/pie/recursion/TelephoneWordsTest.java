package com.anuragkapur.pie.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class TelephoneWordsTest {

    TelephoneWords telephoneWords = new TelephoneWords();

    @Test
    public void testWords1() throws Exception {

        assertNull(telephoneWords.words(null));
        assertNull(telephoneWords.words(new int[0]));
    }

    @Test
    public void testWords2() throws Exception {

        int a[] = {1,2};
        assertEquals("[1A, 1B, 1C]", telephoneWords.words(a).toString());
    }

    @Test
    public void testWords3() throws Exception {

        int a[] = {1,2,3};
        assertEquals("[1AD, 1AE, 1AF, 1BD, 1BE, 1BF, 1CD, 1CE, 1CF]", telephoneWords.words(a).toString());
    }
}
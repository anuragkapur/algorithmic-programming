package com.anuragkapur.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class LongestPalindromeSubstringTest {

    LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();

    @Test
    public void testLongestPalindrome1() throws Exception {
        assertNull(longestPalindromeSubstring.longestPalindrome(null));
    }

    @Test
    public void testLongestPalindrome2() throws Exception {
        assertEquals("abccba", longestPalindromeSubstring.longestPalindrome("eabccbartbw"));
    }

    @Test
    public void testLongestPalindrome3() throws Exception {
        assertEquals("abcdeedcba", longestPalindromeSubstring.longestPalindrome("eeeabccbartbwabcdeedcba"));
    }

    @Test
    public void testLongestPalindrome4() throws Exception {
        assertEquals("abccba", longestPalindromeSubstring.longestPalindrome("eeeabccbartbwabcdetredcba"));
    }

    @Test
    public void testLongestPalindrome5() throws Exception {
        assertEquals("a", longestPalindromeSubstring.longestPalindrome("a"));
        assertEquals("aa", longestPalindromeSubstring.longestPalindrome("aa"));
        assertEquals("aba", longestPalindromeSubstring.longestPalindrome("aba"));
        assertEquals("abba", longestPalindromeSubstring.longestPalindrome("abba"));
    }

    @Test
    public void testLongestPalindrome6() throws Exception {
        //String input = "kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv";
        String input = "vaavaqahaq";
        assertEquals("qahaq", longestPalindromeSubstring.longestPalindrome(input));
    }
}
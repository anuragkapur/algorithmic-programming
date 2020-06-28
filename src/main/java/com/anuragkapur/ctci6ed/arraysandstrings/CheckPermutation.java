package com.anuragkapur.ctci6ed.arraysandstrings;

/*

abcd
abc d
 abcd

Assumptions
* spaces are treated as regular characters

check length
  if length not not equal, return false

approach 1
sort both - O(nlogn)
compare both sorted strings, character by character - O(n)
overall - O(nlogn)
  * sorting may take extra space
  * original strings may be mutated and lost, unless we create a copy of each before sort

approach 2
str1 = aba
str2 = baa

iterate over str1
  a: 2
  find number of a in str2
  if not mataching return false

RTC = O(n^2)
SC = O(1)

approach 3
store in map: iterate over str1, find frequency of each char
store in map: iterate over str1, find frequency of each char

compare keyset size in both maps
  if not equal return false
  else compare value of each key
    if not equal return false

RTC: O(n)
SC: O(n)
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class CheckPermutation {

    private static Map<Character, Integer> getCharFrequenciesMap(String str) {

        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char ch : str.toCharArray()) {
            int currentCount = 0;
            if (charFrequencies.containsKey(ch)) {
                currentCount = charFrequencies.get(ch);
            }
            charFrequencies.put(ch, currentCount + 1);
        }

        return charFrequencies;
    }

    private static boolean checkPermutation(String str1, String str2) {

        if(str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charFrequencies1 = getCharFrequenciesMap(str1);
        Map<Character, Integer> charFrequencies2 = getCharFrequenciesMap(str2);

        if (charFrequencies1.keySet().size() != charFrequencies2.keySet().size()) {
            return false;
        }

        for (char ch : charFrequencies1.keySet()) {
            int countInStr1 = charFrequencies1.get(ch);
            int countInStr2 = charFrequencies2.get(ch);

            if (countInStr1 != countInStr2) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        String str1 = "abcd a";
        String str2 = " aacdb";

        System.out.println(checkPermutation(str1, str2));
    }
}




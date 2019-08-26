package com.anuragkapur.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Compute all combinations of the characters in the given string using
 * recursion
 * 
 * @author anuragkapur
 */
public class ComputeCombinationsRecursive {

	private static List<String> computeCombinations(String input) {
		List<String> combinations = new ArrayList<String>();

		if (input.length() == 1) {
			combinations.add(input);
			combinations.add("");
		} else {
			char c = input.charAt(0);
			String remaining = input.substring(1);

			List<String> combinationsOfRemaining = computeCombinations(remaining);
			for (Iterator<String> iterator = combinationsOfRemaining.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				combinations.add(string);
				combinations.add(c + string);
			}
		}

		return combinations;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> combinations = computeCombinations("abcd");
		int count = 0;
		for (Iterator<String> iterator = combinations.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(++count + " :: " + string);
		}
	}
}
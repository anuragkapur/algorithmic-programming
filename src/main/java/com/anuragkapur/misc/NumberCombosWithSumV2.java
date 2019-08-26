package com.anuragkapur.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of integers. Find all the combinations of the numbers
 * of the array, that sum to another number(might be different for different
 * combination) from the array. One property of the array: The maximum number of
 * the array will not be much greater than the others.
 * 
 * Bottom Up Approach, and thus in average case scenarios more efficient that
 * {@link NumberCombosWithSum}
 * 
 * @author anurag.kapur
 */
public class NumberCombosWithSumV2 {

	public static int count = 0;

	public static void recurseCombinations(List<Integer> numbers, int key, List<Integer> partial) {

		System.out.println(count++);

		if (partial.size() > 0) {
			// List is not empty. Iterate and compute sum.
			// If sum == key, print to STDOUT.
			Object[] nums = partial.toArray();
			// System.out.println(Arrays.toString(nums));
			int sum = 0;
			for (Object num : nums) {
				Integer number = (Integer) num;
				sum += number.intValue();
			}

			if (sum == key) {
				// System.out.println(Arrays.toString(nums));
			} else if (sum > key) {
				return;
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			Integer num = numbers.get(i);

			List<Integer> remainingNumbers = new ArrayList<Integer>(numbers);
			remainingNumbers.remove(i);

			List<Integer> partialList = new ArrayList<Integer>(partial);
			partialList.add(num);

			recurseCombinations(remainingNumbers, key, partialList);
		}
	}

	public static void findCombinations(Integer a[], int key) {
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(a));
		recurseCombinations(numbers, key, new ArrayList<Integer>());
	}

	public static void main(String args[]) {
		Integer a[] = { 2, 4, 1, 3, 8, 4, 6 };
		// Integer a[] = { 1, 2 };
		int key = 11;
		findCombinations(a, key);
	}
}

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
 * @author anurag.kapur
 */
public class NumberCombosWithSum {
	
	public static int count = 0;

	public static void recurseCombinations(List<Integer> numbers, int key) {
		
		System.out.println(count++);

		if (numbers.size() > 0) {
			// List is not empty. Iterate and compute sum.
			// If sum == key, print to STDOUT.
			Object[] nums = numbers.toArray();
			int sum = 0;
			for (Object num : nums) {
				Integer number = (Integer) num;
				sum += number.intValue();
			}

			if (sum == key) {
				System.out.println(Arrays.toString(nums));
			}else if(key > sum) {
				return;
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			Integer num = numbers.get(i);

			List<Integer> remainingNumbers = new ArrayList<Integer>(numbers);
			remainingNumbers.remove(i);

			recurseCombinations(remainingNumbers, key);
		}
	}

	public static void findCombinations(Integer a[], int key) {
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(a));
		recurseCombinations(numbers, key);
	}

	public static void main(String args[]) {
		Integer a[] = {2,4,1,3,8,4,6};
		//Integer a[] = { 1, 2 };
		int key = 11;
		findCombinations(a, key);
	}
}

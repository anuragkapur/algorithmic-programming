package com.anuragkapur.leetcode;

import java.util.*;

/**
 * assumptions
 *   * both positive and negative integers
 *
 * approach 1
 * [11, 2, 7, 15]
 * find all possible number pairs using 2 for-loops
 * RTC: O(n^2)
 *
 * approach 2
 * pass one add to HashMap (O(n))
 * pass two, for each item, check if target-item exists in hashmap (O(n))
 * RTC: O(n)
 * @author anuragkapur
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> indices = map.get(nums[i]);
                indices.add(i);
                map.put(nums[i], indices);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(nums[i], indices);
            }
        }

        for (int firstNum : map.keySet()) {
            int firstNumIndex = map.get(firstNum).get(0);
            int secondNum = target - firstNum;
            if(map.containsKey(secondNum)) {
                List<Integer> indices = map.get(secondNum);
                for (Integer index : indices) {
                    if (index != firstNumIndex) {
                        return new int[]{firstNumIndex, index};
                    }
                }
            }
        }

        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

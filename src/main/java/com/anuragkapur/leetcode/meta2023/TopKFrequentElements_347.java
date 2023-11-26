package com.anuragkapur.leetcode.meta2023;

import java.util.*;

public class TopKFrequentElements_347 {

    /**
     * Runtime Complexity: O(nlogk)
     * Space Complexity: O(n+k)
     * Leetcode Status: Accepted; 15ms; Beats 32.86% of users with Java
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        // O(n)
        for (int i=0; i<nums.length; i++) {
            if (numToFrequencyMap.containsKey(nums[i])) {
                int freq = numToFrequencyMap.get(nums[i]);
                numToFrequencyMap.put(nums[i], freq+1);
            } else {
                numToFrequencyMap.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(numToFrequencyMap.get(a), numToFrequencyMap.get(b)));
        // O(nlogk)
        for (Integer n : numToFrequencyMap.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] answer = new int[k];
        int i = 0;
        // O(klogk)
        while (!minHeap.isEmpty()) {
            answer[i] = minHeap.poll();
            i++;
        }

        return answer;
    }

    /**
     * Runtime Complexity: O(nlogn)
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        Map<Integer, List<Integer>> frequencyToNumsMap = new HashMap<>();

        for (int num : nums) {
            int frequency = 1;
            if (numFrequencyMap.containsKey(num)) {
                frequency = numFrequencyMap.get(num) + 1;
            }
            numFrequencyMap.put(num, frequency);
        }

        for (int num : numFrequencyMap.keySet()) {
            int frequency = numFrequencyMap.get(num);
            if (frequencyToNumsMap.containsKey(frequency)) {
                List<Integer> n = frequencyToNumsMap.get(frequency);
                n.add(num);
            } else {
                List<Integer> n = new ArrayList<>();
                n.add(num);
                frequencyToNumsMap.put(frequency, n);
            }
        }

        List<Integer> frequencies = new ArrayList<>(frequencyToNumsMap.keySet());
        frequencies.sort((a, b) -> Integer.compare(b, a));
        int[] answer = new int[k];
        int i = 0;
        for (int frequency : frequencies) {
            List<Integer> n = frequencyToNumsMap.get(frequency);
            for (int num : n) {
                answer[i] = num;
                i++;
            }
            if (i+1 > k) {
                break;
            }
        }
        return answer;
    }
}

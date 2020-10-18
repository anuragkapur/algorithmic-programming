package com.anuragkapur.leetcode.fb;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestInArray_215 {

    Random rand = new Random();

    /**
     * RTC: O(n), average and O(n^2), worst case
     */
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        return quickSelect(nums, 0, nums.length-1, k, length-1);
    }

    private int quickSelect(int[] nums, int start, int end, int k, int lastIndex) {
        if (start == end) {
            return nums[start];
        }

        int pivotIndex = partition(nums, start, end);
        if (lastIndex-pivotIndex+1 == k) {
            return nums[pivotIndex];
        } else if (lastIndex-pivotIndex+1 > k) {
            // look right
            return quickSelect(nums, pivotIndex+1, end, k, lastIndex);
        } else {
            // look left
            return quickSelect(nums, start, pivotIndex-1, k, lastIndex);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int randomIndex = getRandom(start, end);
        swap(nums, randomIndex, end);
        int pivotElement = nums[end];

        int i = start;
        for (int j=start; j<end; j++) {
            if (nums[j] < pivotElement) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int getRandom(int start, int end) {
        int bound = end - start + 1;
        return rand.nextInt(bound) + start;
    }

    public static void main(String[] args) {
        KthLargestInArray_215 a = new KthLargestInArray_215();
        int[] nums = {6, 2, 8, 3, 4, 5, 9, 7, 1};
        System.out.println(a.findKthLargest(nums, 4));

        new Random().nextInt();
    }

    /**
     * RTC: O(nlogk)
     * SC: O(k)
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int size = 0;
        for (int i=0; i<nums.length; i++) {
            q.add(nums[i]);
            size ++;
            if (size > k) {
                q.poll();
                size --;
            }
        }

        return q.poll();
    }

    /**
     * RTC: O(nlogn)
     * SC: O(1)
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

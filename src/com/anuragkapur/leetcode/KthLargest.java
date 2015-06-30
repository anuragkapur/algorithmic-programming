package com.anuragkapur.leetcode;

/**
 * @author anuragkapur
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length-k, 0, nums.length-1);
    }

    private int findKthLargest(int[] nums, int indexOfK, int start, int end) {

        if (start == end) {
            if (indexOfK == start) {
                return nums[start];
            } else {
                // this should never happen, throw custom exception
                return -1;
            }
        }

        int pivot = partition(nums, start, end);
        if (pivot == indexOfK) {
            return nums[pivot];
        }

        //TODO: k passed to the recursive calls is incorrect at the moment
        if (pivot < indexOfK) {
            return findKthLargest(nums, indexOfK, pivot+1, end);
        } else {
            return findKthLargest(nums, indexOfK, start, pivot-1);
        }
    }

    /**
     *
     * @param a
     * @param start
     * @param end
     * @return index of element in array <code>a</code> that is in its final position in the sorted version of array
     *          <code>a</code>
     */
    private int partition(int a[], int start, int end) {

        int trailer = start-1;
        int leader = start;

        while(leader < end) {
            if (a[leader] > a[end]) {
                leader ++;
            } else {
                trailer ++;
                swap(a, trailer, leader);
                leader ++;
            }
        }

        trailer ++;
        swap(a, trailer, end);

        return trailer;
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

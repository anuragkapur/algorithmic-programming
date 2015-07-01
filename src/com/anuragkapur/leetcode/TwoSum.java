package com.anuragkapur.leetcode;

/**
 * @author anuragkapur
 */
public class TwoSum {

    /**
     * Running time: O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int answer[] = new int[2];

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    answer[0] = i+1;
                    answer[1] = j+1;
                    return answer;
                }
            }
        }

        return null;
    }
}

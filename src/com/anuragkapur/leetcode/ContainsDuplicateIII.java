package com.anuragkapur.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //return solution1(nums, k, t);

        if (nums == null || nums.length < 2 || k <= 0 || t < 0) {
            return false;
        }

        Map<Integer, Bucket> bucketMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucketKey = getBucketKey(nums[i], t);

            // check if bucket exists
            if (bucketMap.containsKey(bucketKey)) {
                // check each pair in bucket
                List<Pair> pairs = bucketMap.get(bucketKey).pairs;
                for(Pair pair : pairs) {
                    int diff = Math.abs(nums[i] - pair.num);
                    if (i - pair.index <= k && diff <= t && diff >= 0) {
                        return true;
                    }
                }
                pairs.add(new Pair(nums[i], i));
            } else {
                List<Pair> pairs = new ArrayList<>();
                pairs.add(new Pair(nums[i], i));
                Bucket bucket = new Bucket();
                bucket.pairs = pairs;
                bucketMap.put(bucketKey, bucket);
            }

            // check adjoining buckets too
            if (existsInBucket(bucketMap, bucketKey-1, i, nums[i], k, t)) {
                return true;
            }
            if (existsInBucket(bucketMap, bucketKey + 1, i, nums[i], k, t)) {
                return true;
            }
        }

        return false;
    }

    private boolean existsInBucket(Map<Integer, Bucket> bucketMap, int bucketKey, int i, int num, int k, int t) {

        if (bucketMap.containsKey(bucketKey)) {
            // check each pair in bucket
            List<Pair> pairs = bucketMap.get(bucketKey).pairs;
            for (Pair pair : pairs) {
                if (i - pair.index <= k && Math.abs(num - pair.num) <= t) {
                    return true;
                }
            }
        }

        return false;
    }


    private class Pair {
        int num;
        int index;

        Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    private class Bucket {
        List<Pair> pairs;
    }

    private int getBucketKey(int num, int t) {
        if (t == 0) {
            return num;
        }

        return num / (t+1);
    }

    /**
     * Running time: O(n*k)
     * Space complexity: O(1)
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    private boolean solution1(int nums[], int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length && j<=i+k; j++) {
                if(Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }

        return false;
    }
}

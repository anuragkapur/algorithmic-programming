package com.anuragkapur.leetcode.fb2021;

import java.util.*;

public class KClosestPointsToOrigin_973 {

    /**
     * RTC: O(n*log(n))
     * where,
     *  n = number of points
     */
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(this::getDistance));
        int[][] kClosest = new int[K][2];
        for (int i=0; i<K; i++) {
            kClosest[i] = points[i];
        }
        return kClosest;
    }

    /**
     * RTC: O(n*log(n))
     * where,
     *  n = number of points
     */
    public int[][] kClosest1(int[][] points, int K) {

        Map<Integer, List<Integer>> distanceToIndex = new HashMap<>();

        int[] distances = new int[points.length];

        // O(n)
        for (int i=0; i<points.length; i++) {
            distances[i] = getDistance(points[i]);
            if (distanceToIndex.containsKey(distances[i])) {
                distanceToIndex.get(distances[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                distanceToIndex.put(distances[i], indexList);
            }

        }

        // O(n*log(n))
        Arrays.sort(distances);

        // O(k)...O(n)
        int[][] kClosest = new int[K][2];
        for (int i=0; i<K; i++) {
            List<Integer> indexList = distanceToIndex.get(distances[i]);
            for (int j=0; j<indexList.size(); j++) {
                if (j>0) {
                    i++;
                }
                if (i<K) {
                    int indexOfPoint = indexList.get(j);
                    kClosest[i] = points[indexOfPoint];
                }
            }
        }

        return kClosest;

    }

    private int getDistance(int[] coordinates) {
        return coordinates[0]*coordinates[0] + coordinates[1]*coordinates[1];
    }
}

package com.anuragkapur.ib;

public class SquareRoot {

    public int sqrt(int A) {
        if (A <= 1) {
            return A;
        }
        return (int) searchSquare(1, A, A);
    }

    /**
     * Overflow causing multiplication can be avoided by tweaking the logic to use division instead.
     *
     * RTC: O(A)
     *
     * @param low
     * @param high
     * @param target
     * @return
     */
    public int searchSquare(int low, int high, int target) {
        if (low == high) {
            return low;
        }

        if (high - low == 1) {
            if (target / low == low)
                return low;
            else if (target / high == high)
                return high;
            else
                return low;
        }

        int mid = low + (high - low)/2;
        if (mid == target / mid) {
            return mid;
        } else if (mid < target / mid) {
            return searchSquare(mid, high, target);
        } else {
            return searchSquare(low, mid, target);
        }
    }

    /**
     * Integer overflow possible, so use `long`
     *
     * @param low
     * @param high
     * @param target
     * @return
     */
    public long searchSquare1(long low, long high, int target) {
        if (low == high) {
            return low;
        }

        if (high - low == 1) {
            long s1 = low * low;
            long s2 = high * high;
            if (target == s1)
                return low;
            else if (target == s2)
                return high;
            else
                return low;
        }

        long mid = low + (high - low)/2;
        long s = mid * mid;
        if (s == target) {
            return mid;
        } else if (s < target) {
            return searchSquare1(mid, high, target);
        } else {
            return searchSquare1(low, mid, target);
        }
    }
}

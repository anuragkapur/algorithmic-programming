package com.anuragkapur.leetcode.meta2023;

public class PowXN_50 {
    public double myPow(double x, int n) {
        // this is required so that when n is -2^31 and we changes it to 2^31, it doesn't overflow
        // https://stackoverflow.com/questions/48778382/why-i-got-an-stack-overflow-error-for-leetcode-algorithm-50
        return myPowPrivate(x, (long) n);
    }

    private double myPowPrivate(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / myPowPrivate(x, -1*n);
        } else if (n % 2 == 1) {
            return x * myPowPrivate(x*x, (n-1)/2);
        } else {
            return myPowPrivate(x*x, n/2);
        }
    }
}

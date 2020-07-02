package com.anuragkapur.ib.math;

public class FindNthFibonacci {

    public int solve(int A) {
        return fib(A);
    }

    /**
     * Correct solution, but does NOT meet RTC requirements
     *
     * @param a
     * @return
     */
    private int fib(int a) {
        if (a <= 2) {
            return 1;
        }

        int p1 = 1;
        int p2 = 1;
        int ith = p1 + p2;
        for (int i=3; i<=a; i++) {
            ith = (p1 + p2) % 1000000007;
            p1 = p2;
            p2 = ith;
        }

        return ith;
    }
}

package com.anuragkapur.ib;

public class MaxSumSquareSubMatrix {

    /**
     * RTC: O(n^2 * b^2)
     *
     * @param A
     * @param B
     * @return
     */
    public int solve(int[][] A, int B) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<=A.length-B; i++) {
            for (int j=0; j<=A[i].length-B; j++) {
                int sum = 0;
                for (int p=i; p<i+B; p++) {
                    for (int q=j; q<j+B; q++) {
                        sum += A[p][q];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}

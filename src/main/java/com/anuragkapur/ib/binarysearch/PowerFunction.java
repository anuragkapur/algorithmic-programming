package com.anuragkapur.ib.binarysearch;

public class PowerFunction {

    /**
     * Doesn't pass all tests; Number overflow problems
     *
     * @param x
     * @param n
     * @param d
     * @return
     */
    public int pow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }

        long ans = 0;

        if (n == 0) {
            ans = 1;
        } else if (n == 1) {
            ans = x % d;
        } else {
            if (n % 2 == 0) {
                int half = n / 2;
                int halfPow = pow(x, half, d);
                ans = (halfPow * halfPow) % d;
            } else {
                int half = (n-1) / 2;
                int halfPow = pow(x, half, d);
                ans = (halfPow * halfPow * x) % d;
            }
        }

        if (ans < 0) {
            ans = d + ans;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        PowerFunction p = new PowerFunction();
        System.out.println(p.pow(71045970, 41535484, 64735492));
    }
}

package com.anuragkapur.ib.binarysearch;

import java.math.BigInteger;

public class PowerFunction {

    public int pow(int x, int n, int d) {
        BigInteger bx = BigInteger.valueOf(x);
        BigInteger bn = BigInteger.valueOf(n);
        BigInteger bd = BigInteger.valueOf(d);
        return powRec(bx, bn, bd).intValue();
    }

    public BigInteger powRec(BigInteger x, BigInteger n, BigInteger d) {
        if (x.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        }

        BigInteger ans;

        if (n.compareTo(BigInteger.ZERO) == 0) {
            ans = BigInteger.ONE;
        } else if (n.compareTo(BigInteger.ONE) == 0) {
            ans = x.mod(d);
        } else {
            if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
                BigInteger half = n.divide(BigInteger.valueOf(2));
                BigInteger halfPow = powRec(x, half, d);
                ans = halfPow.multiply(halfPow).mod(d);
            } else {
                BigInteger half = n.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));
                BigInteger halfPow = powRec(x, half, d);
                ans = halfPow.multiply(halfPow).multiply(x).mod(d);
            }
        }

        if (ans.compareTo(BigInteger.ZERO) < 0) {
            ans = d.add(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        PowerFunction p = new PowerFunction();
        System.out.println(p.pow(71045970, 41535484, 64735492));
    }
}

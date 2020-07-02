package com.anuragkapur.ib;

/**
 * Correct solution but does not meet RTC requirements
 */
public class SumOfPairwiseHammingDistance {

    public int hammingDistance(final int[] A) {

        if (A.length <= 1) {
            return 0;
        }

        int hDist = 0;

        for (int i=0; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                if (i != j) {
                    hDist += (hammingDistance(A[i], A[j]) * 2);
                }
            }
        }

        return hDist;
    }

    private int hammingDistance(int a, int b) {
        int xor = a ^ b;
        char[] chs = Integer.toBinaryString(xor).toCharArray();
        int hDist = 0;
        for (int i=0; i<chs.length; i++) {
            if (chs[i] == '1') {
                hDist ++;
            }
        }
        return hDist;
    }

    private int hammingDistance1(int a, int b) {
        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);

        int diff = Math.abs(sa.length() - sb.length());
        if (sa.length() != sb.length()) {
            StringBuilder builder = new StringBuilder();
            for (int i=0; i<diff; i++) {
                builder.append("0");
            }
            if (sa.length() < sb.length()) {
                sa = builder.toString() + sa;
            } else {
                sb = builder.toString() + sb;
            }
        }

        int hDist = 0;
        for (int i=0; i<sa.length(); i++) {
            if (sa.charAt(i) != sb.charAt(i)) {
                hDist ++;
            }
        }

        return hDist;
    }
}

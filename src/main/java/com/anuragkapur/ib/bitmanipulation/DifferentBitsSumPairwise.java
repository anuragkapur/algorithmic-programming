package com.anuragkapur.ib.bitmanipulation;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {

    /**
     * Partially correct answer. Time Limit Exceeded.
     *
     * @param A
     * @return
     */
    public int cntBits(ArrayList<Integer> A) {
        long sum = 0;
        for (int i=0; i<A.size(); i++) {
            for (int j=i+1; j<A.size(); j++) {
                int interimSum = f(A.get(i), A.get(j));
                interimSum *= 2;
                sum += interimSum;
                sum = sum % 1000000007;
            }
        }
        return (int) sum;
    }

    private int f(Integer a, Integer b) {
        int xor = a ^ b;
        String xorString = Integer.toBinaryString(xor);
        int diffCount = 0;
        for (int i = 0; i < xorString.length(); i++) {
            if (xorString.charAt(i) == '1') {
                diffCount ++;
            }
        }
        return diffCount;
    }

    private String padShorterString(String smaller, String longer) {
        int diff = longer.length() - smaller.length();
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<diff; i++) {
            builder.append('0');
        }
        builder.append(smaller);
        return builder.toString();
    }
}

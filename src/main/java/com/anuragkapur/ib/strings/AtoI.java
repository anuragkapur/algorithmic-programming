package com.anuragkapur.ib.strings;

public class AtoI {

    public int atoi(final String A) {

        String a = A.trim();

        StringBuilder builder = new StringBuilder();
        char[] chs = a.toCharArray();
        boolean signed = false;
        for (int i=0; i<chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                builder.append(chs[i]);
            } else if (chs[i] == '-' || chs[i] == '+' && builder.length() == 0) {
                if (signed) {
                    break;
                } else {
                    signed = true;
                    builder.append(chs[i]);
                }
            } else {
                break;
            }
        }

        a = builder.toString();
        chs = a.toCharArray();
        boolean negative = false;
        if (signed) {
            if (chs[0] == '-') {
                negative = true;
            }
            a = a.substring(1);
        }

        if (a.length() == 0) {
            return 0;
        }
        chs = a.toCharArray();

        long answer = 0;
        for (int i=0; i<chs.length; i++) {
            double multiplier = Math.pow(10, i);
            char ch = chs[chs.length-1-i];
            int num = (int) ch;
            num = num - (int)'0';
            num *= multiplier;
            answer += num;
            if (answer > Integer.MAX_VALUE) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }

        if (negative) {
            answer *= -1;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        AtoI a = new AtoI();
        System.out.println(a.atoi("V515V"));
        System.out.println(a.atoi("7 U 0 T7165"));
        System.out.println(a.atoi("A-2"));
        System.out.println(a.atoi("-23AA"));
        System.out.println(a.atoi("+7"));
        System.out.println(a.atoi("9 2"));
    }
}

package com.anuragkapur.ib.strings;

public class ReverseTheString {
    public String solve(String A) {
        A = A.trim();
        StringBuilder builder = new StringBuilder();
        char[] chs = A.toCharArray();
        for (int i=0; i<chs.length; i++) {
            if (chs[i] == ' ') {
                builder.append(chs[i]);
                for (int j=i+1; j<chs.length; j++) {
                    if (chs[j] != chs[i]) {
                        i = j-1;
                        break;
                    }
                }
            } else {
                builder.append(chs[i]);
            }
        }
        A = builder.toString();

        String[] words = A.split(" ");
        builder = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            builder.append(words[i]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseTheString r = new ReverseTheString();
        System.out.println(r.solve("fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq"));
    }
}

package com.anuragkapur.ib.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> A) {

        StringBuilder builder = new StringBuilder();

        int pointer = 0;
        while (true) {

            char ch = ' ';

            for (int i=0; i<A.size(); i++) {
                if(A.get(i).length() > pointer) {
                    if (i == 0) {
                        ch = A.get(i).charAt(pointer);
                    } else {
                        if (ch != A.get(i).charAt(pointer)) {
                            return builder.toString();
                        }
                    }
                } else {
                    return builder.toString();
                }
            }

            builder.append(ch);
            pointer ++;
        }

    }
}

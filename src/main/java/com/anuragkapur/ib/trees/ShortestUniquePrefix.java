package com.anuragkapur.ib.trees;

import java.util.ArrayList;

public class ShortestUniquePrefix {

    /**
     * Partially Correct Answer. Wrong Answer. :-(
     */
    public ArrayList<String> prefix(ArrayList<String> A) {

        ArrayList<String> answer = new ArrayList<>();

        int[] uniqueIndices = new int[A.size()];

        for (int i=0; i<A.size(); i++) {
            char[] currentWordChars = A.get(i).toCharArray();

            while(true) {
                boolean duplicateCharFound = false;
                for (int j=i+1; j<A.size(); j++) {
                    char[] nextWordChars = A.get(j).toCharArray();
                    if (uniqueIndices[i] < nextWordChars.length && uniqueIndices[i] < currentWordChars.length) {
                        if (nextWordChars[uniqueIndices[i]] == currentWordChars[uniqueIndices[i]]) {
                            duplicateCharFound = true;
                            uniqueIndices[j] ++;
                        }
                    }
                }
                if (duplicateCharFound) {
                    uniqueIndices[i] ++;
                } else {
                    break;
                }
            }

            String prefix = A.get(i);
            if ((uniqueIndices[i]+1) < A.get(i).length()) {
                prefix = A.get(i).substring(0, uniqueIndices[i]+1);
            }
            answer.add(prefix);
        }

        return answer;
    }
}

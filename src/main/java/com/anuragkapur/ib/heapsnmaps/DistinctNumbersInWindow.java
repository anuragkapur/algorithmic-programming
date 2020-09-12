package com.anuragkapur.ib.heapsnmaps;

import java.util.*;

public class DistinctNumbersInWindow {
    Set<Integer> currentWindow = new HashSet<>();
    Map<Integer, ArrayList<Integer>> numberIndices = new HashMap<>();
    ArrayList<Integer> answer = new ArrayList<>();

    /**
     * RTC: O(N)
     */
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        if (B > A.size()) {
            return new ArrayList<>();
        }

        addFirstBNumbers(A, B);

        for (int i=B; i<A.size(); i++) {
            int fallingOfNumber = A.get(i-B);
            int newNumber = A.get(i);
            updateNumberIndices(newNumber, i);
            removeNumberIfNotInCurrentWindow(A, i-1, i-B+1, fallingOfNumber);
            currentWindow.add(newNumber);
            answer.add(currentWindow.size());
        }

        return answer;
    }

    private void addFirstBNumbers(ArrayList<Integer> A, int B) {
        for (int i=0; i<B; i++) {
            currentWindow.add(A.get(i));
            updateNumberIndices(A.get(i), i);
        }
        answer.add(currentWindow.size());
    }

    private void updateNumberIndices(int num, int i) {
        if (numberIndices.containsKey(num)) {
            numberIndices.get(num).add(i);
        } else {
            ArrayList<Integer> indices = new ArrayList<>();
            indices.add(i);
            numberIndices.put(num, indices);
        }
    }

    private void removeNumberIfNotInCurrentWindow(ArrayList<Integer> A, int end, int start, int num) {
        boolean numberPresentInCurrentWindow = false;
        ArrayList<Integer> indices = numberIndices.get(num);
        for (Integer index : indices) {
            if (index >= start && index <= end) {
                numberPresentInCurrentWindow = true;
                break;
            }
        }
        if (!numberPresentInCurrentWindow) {
            currentWindow.remove(num);
        }
    }
}

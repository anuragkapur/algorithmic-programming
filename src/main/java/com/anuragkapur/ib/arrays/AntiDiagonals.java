package com.anuragkapur.ib.arrays;

public class AntiDiagonals {

    /**
     * Correct, but does not meet RTC requirements
     * RTC: O(n^2)
     *
     * @param A
     * @return
     */
    public int[][] diagonal1(int[][] A) {

        int N = A.length;

        // Initialise answer array
        int answerRows = N*2-1;
        int[][] answer = new int[answerRows][];
        int count = 1;
        for (int i=0; i<=(answerRows-1)/2; i++) {
            answer[i] = new int[count];
            count ++;
        }
        count = count - 2;
        for (int i=((answerRows-1)/2)+1; i<answer.length; i++) {
            answer[i] = new int[count];
            count --;
        }

        int[] indexTracker = new int[answerRows];

        for (int j=0; j<N; j++) {
            for (int k=0; k<N; k++) {
                answer[j+k][indexTracker[j+k]] = A[j][k];
                indexTracker[j+k] ++;
            }
        }

        return answer;
    }

    /**
     * Refactoring of diagonal1, same RTC, but run time in absolute terms is lower than diagonal1
     *
     * @param A
     * @return
     */
    public int[][] diagonal2(int[][] A) {

        int N = A.length;
        int answerRows = N*2-1;
        int[][] answer = new int[answerRows][];
        int[] indexTracker = new int[answerRows];

        for (int j=0; j<N; j++) {
            for (int k=0; k<N; k++) {
                if (answer[j+k] == null) {
                    if ((j+k) <= answerRows/2) {
                        answer[j+k] = new int[j+k+1];
                    } else {
                        int size = answerRows - (j+k);
                        answer[j+k] = new int[size];
                    }
                }
                answer[j+k][indexTracker[j+k]] = A[j][k];
                indexTracker[j+k] ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] a = new int[2][];
        System.out.println(a[0]);
    }
}
